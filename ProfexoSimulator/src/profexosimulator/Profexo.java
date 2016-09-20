package profexosimulator;

import java.util.ArrayList;

public class Profexo {
    
    public final static int MENTALIDADECELSOROTH = 0;   //Retranca
    public final static int MENTALIDADEDEFENSIVA = 1;   //defensivo
    public final static int MENTALIDADENORMAL = 2;       //normal
    public final static int MENTALIDADECONTROLE = 3;    //controle de bola
    public final static int MENTALIDADEOFENSIVO = 4;    //ofensivo
    public final static int MENTALIDADESUICIDA = 5;     //super ofensivo
    
    String nome;
    int mentalide;
    String taticaPreferida;

    public Profexo(){
        this.nome = Util.gerarNomeAleatorio();
        this.mentalide = Util.gerarNumeroAleatorio(0, 6);
        this.taticaPreferida = "442";
        
    }
    
    public void mostrarProfexo(){
        System.out.println("Profexo: " + this.nome);
        System.out.println("Tatica: " + this.taticaPreferida + "\tMentalidade: " + this.converteMentalidade(this.mentalide));
        System.out.println("");
    }
    
    public String converteMentalidade(int num){
        switch(num){
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
    
}
