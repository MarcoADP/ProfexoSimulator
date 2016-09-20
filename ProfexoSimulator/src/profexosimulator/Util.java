package profexosimulator;

import java.util.Random;

public class Util {
    
    static String gerarTaticaAleatoria(){
        String[] listaTaticas = new String[] {
            "334", "343", "352", "361", "424", "433", "442", "451", "532", "541", "631"
        };
        
        return listaTaticas[gerarNumeroAleatorio(0, listaTaticas.length)];
    }
    
    static String gerarNomeAleatorio(){
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
        
        return listaNomes[gerarNumeroAleatorio(0, listaNomes.length)] + " " + listaSobrenomes[gerarNumeroAleatorio(0, listaSobrenomes.length)];
        
    }

    static int gerarNumeroAleatorio(int min, int max){
        Random random = new Random();
        int retorno = random.nextInt(max-min) + min;
        
        return retorno;
    }

    static String gerarPosicaoAleatoria(){
        String[] listaPosicoes = new String[]{"Goleiro", "Zagueiro", "Libero", "Lateral", 
            "Volante", "Armador", "Meia",
            "Ponta", "Atacante", "Centro Avante"
        };
        
        return listaPosicoes[gerarNumeroAleatorio(0, listaPosicoes.length)];
    }
    
}
