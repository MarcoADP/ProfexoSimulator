package profexosimulator.fuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfGravity;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierLeftMostMax;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierMeanMax;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.plot.JPanelFis;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Fuzzy {

    public static final String NOME_ARQUIVO = "regras_fuzzy_futebol.fcl";

    public static final String METODO_CENTRO_DE_GRAVIDADE = "Centro de Gravidade";
    public static final String METODO_PRIMEIRO_DOS_MAXIMOS = "Primeiro dos Máximos";
    public static final String METODO_MEDIA_DOS_MAXIMOS = "Média dos Máximos";

    private FIS fis;
    private JDialogFis jdf;

    public Fuzzy() {
        fis = FIS.load(NOME_ARQUIVO);

        if (fis == null) {
            System.out.println("Não foi possível abrir o arquivo: " + NOME_ARQUIVO);
            return;
        }

        if (!JFuzzyChart.UseMockClass) {
            jdf = new JDialogFisNovo(fis, 800, 600);
            jdf.setVisible(false);
        }
    }

    public void executar(double qualidadeTime, double qualidadeAdversario, double estadio, double torcida) {
        if (fis == null) {
            return;
        }

        fis.setVariable(Variavel.IN_QUALIDADE_TIME.getNome(), qualidadeTime);
        fis.setVariable(Variavel.IN_QUALIDADE_ADVERSARIO.getNome(), qualidadeAdversario);
        fis.setVariable(Variavel.IN_QUALIDADE_ESTADIO.getNome(), estadio);
        fis.setVariable(Variavel.IN_QUALIDADE_TORCIDA.getNome(), torcida);

        fis.evaluate();
        if (jdf != null) {
            jdf.repaint();
        }
    }

    public double getResultado() {
        Variable out = fis.getVariable(Variavel.OUT_POSSIBILIDADE.getNome());
        return out.getValue();
    }

    public String getInfoResultado() {
        double resultado = getResultado();

        if (resultado > 4.999 && resultado < 5.099) {
            return "Grande chance de empate.";
        } else if (resultado < 3.0) {
            return "Grande chance de derrota e pequena chance de empate.";
        } else if (resultado > 7) {
            return "Grande chance de vitória e pequena chance de empate.";
        } else {
            return "Grande chance de empate e chances de vitória e derrota.";
        }
    }

    public void mostrarGraficoVariavel(String variavel) {
        Variable var = fis.getVariable(variavel);
        JFuzzyChart.get().chart(var, true);
    }

    public void mostrarGraficoDefuzzy(String varDefuzzy) {
        Variable var = fis.getVariable(varDefuzzy);

        if (var.isOutput()) {
            JFuzzyChart.get().chart(var, var.getDefuzzifier(), true);
        }
    }

    public void setMetodoDefuzzy(String metodo) {
        Variable out = fis.getVariable(Variavel.OUT_POSSIBILIDADE.getNome());

        switch (metodo) {
            case METODO_CENTRO_DE_GRAVIDADE:
                out.setDefuzzifier(new DefuzzifierCenterOfGravity(out));
                break;
            case METODO_MEDIA_DOS_MAXIMOS:
                out.setDefuzzifier(new DefuzzifierMeanMax(out));
                break;
            case METODO_PRIMEIRO_DOS_MAXIMOS:
                out.setDefuzzifier(new DefuzzifierLeftMostMax(out));
                break;
        }
    }

    public void mostrarAnimacao() {
        jdf.setVisible(true);
        Thread t = new Thread(() -> {
            for (double i = 1; i <= 5; i += 0.1) {
                executar(i, i, i, i);

                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void setDialogFisVisible(boolean visible) {
        jdf.setVisible(visible);
    }

    public enum Variavel {

        IN_QUALIDADE_TIME("Qualidade_Time", "Péssimo", "Ruim", "Regular", "Bom", "Ótimo"),
        IN_QUALIDADE_ADVERSARIO("Qualidade_Adversario", "Juvenil", "Amador", "Normal", "Difícil", "Alemanha"),
        IN_QUALIDADE_ESTADIO("Estadio", "Varzea", "Ruim", "Jogável", "Bom", "Tapete"),
        IN_QUALIDADE_TORCIDA("Torcida", "Péssimo", "Ruim", "Regular", "Bom", "Ótimo"),
        OUT_POSSIBILIDADE("Possibilidade", "Derrota", "Empate", "Vitória");

        private final String nome;
        private final List<String> valores;

        Variavel(String nome, String... vNome) {
            this.nome = nome;
            valores = new ArrayList<>(vNome.length);
            for (String s : vNome) {
                valores.add(s);
            }
        }

        public String getNome() {
            return nome;
        }

        public List<String> getValores() {
            return valores;
        }

        public int valorToInt(String valor) {
            return valores.indexOf(valor) + 1;
        }

        @Override
        public String toString() {
            return nome;
        }
    }

    private class JDialogFisNovo extends JDialogFis {

        JPanel panel;

        public JDialogFisNovo(FIS fis) {
            super(fis);
        }

        public JDialogFisNovo(FIS fis, int width, int height) {
            super(fis, width, height);
        }

        public void init(FIS fis, int width, int height) {
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // The program may still run when the window is closed (that's why we don't use JFrame.EXIT_ON_CLOSE)
            BoxLayout layout = new BoxLayout(getContentPane(), 0);
            getContentPane().setLayout(layout);
            pack();
            panel = new JPanelFis(fis);
            setSize(width, height);
            setLayout(new BorderLayout());
            getContentPane().add(panel, BorderLayout.CENTER);
        }
    }

}
