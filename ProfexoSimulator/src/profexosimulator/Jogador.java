package profexosimulator;

import java.util.Random;

public class Jogador {
    private String nome;
    private int idade;
    private String posicao_primaria;
    private String posicao_secundaria;
    
    public final static int NUMERO_ATRIBUTOS = 7;
    
    public final static int ATR_OTIMO = 20;
    public final static int ATR_BOM = 15;
    public final static int ATR_REGULAR = 12;
    public final static int ATR_RUIM = 8;
    public final static int ATR_PESSIMO = 5;
    
    private int overall;
    private int defesa;
    private int ataque;
    private int dominio;
    private int chute;
    private int passe;
    private int reflexo;
    private int mental;
    
    public Jogador(String nome, int idade, String posicao_primaria, String posicao_secundaria) {
        this.nome = nome;
        this.idade = idade;
        this.posicao_primaria = posicao_primaria;
        this.posicao_secundaria = posicao_secundaria;
        this.overall = this.calcularOverall();
    }
    
    public Jogador(){
        this.nome = Util.gerarNomeAleatorio();
        this.posicao_primaria = Util.gerarPosicaoAleatoria();
        this.posicao_secundaria = Util.gerarPosicaoAleatoria();
        this.idade = Util.gerarNumeroAleatorio(17, 40);
        this.overall = this.calcularOverall();

    }

    public void calcularAtributos(){
        Random random = new Random();
        this.defesa = random.nextInt(20) + 1;
        this.ataque = random.nextInt(20) + 1;
        this.dominio = random.nextInt(20) + 1;
        this.chute = random.nextInt(20) + 1;
        this.passe = random.nextInt(20) + 1;
        this.reflexo = random.nextInt(20) + 1;
        this.mental = random.nextInt(20) + 1;
    }
    
    public int calcularOverall(){
        this.calcularAtributos();
        int soma = this.defesa + this.ataque + this.dominio + this.chute + this.passe + this.reflexo + this.mental;
        
        //soma  -   20*NUMATR
        //x     -   100
        //x = soma * 100/20*NUMATR
        
        int retorno = (soma*100)/(20*NUMERO_ATRIBUTOS);
        
        return retorno;
    }

    
    public void mostrarAtributos(){
        System.out.println("Jogador");
        System.out.println("Nome: " + this.nome);
        System.out.println("Posicao Primaria: " + this.posicao_primaria);
        System.out.println("Posicao Secundaria: " + this.posicao_secundaria);
        System.out.println("Overall: " + this.overall);
        System.out.println("Defesa: " + this.defesa);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Dominio: " + this.dominio);
        System.out.println("Chute: " + this.chute);
        System.out.println("Passe:" + this.passe);
        System.out.println("Reflexo: " + this.reflexo);
        System.out.println("Mental " + this.mental);
        System.out.println("");
    }
    
    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDominio() {
        return dominio;
    }

    public void setDominio(int dominio) {
        this.dominio = dominio;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getReflexo() {
        return reflexo;
    }

    public void setReflexo(int reflexo) {
        this.reflexo = reflexo;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPosicao_primaria() {
        return posicao_primaria;
    }

    public void setPosicao_primaria(String posicao_primaria) {
        this.posicao_primaria = posicao_primaria;
    }

    public String getPosicao_secundaria() {
        return posicao_secundaria;
    }

    public void setPosicao_secundaria(String posicao_secundaria) {
        this.posicao_secundaria = posicao_secundaria;
    }
    
    
    
    
    
}
