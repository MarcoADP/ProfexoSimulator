package profexosimulator.model;

import profexosimulator.util.Util;

public class Jogador {
    private String nome;
    private int idade;
    private int altura;
    private String posicao_primaria;
    //private String posicao_secundaria;

    public final static int NUMERO_ATRIBUTOS = 12;
    public final static int TIPO_ATRIBUTOS = 4;

    public final static int ATR_OTIMO = 20;
    public final static int ATR_BOM = 16;
    public final static int ATR_REGULAR = 12;
    public final static int ATR_RUIM = 10;
    public final static int ATR_PESSIMO = 8;
    public final static int ATR_CANELUDO = 7;

    private int overall;

    private int defesa;
    private int reflexo;
    private int posicionamento;

    private int ataque;
    private int chute;
    private int passe;

    private int dominio;
    private int mental;
    private int concentracao;

    private int forca;
    private int impulsao;
    private int folego;

    public Jogador(String posicao) {
        this.nome = Util.gerarNomeAleatorio();
        this.posicao_primaria = posicao;
        /*do{
            this.posicao_secundaria = Util.gerarPosicaoAleatoria();
        } while(posicao_secundaria.equals(posicao_primaria));*/

        this.idade = Util.gerarNumeroAleatorio(17, 40);
        this.altura = Util.gerarNumeroAleatorio(167, 200);
        this.overall = this.calcularOverall();
    }

    public Jogador() {
        this.nome = Util.gerarNomeAleatorio();
        this.posicao_primaria = Util.gerarPosicaoAleatoria();
        /*do{
            this.posicao_secundaria = Util.gerarPosicaoAleatoria();
        } while(posicao_secundaria.equals(posicao_primaria));*/

        this.idade = Util.gerarNumeroAleatorio(17, 40);
        this.altura = Util.gerarNumeroAleatorio(167, 200);
        this.overall = this.calcularOverall();

    }

    public void calcularAtributos(int maxDefesa, int maxOfensivo, int maxPsicologico, int maxFisico) {
        int intervalo = 4;
        int minDefesa = maxDefesa * intervalo / 10;
        int minOfensivo = maxOfensivo * intervalo / 10;
        int minPsicologico = maxPsicologico * intervalo / 10;
        int minFisico = maxFisico * intervalo / 10;

        this.defesa = Util.gerarNumeroAleatorio(minDefesa, maxDefesa);
        this.reflexo = Util.gerarNumeroAleatorio(minDefesa, maxDefesa);
        this.posicionamento = Util.gerarNumeroAleatorio(minDefesa, maxDefesa);

        this.ataque = Util.gerarNumeroAleatorio(minOfensivo, maxOfensivo);
        this.chute = Util.gerarNumeroAleatorio(minOfensivo, maxOfensivo);
        this.passe = Util.gerarNumeroAleatorio(minOfensivo, maxOfensivo);

        this.mental = Util.gerarNumeroAleatorio(minPsicologico, maxPsicologico);
        this.dominio = Util.gerarNumeroAleatorio(minPsicologico, maxPsicologico);
        this.concentracao = Util.gerarNumeroAleatorio(minPsicologico, maxPsicologico);

        this.forca = Util.gerarNumeroAleatorio(minFisico, maxFisico);
        this.folego = Util.gerarNumeroAleatorio(minFisico, maxFisico);
        this.impulsao = Util.gerarNumeroAleatorio(minFisico, maxFisico);
    }

    public void verificarPosicao() {
        int maxDefesa = 0;
        int maxOfensivo = 0;
        int maxPsicologico = 0;
        int maxFisico = 0;

        switch (this.posicao_primaria) {
            case "Goleiro":
                maxDefesa = ATR_OTIMO;  //20*3 = 60
                maxOfensivo = ATR_RUIM; //10*3 = 30
                maxPsicologico = ATR_OTIMO; //20*3 = 60
                maxFisico = ATR_BOM; //16*3 = 48 -> 198
                break;

            case "Zagueiro":
                maxDefesa = ATR_OTIMO; //60
                maxOfensivo = ATR_RUIM; //30
                maxPsicologico = ATR_REGULAR; //36
                maxFisico = ATR_OTIMO; // 60 -> 186
                break;
                
            /*case "Libero":
                maxDefesa = ATR_OTIMO; // 60
                maxOfensivo = ATR_RUIM; //30
                maxPsicologico = ATR_BOM; //48
                maxFisico = ATR_BOM; //48 186
                break;*/

            case "Lateral":
                maxDefesa = ATR_BOM;
                maxOfensivo = ATR_BOM;
                maxPsicologico = ATR_BOM;
                maxFisico = ATR_BOM; //4*48 = 192
                break;

            case "Volante":
                maxDefesa = ATR_OTIMO; //60
                maxOfensivo = ATR_REGULAR; //36
                maxPsicologico = ATR_REGULAR; //36
                maxFisico = ATR_BOM; //48 = 180
                break;

            case "Armador":
                maxDefesa = ATR_REGULAR; //36
                maxOfensivo = ATR_OTIMO; //60
                maxPsicologico = ATR_OTIMO; //60
                maxFisico = ATR_BOM; //48 = 204
                break;

            case "Meia":
                maxDefesa = ATR_BOM;
                maxOfensivo = ATR_BOM;
                maxPsicologico = ATR_BOM;
                maxFisico = ATR_BOM;
                break;

            case "Ponta":
                maxDefesa = ATR_REGULAR;
                maxOfensivo = ATR_OTIMO;
                maxPsicologico = ATR_BOM;
                maxFisico = ATR_OTIMO;
                break;

            case "Atacante":
                maxDefesa = ATR_RUIM;
                maxOfensivo = ATR_OTIMO;
                maxPsicologico = ATR_BOM;
                maxFisico = ATR_BOM;
                break;

            case "Centro Avante":
                maxDefesa = ATR_RUIM;
                maxOfensivo = ATR_OTIMO;
                maxPsicologico = ATR_OTIMO;
                maxFisico = ATR_REGULAR;

        }
        this.calcularAtributos(maxDefesa, maxOfensivo, maxPsicologico, maxFisico);
    }

