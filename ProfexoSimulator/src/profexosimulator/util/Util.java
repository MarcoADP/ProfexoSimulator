package profexosimulator.util;

import java.util.Random;

public class Util {
    
    public static String gerarTaticaAleatoria(){
        String[] listaTaticas = new String[] {
            "343", "352", "433", "442", "451", "541",
        };
        
        return listaTaticas[gerarNumeroAleatorio(0, listaTaticas.length)];
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

}
