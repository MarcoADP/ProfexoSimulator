/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profexosimulator;

/**
 *
 * @author marvin
 */
public class ProfexoSimulator {

    /**
     * @param args the command line arguments
     */
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
