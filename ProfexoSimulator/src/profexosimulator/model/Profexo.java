package profexosimulator.model;

import profexosimulator.util.Util;

import static profexosimulator.util.Util.gerarNumeroAleatorio;

public class Profexo {

    public enum Mentalidade {
        CELSO_ROTH("Celso Roth - Retranca", 0),  //Retranca
        DEFENSIVA("Defensiva", 1),               //defensivo
        NORMAL("Normal", 2),                     //normal
        CONTROLE("Controle de Bola", 3),         //controle de bola
        OFENSIVO("Ofensivo", 4);                 //ofensivo
        //SUICIDA("Suicida", 5);                   //super ofensivo

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

    public enum Tatica {
        T_343("3-4-3"),
        T_352("3-5-2"),
        T_433("4-3-3"),
        T_442("4-4-2"),
        T_451("4-5-1"),
        T_541("5-4-1");

        private String tatica;

        Tatica(String tatica) {
            this.tatica = tatica;
        }

        public String getTatica() {
            return tatica;
        }

        @Override
        public String toString() {
            return tatica;
        }
    }

    private String nome;
    private Mentalidade mentalide;
    private Tatica taticaPreferida;

    public Profexo() {
        this.nome = Util.gerarNomeAleatorio();
        this.mentalide = gerarMentalidadeAleatoria();
        this.taticaPreferida = gerarTaticaAleatoria();
    }

    public Profexo(String nome, Mentalidade mentalide, Tatica taticaPreferida) {
        this.nome = nome;
        this.mentalide = mentalide;
        this.taticaPreferida = taticaPreferida;
    }

    public void mostrarProfexo() {
        System.out.println("Profexo: " + this.nome);
        System.out.println("Tatica: " + this.taticaPreferida + "\tMentalidade: " + this.mentalide);
        System.out.println("");
    }

    private Mentalidade gerarMentalidadeAleatoria() {
        Mentalidade[] mentalidades = Mentalidade.values();
        return mentalidades[gerarNumeroAleatorio(mentalidades.length)];
    }

    private Tatica gerarTaticaAleatoria() {
        Tatica[] taticas = Tatica.values();
        return taticas[gerarNumeroAleatorio(taticas.length)];
    }

    public String getNome() {
        return nome;
    }

    public Mentalidade getMentalide() {
        return mentalide;
    }

    public Tatica getTaticaPreferida() {
        return taticaPreferida;
    }
}
