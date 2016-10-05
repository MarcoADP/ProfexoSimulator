package profexosimulator.fuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfGravity;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierLeftMostMax;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierMeanMax;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.ArrayList;
import java.util.List;

public class Fuzzy {

    public static final String NOME_ARQUIVO = "regras_fuzzy_futebol.fcl";

    public static final String VAR_INPUT_QUALIDADE_TIME = "Qualidade_Time";
    public static final String VAR_INPUT_QUALIDADE_ADVERSARIO = "Qualidade_Adversario";
    public static final String VAR_INPUT_QUALIDADE_ESTADIO = "Estadio";
    public static final String VAR_INPUT_QUALIDADE_TORCIDA = "Torcida";
    public static final String VAR_OUTPUT_POSSIBILIDADE = "Possibilidade";

    public static final String METODO_CENTRO_DE_GRAVIDADE = "Centro de Gravidade";
    public static final String METODO_PRIMEIRO_DOS_MAXIMOS = "Primeiro dos Máximos";
    public static final String METODO_MEDIA_DOS_MAXIMOS = "Média dos Máximos";

    private FIS fis;

    public Fuzzy() {
        fis = FIS.load(NOME_ARQUIVO);

        if (fis == null) {
            System.out.println("Não foi possível abrir o arquivo: " + NOME_ARQUIVO);
        }
    }

    public void executar(double qualidadeTime, double qualidadeAdversario, double estadio, double torcida) {
        if (fis == null) {
            return;
        }

        fis.setVariable(VAR_INPUT_QUALIDADE_TIME, qualidadeTime);
        fis.setVariable(VAR_INPUT_QUALIDADE_ADVERSARIO, qualidadeAdversario);
        fis.setVariable(VAR_INPUT_QUALIDADE_ESTADIO, estadio);
        fis.setVariable(VAR_INPUT_QUALIDADE_TORCIDA, torcida);

        fis.evaluate();
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
        Variable out = fis.getVariable(VAR_OUTPUT_POSSIBILIDADE);

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

    public enum Variavel {

        IN_QUALIDADE_TIME("Qualidade_Time", "Péssimo", "Ruim", "Regular", "Bom", "Ótimo"),
        IN_QUALIDADE_ADVERSARIO("Qualidade_Adversario", "Juvenil", "Amador", "Normal", "Difícil", "Alemanha"),
        IN_QUALIDADE_ESTADIO("Estadio", "Varzea", "Ruim", "Jogável", "Bom", "Tapete"),
        IN_QUALIDADE_TORCIDA("Torcida", "Péssimo", "Ruim" , "Regular", "Bom", "Ótimo"),
        OUT_POSSIBILIDADE("Possibilidade", "Derrota", "Empate", "Vitória");

        private String nome;
        private List<String> valores;

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

    //TODO: Colocar o overall geral do time na tela de elenco
}
