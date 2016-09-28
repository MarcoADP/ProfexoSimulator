package profexosimulator.util;

import java.util.Random;

public class Util {

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

    public static String gerarNomeTimeAleatorio() {
        String[] times = { "Atlético-PR", "Atlético-MG", "Botafogo", "Coritiba",
                "Cruzeiro", "Figueirense", "Flamengo", "Fluminense",
                "Goiás", "Grêmio", "Internacional", "Ipatinga",
                "Náutico", "Palmeiras", "Portuguesa", "Santos",
                "Sport", "São Paulo", "Vasco", "Vitória",
        };
        return times[gerarNumeroAleatorio(times.length)];
    }

    public static String gerarPosicaoAleatoria(){
        String[] listaPosicoes = new String[]{"Goleiro", "Zagueiro", "Lateral",
            "Volante", "Armador", "Meia",
            "Ponta", "Atacante", "Centro Avante"
        };

        return listaPosicoes[gerarNumeroAleatorio(listaPosicoes.length)];
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
