package profexosimulator.fuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Fuzzy {

    public static final String NOME_ARQUIVO = "regras_fuzzy_futebol.fcl";

    public static final String VAR_INPUT_QUALIDADE_TIME = "Qualidade_Time";
    public static final String VAR_INPUT_QUALIDADE_ADVERSARIO = "Qualidade_Adversario";
    public static final String VAR_INPUT_QUALIDADE_ESTADIO = "Estadio";
    public static final String VAR_INPUT_QUALIDADE_TORCIDA = "Torcida";
    public static final String VAR_OUTPUT_POSSIBILIDADE = "Possibilidade";

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
        JFuzzyChart.get().chart(var, var.getDefuzzifier(), true);
    }
}
