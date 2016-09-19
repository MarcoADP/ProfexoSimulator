package profexosimulator;

import java.util.ArrayList;

public class Equipe {
    
    public final static int NUMERO_JOGADORES = 25;
    
    private String nome;
    ArrayList<Jogador> plantel;
    
    public Equipe(String nome){
        this.nome = nome;
        plantel = new ArrayList<>(NUMERO_JOGADORES);
        plantel = this.gerarJogadores();
    }

    private ArrayList<Jogador> gerarJogadores() {
        ArrayList<Jogador> elenco = new ArrayList<>(NUMERO_JOGADORES);
        int i;
        Jogador jogador;
        for(i = 0; i < NUMERO_JOGADORES; i++){
            jogador = new Jogador();
            elenco.add(jogador);
        }
        
        return elenco;
    }
    
    public void mostrarElenco(){
        int i;
        for(i = 0; i < NUMERO_JOGADORES; i++){
            Jogador jogador = plantel.get(i);
            System.out.println("Nome: " + jogador.getNome() + " Posicao: " + jogador.getPosicao_primaria());
        }
    }
    
    
}
