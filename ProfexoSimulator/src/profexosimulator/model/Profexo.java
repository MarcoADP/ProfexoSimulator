package profexosimulator.model;

import profexosimulator.util.Util;

public class Profexo {

    public final static int MENTALIDADE_CELSOROTH = 0;   //Retranca
    public final static int MENTALIDADE_DEFENSIVA = 1;   //defensivo
    public final static int MENTALIDADE_NORMAL = 2;       //normal
    public final static int MENTALIDADE_CONTROLE = 3;    //controle de bola
    public final static int MENTALIDADE_OFENSIVO = 4;    //ofensivo
    public final static int MENTALIDADE_SUICIDA = 5;     //super ofensivo

    private String nome;
    private int mentalide;
    private String taticaPreferida;

    public Profexo() {
        this.nome = Util.gerarNomeAleatorio();
        this.mentalide = Util.gerarNumeroAleatorio(0, 6);
        this.taticaPreferida = Util.gerarTaticaAleatoria();
        //this.taticaPreferida = "442";

    }

    public void mostrarProfexo() {
        System.out.println("Profexo: " + this.nome);
        System.out.println("Tatica: " + this.taticaPreferida + "\tMentalidade: " + this.converteMentalidade(this.mentalide));
        System.out.println("");
    }

    public String converteMentalidade(int num) {
        switch (num) {
            case 0:
                return "Celso Roth";
            case 1:
                return "Defensivo";
            case 2:
                return "Normal";
            case 3:
                return "Controle";
            case 4:
                return "Ofensivo";
            default:
                return "Suicida";
        }
    }

    public String getNome() {
        return nome;
    }

    public int getMentalide() {
        return mentalide;
    }

    public String getTaticaPreferida() {
        return taticaPreferida;
    }
}
