package profexosimulator.util;

import java.util.Random;

public class Util {

    public static final String[] TATICAS = new String[] {
            "3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-4-1",
    };
    
    public static String gerarTaticaAleatoria(){
        return TATICAS[gerarNumeroAleatorio(0, TATICAS.length)];
    }
    
    public static String gerarNomeAleatorio(){
        String[] listaNomes = new String[]{
            "André",    "Armando",          "Tonhão",       "Amaral",       "Romário", 
            "Paulo",    "Junior Baiano",    "Odvan",        "Nilson",       "Clébão", 
            "Douglas",  "Pelé",             "Rivaldo",      "Pará",         "Kléber", 
            "Fábio",    "Marco",            "Thiago",       "Jumar",        "Paulinho",
            "Tales",    "João",             "Robinho",      "Chicão",       "Bolacha",
            "Jurandir"
            
        
        }; 
        
        String[] listaSobrenomes = new String[]{ 
            "Souza",    "Santos",       "Silva",        "Almeida",      "Balada", 
            "Borges",   "Baiano",       "Camanducaia",  "Varzea",       "Camargo",
            "Batista",  "Henrique",     "Beckham",      "Alonso",       "",
            "",         "Moraes",       "Cecilio",      "Aguiar",       "Dias"
        
        };
        
        return listaNomes[gerarNumeroAleatorio(listaNomes.length)] + " " + listaSobrenomes[gerarNumeroAleatorio(listaSobrenomes.length)];
        
    }

    public static String gerarPosicaoAleatoria(){
        String[] listaPosicoes = new String[]{"Goleiro", "Zagueiro", "Lateral",
            "Volante", "Armador", "Meia",
            "Ponta", "Atacante", "Centro Avante"
        };

        return listaPosicoes[gerarNumeroAleatorio(0, listaPosicoes.length)];
    }

    public static int gerarNumeroAleatorio(int min, int max){
        Random random = new Random();
        int retorno = random.nextInt(max-min) + min;

        return retorno;
    }

    public static int gerarNumeroAleatorio(int max) {
        return gerarNumeroAleatorio(0, max);
    }

    public static double gerarDoubleAleatorio(double min, double max) {
        Random random = new Random();
        double retorno = random.nextDouble()*(max - min) + min;

        return retorno;
    }

}
