package profexosimulator.model;

import profexosimulator.model.Profexo.Mentalidade;

import java.util.*;

public class Equipe {

    public final static int NUMERO_JOGADORES = 25;

    private String nome;
    private List<Jogador> plantel;
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
    private Mentalidade mentalidadeAtual;
    private List<Jogador> escalacao;

    public Equipe(String nome, Profexo profexo) {
        this.nome = nome;
        this.profexo = profexo;
        this.formarElenco();
        this.escalacao = new ArrayList<>(11);
    }

    public void escalarTime() {
        this.taticaAtual = this.profexo.getTaticaPreferida().getTatica();
        this.mentalidadeAtual = this.profexo.getMentalide();
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
        switch (this.taticaAtual.charAt(2)) {
            case '3':
                if (this.mentalidadeAtual.getNum() > 2) {
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
        switch (this.taticaAtual.charAt(4)) {
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
                if (this.mentalidadeAtual.getNum() > 2) {
                    this.escalarJogador("Centro Avante");
                } else {
                    this.escalarJogador("Atacante");
                }
                break;
        }
    }

    private void escalarJogador(String posicao) {
        Optional<Jogador> escolhido = plantel.stream()
                .filter(jogador -> jogador.getPosicao().equals(posicao))
                .filter(jogador -> !isEscalado(jogador))
                .max(Comparator.comparing(Jogador::getOverall));

        escolhido.ifPresent(jogador -> escalacao.add(jogador)); // Adiciona jogador escolhido se estiver presente (diferente de null)
    }

    private boolean isEscalado(Jogador jogador) {
        return escalacao.contains(jogador);
    }

    private int calcularOverallEquipe() {
        OptionalDouble media = plantel.stream().mapToInt(Jogador::getOverall).average();
        return (int) media.orElse(0.0); // Retorna a média calculada OU 0.0 se o valor não estiver presente
    }

    public void formarElenco() {
        this.numElenco = this.numGoleiro + this.numZagueiro + this.numLateral + this.numVolante + this.numMeia + this.numArmador + this.numPonta + this.numAtacante + this.numCentroAvante;
        this.plantel = new ArrayList<>();

        this.adicionarJogador("Goleiro", numGoleiro); //2

        this.adicionarJogador("Zagueiro", numZagueiro);
        this.adicionarJogador("Lateral", numLateral); //8 //10

        this.adicionarJogador("Volante", numVolante);
        this.adicionarJogador("Meia", numMeia);
        this.adicionarJogador("Armador", numArmador); //8 //18

        this.adicionarJogador("Ponta", numPonta);
        this.adicionarJogador("Atacante", numAtacante);
        this.adicionarJogador("Centro Avante", numCentroAvante); //7 //25

        this.overallEquipe = this.calcularOverallEquipe();
    }

    public void adicionarJogador(String posicao, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            this.plantel.add(new Jogador(posicao));
        }
    }

    public void mostrarEquipe() {
        System.out.println("Equipe: " + this.nome);
        System.out.println("Capacidade: " + this.overallEquipe);
        this.profexo.mostrarProfexo();
        this.mostrarEscalacao();
    }

    public void mostrarEscalacao() {
        System.out.println("Tatica:" + this.taticaAtual);
        System.out.println("Mentalidade: " + this.mentalidadeAtual);
        System.out.println();
        escalacao.forEach(System.out::println);
    }

    public void mostrarElenco() {
        plantel.forEach(Jogador::mostrarAtributos);
    }

    public List<Jogador> getPlantel() {
        return plantel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Profexo getProfexo() {
        return profexo;
    }

    public void setProfexo(Profexo profexo) {
        this.profexo = profexo;
    }
}
