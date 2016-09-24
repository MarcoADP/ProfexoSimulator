package profexosimulator;

import profexosimulator.model.Equipe;
import profexosimulator.model.Profexo;

public class ProfexoSimulator {

    public static void main(String[] args) {
        //String nome = "Odvan";
        //String posicao1 = "Zagueiro";
        //String posicao2 = "Líbero";
        //int idade = 35;
        //Jogador Odvan = new Jogador(nome, idade, posicao1);
        //Odvan.mostrarAtributos();

        //Jogador jog1 = new Jogador();
        //jog1.mostrarAtributos();

        Equipe equipe = new Equipe("Portuguesa", new Profexo());
        //equipe.mostrarEquipe();
        equipe.escalarTime();
        equipe.mostrarEscalacao();
        //equipe.mostrarEquipe();
    }

}
