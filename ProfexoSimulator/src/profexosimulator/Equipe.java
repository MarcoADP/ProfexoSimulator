package profexosimulator;

import java.util.ArrayList;

public class Equipe {
    
    public final static int NUMERO_JOGADORES = 25;
    
    private String nome;
    ArrayList<Jogador> plantel;
    Profexo profexo;
    int overallEquipe;
    
    int numElenco;
    
    int numGoleiro = 2;
    int numZagueiro = 4;
    int numLateral = 4; //10
    
    int numVolante = 3;
    int numArmador = 2;
    int numMeia = 3;    //8
    
    int numPonta = 3;
    int numAtacante = 2;
    int numCentroAvante = 2; //7
            
    public Equipe(String nome, Profexo profexo){
        this.nome = nome;
        this.profexo = profexo;
        this.formarElenco();
        this.overallEquipe = this.calcularOverallEquipe();
    }
    
    public Equipe(String nome, Profexo profexo, int goleiro, int zagueiro, int lateral, int volante, int meia, int armador, int ponta, int atacante, int centroavante){
        this.nome = nome;
        this.profexo = profexo;
        this.numGoleiro = goleiro;
        this.numZagueiro = zagueiro;
        this.numLateral = lateral;
        this.numVolante = volante;
        this.numMeia = meia;
        this.numArmador = armador;
        this.numPonta = ponta;
        this.numAtacante = atacante;
        this.numCentroAvante = centroavante;
        
        this.overallEquipe = this.calcularOverallEquipe();
        
    }

    private int calcularOverallEquipe(){
        int soma = 0;
        for(Jogador jogador : this.plantel){
            soma += jogador.getOverall();
        }
        //System.out.println("EQUIPE: " + this.numElenco + " TAMANHO: " + this.plantel.size());
        soma = soma / this.plantel.size();
        return soma;
    }
    
    private void formarElenco() {
        
        this.numElenco = this.numGoleiro + this.numZagueiro + this.numLateral + this.numVolante + this.numMeia + this.numArmador + this.numPonta + this.numAtacante + this.numCentroAvante;
        this.plantel = new ArrayList<>();
        
        this.adicionarJogador("Goleiro", numGoleiro); //2
        
        this.adicionarJogador("Zagueiro", numZagueiro);
        //this.adicionarJogador("Libero", 2);
        this.adicionarJogador("Lateral", numLateral); //8 //10
        
        this.adicionarJogador("Volante", numVolante);
        this.adicionarJogador("Meia", numMeia);
        this.adicionarJogador("Armador", numArmador); //8 //18
        
        this.adicionarJogador("Ponta", numPonta);
        this.adicionarJogador("Atacante", numAtacante);
        this.adicionarJogador("Centro Avante", numCentroAvante); //7 //25
 
    }
    
    public void adicionarJogador(String posicao, int quantidade){
        int i;
        for(i = 0; i < quantidade; i++){
            //System.out.println(posicao + "  " + this.plantel.size());
            this.plantel.add(new Jogador(posicao));
        }
    }
    
    public void mostrarEquipe(){
        System.out.println("Equipe: " + this.nome);
        System.out.println("Capacidade: " + this.overallEquipe);
        this.profexo.mostrarProfexo();
        this.mostrarElenco();
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
