package profexosimulator.model;

import profexosimulator.util.Util;

import static profexosimulator.util.Util.gerarNumeroAleatorio;

public class Profexo {

    public enum Mentalidade {
        CELSO_ROTH("Celso Roth - Retranca", 0),  //Retranca
        DEFENSIVA("Defensiva", 1),               //defensivo
        NORMAL("Normal", 2),                     //normal
        CONTROLE("Controle de Bola", 3),         //controle de bola
        OFENSIVO("Ofensivo", 4),                 //ofensivo
        SUICIDA("Suicida", 5);                   //super ofensivo

        private String nome;
        private int num;

        Mentalidade(String nome, int num) {
            this.nome = nome;
            this.num = num;
        }

        public String getNome() {
            return nome;
        }

        public int getNum() {
            return num;
        }

        @Override
        public String toString() {
            return nome;
        }
    }

    private String nome;
    private Mentalidade mentalide;
    private String taticaPreferida;

    public Profexo() {
        this.nome = Util.gerarNomeAleatorio();
        this.mentalide = gerarMentalidadeAleatorio();
        this.taticaPreferida = Util.gerarTaticaAleatoria();
        //this.taticaPreferida = "442";
    }

    public void mostrarProfexo() {
        System.out.println("Profexo: " + this.nome);
        System.out.println("Tatica: " + this.taticaPreferida + "\tMentalidade: " + this.mentalide);
        System.out.println("");
    }

    private Mentalidade gerarMentalidadeAleatorio() {
        Mentalidade[] mentalidades = Mentalidade.values();
        return mentalidades[gerarNumeroAleatorio(mentalidades.length)];
    }

    public String getNome() {
        return nome;
    }

    public Mentalidade getMentalide() {
        return mentalide;
    }

    public String getTaticaPreferida() {
        return taticaPreferida;
    }
}
