package profexosimulator;

import java.util.ArrayList;

public class Equipe {
    
    public final static int NUMERO_JOGADORES = 25;
    
    private String nome;
    ArrayList<Jogador> plantel;
    
    public Equipe(String nome){
        this.nome = nome;
        plantel = new ArrayList<>(NUMERO_JOGADORES);
        this.formarElenco();
    }

    private void formarElenco() {
        int i;
        Jogador jogador;
        
        this.adicionarJogador("Goleiro", 2); //2
        
        this.adicionarJogador("Zagueiro", 3);
        this.adicionarJogador("Libero", 2);
        this.adicionarJogador("Lateral", 3); //8 //10
        
        this.adicionarJogador("Volante", 3);
        this.adicionarJogador("Meia", 3);
        this.adicionarJogador("Armador", 2); //8 //18
        
        this.adicionarJogador("Ponta", 3);
        this.adicionarJogador("Atacante", 2);
        this.adicionarJogador("Centro Avante", 2); //7 //25
 
    }
    
    public void adicionarJogador(String posicao, int quantidade){
        int i;
        for(i = 0; i <= quantidade; i++){
            this.plantel.add(new Jogador(posicao));
        }
    }
    
    public void mostrarElenco(){
        int i;
        
        for(Jogador jogador : plantel){
           // System.out.println("Nome: " + jogador.getNome() + "\tPosicao: " + jogador.getPosicao_primaria() + 
           //         "\tOverall: "+ jogador.getOverall());
           jogador.mostrarAtributos();
        }
    }
    
    
}