    public int calcularOverall() {
        this.verificarPosicao();
        int atrDefesa = this.defesa + this.reflexo + this.posicionamento;
        int atrAtaque = this.ataque + this.chute + this.passe;
        int atrPsicologico = this.mental + this.concentracao + this.dominio;
        int atrFisico = this.folego + this.impulsao + this.forca;
        int pesoDefesa = 0;
        int pesoOfensivo = 0;
        int pesoPsicologico = 0;
        int pesoFisico = 0;
        switch (this.posicao_primaria) {
            case "Goleiro":
                pesoDefesa = 4;
                pesoOfensivo = 1;
                pesoPsicologico = 3;
                pesoFisico = 2;
                break;

            case "Zagueiro":
                pesoDefesa = 3;
                pesoOfensivo = 1;
                pesoPsicologico = 3;
                pesoFisico = 3;
                break;
                
            /*case "Libero":
                pesoDefesa = 3;
                pesoOfensivo = 1;
                pesoPsicologico = 3;
                pesoFisico = 3;
                break;*/

            case "Lateral":
                pesoDefesa = 3;
                pesoOfensivo = 3;
                pesoPsicologico = 2;
                pesoFisico = 2;
                break;

            case "Volante":
                pesoDefesa = 4;
                pesoOfensivo = 1;
                pesoPsicologico = 2;
                pesoFisico = 3;
                break;

            case "Armador":
                pesoDefesa = 1;
                pesoOfensivo = 4;
                pesoPsicologico = 4;
                pesoFisico = 1;
                break;

            case "Meia":
                pesoDefesa = 2;
                pesoOfensivo = 3;
                pesoPsicologico = 2;
                pesoFisico = 3;
                break;

            case "Ponta":
                pesoDefesa = 1;
                pesoOfensivo = 4;
                pesoPsicologico = 2;
                pesoFisico = 3;
                break;

            case "Atacante":
                pesoDefesa = 1;
                pesoOfensivo = 4;
                pesoPsicologico = 2;
                pesoFisico = 3;
                break;

            case "Centro Avante":
                pesoDefesa = 1;
                pesoOfensivo = 4;
                pesoPsicologico = 4;
                pesoFisico = 1;
                break;
        }

        int pesoTotal = pesoDefesa + pesoOfensivo + pesoPsicologico + pesoFisico;
        int soma = atrDefesa * pesoDefesa + atrAtaque * pesoOfensivo + atrPsicologico * pesoPsicologico + atrFisico * pesoFisico;

        //NUM*PesoTotal*TipoAtributos - 100
        //soma - x?
        // x 100*soma/num*20
        int media = (soma * 100) / (NUMERO_ATRIBUTOS * pesoTotal * TIPO_ATRIBUTOS);

        return media;
    }


    public void mostrarAtributos() {
        System.out.println("Nome: " + this.nome + "\tOverall: " + this.overall);
        System.out.println("Idade: " + this.idade + "\t\tAltura: " + this.altura);
        System.out.println("Posicao: " + this.posicao_primaria/* + " / " + this.posicao_secundaria*/);
        System.out.println("");

        //this.mostrarAtributosDetalhados();
    }

    public void mostrarAtributosDetalhados() {
        System.out.println("ATRIBUTOS DEFENSIVO");
        System.out.println("Defesa: " + this.defesa);
        System.out.println("Reflexo: " + this.reflexo);
        System.out.println("Posicionamento: " + this.posicionamento);

        System.out.println("\nATRIBUTOS OFENSIVOS");
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Chute: " + this.chute);
        System.out.println("Passe:" + this.passe);

        System.out.println("\nATRIBUTOS PSICOLOGICOS");
        System.out.println("Mental " + this.mental);
        System.out.println("Dominio: " + this.dominio);
        System.out.println("Concentracao: " + this.concentracao);

        System.out.println("\nATRIBUTOS FISICOS");
        System.out.println("Força: " + this.forca);
        System.out.println("Impulsão: " + this.impulsao);
        System.out.println("Folego: " + this.folego);
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

    /*public String getPosicao_secundaria() {
        return posicao_secundaria;
    }

    public void setPosicao_secundaria(String posicao_secundaria) {
        this.posicao_secundaria = posicao_secundaria;
    }*/


}
