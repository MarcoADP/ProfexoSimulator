package profexosimulator.model;

import java.util.ArrayList;

public class Equipe {

    public final static int NUMERO_JOGADORES = 25;

    private String nome;
    private ArrayList<Jogador> plantel;
    private Profexo profexo;
    private int overallEquipe;

    private int numElenco;

    private int numGoleiro = 2;
    private int numZagueiro = 4;
    private int numLateral = 4; //10

    private int numVolante = 3;
    private int numArmador = 2;
    private int numMeia = 3;    //8

    private int numPonta = 3;
    private int numAtacante = 2;
    private int numCentroAvante = 2; //7

    private String taticaAtual;
    private int mentalidadeAtual;
    private ArrayList<Jogador> escalacao;

    public Equipe(String nome, Profexo profexo) {
        this.nome = nome;
        this.profexo = profexo;
        this.formarElenco();
        this.overallEquipe = this.calcularOverallEquipe();
        this.escalacao = new ArrayList(11);
    }

    public Equipe(String nome, Profexo profexo, int goleiro, int zagueiro, int lateral, int volante, int meia, int armador, int ponta, int atacante, int centroavante) {
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

    public void escalarTime() {
        this.taticaAtual = this.profexo.getTaticaPreferida();
        this.mentalidadeAtual = this.profexo.getMentalide();
        //System.out.println("Tatica: " + this.taticaAtual);
        this.escalarJogador("Goleiro");
        switch (this.taticaAtual.charAt(0)) {
            case '3':
                this.escalarJogador("Zagueiro");
                this.escalarJogador("Zagueiro");
                this.escalarJogador("Zagueiro");
                break;
            case '4':
                this.escalarJogador("Lateral");
                this.escalarJogador("Lateral");
                this.escalarJogador("Zagueiro");
                this.escalarJogador("Zagueiro");
                break;
            case '5':
                this.escalarJogador("Lateral");
                this.escalarJogador("Lateral");
                this.escalarJogador("Zagueiro");
                this.escalarJogador("Zagueiro");
                this.escalarJogador("Zagueiro");

        }
        switch (this.taticaAtual.charAt(1)) {
            case '3':
                if (this.mentalidadeAtual > 2) {
                    this.escalarJogador("Armador");
                } else {
                    this.escalarJogador("Volante");
                }
                this.escalarJogador("Meia");
                this.escalarJogador("Meia");
                break;
            case '4':
                this.escalarJogador("Volante");
                this.escalarJogador("Meia");
                this.escalarJogador("Meia");
                this.escalarJogador("Armador");
                break;
            case '5':
                this.escalarJogador("Volante");
                this.escalarJogador("Volante");
                this.escalarJogador("Meia");
                this.escalarJogador("Meia");
                this.escalarJogador("Armador");
                break;
        }
        switch (this.taticaAtual.charAt(2)) {
            case '1':
                this.escalarJogador("Centro Avante");
                break;
            case '2':
                this.escalarJogador("Atacante");
                this.escalarJogador("Centro Avante");
                break;
            case '3':
                this.escalarJogador("Ponta");
                this.escalarJogador("Ponta");
                if (this.mentalidadeAtual > 2) {
                    this.escalarJogador("Centro Avante");
                } else {
                    this.escalarJogador("Atacante");
                }
                break;
        }
    }

    private void escalarJogador(String posicao) {
        Jogador escolhido = null;
        for (Jogador jogador : this.plantel) {
            if (jogador.getPosicao_primaria().equals(posicao)) {
                if (escolhido == null || jogador.getOverall() > escolhido.getOverall()) {
                    if (!isEscalado(jogador)) {
                        escolhido = jogador;
                    }
                }

            }
        }
        //System.out.println(escolhido.getNome());
        this.escalacao.add(escolhido);
    }

    private boolean isEscalado(Jogador jogador) {
        if (this.escalacao.isEmpty()) {
            return false;
        }
        for (Jogador jog1 : this.escalacao) {
            if (jog1.equals(jogador)) {
                return true;
            }
        }
        return false;
    }

    private int calcularOverallEquipe() {
        int soma = 0;
        for (Jogador jogador : this.plantel) {
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

    public void adicionarJogador(String posicao, int quantidade) {
        int i;
        for (i = 0; i < quantidade; i++) {
            //System.out.println(posicao + "  " + this.plantel.size());
            this.plantel.add(new Jogador(posicao));
        }
    }

    public void mostrarEquipe() {
        System.out.println("Equipe: " + this.nome);
        System.out.println("Capacidade: " + this.overallEquipe);
        this.profexo.mostrarProfexo();
        this.mostrarEscalacao();
        //this.mostrarElenco();
    }

    public void mostrarEscalacao() {
        System.out.println("Tatica:" + this.taticaAtual);
        System.out.println("Mentalidade: " + this.mentalidadeAtual);
        System.out.println("");
        //String posAnterior = "Goleiro";
        if (!this.escalacao.isEmpty()) {
            for (Jogador jogador : this.escalacao) {
                /*if(!posAnterior.equals(jogador.getPosicao_primaria())){
                    System.out.println("");
                }*/
                //posAnterior = jogador.getPosicao_primaria();
                System.out.println(jogador.getPosicao_primaria() + ": " + jogador.getNome() + " " + jogador.getOverall());
            }
        }
    }

    public void mostrarElenco() {
        int i;

        for (Jogador jogador : plantel) {
            // System.out.println("Nome: " + jogador.getNome() + "\tPosicao: " + jogador.getPosicao_primaria() +
            //         "\tOverall: "+ jogador.getOverall());
            jogador.mostrarAtributos();
        }
    }


}
