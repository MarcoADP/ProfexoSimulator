package profexosimulator.fuzzy;

import profexosimulator.model.Equipe;
import profexosimulator.model.Profexo;
import profexosimulator.util.Util;

public class Simulador {

    private Equipe equipeJogador;
    private Equipe equipeAdversario;

    public Simulador() {

    }

    public void iniciarEquipes(Equipe equipeJogador) {
        this.equipeJogador = equipeJogador;

        if (equipeAdversario == null) {
            equipeAdversario = new Equipe(Util.gerarNomeTimeAleatorio(), new Profexo());
        }
    }

    public Equipe getEquipeJogador() {
        return equipeJogador;
    }

    public Equipe getEquipeAdversario() {
        return equipeAdversario;
    }
}
