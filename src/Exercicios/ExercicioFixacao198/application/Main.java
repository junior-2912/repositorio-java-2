package Exercicios.ExercicioFixacao198.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Define o caminho do arquivo de entrada contendo dados de votos
        String path = "c:\\windows\\temp\\in.txt";

        // Cria um Map para armazenar os votos com a chave sendo o nome e o valor sendo a quantidade de votos
        Map<String, Integer> votos = new HashMap<>();

        // Try-with-resources: abre o arquivo e garante o fechamento automático dos recursos
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String linha;

            // Lê cada linha do arquivo até encontrar o final (null)
            while ((linha = bf.readLine()) != null) {
                // Divide a linha pelo delimitador "," para extrair o nome e os votos
                String[] infos = linha.split(",");

                // Verifica se o nome (primeira parte) já existe no mapa
                if (votos.containsKey(infos[0])) {
                    // Se existe, soma os votos anteriores com os novos votos
                    votos.put(infos[0], votos.get(infos[0]) + Integer.parseInt(infos[1]));
                } else {
                    // Se não existe, adiciona uma nova entrada com o nome e quantidade de votos
                    votos.put(infos[0], Integer.parseInt(infos[1]));
                }
            }

            // Itera sobre todas as chaves do mapa e exibe o resultado
            for (String key : votos.keySet()) {
                System.out.println(key + " - " + votos.get(key));
            }
        } catch (IOException e) {
            // Trata exceções de entrada/saída (arquivo não encontrado, erro ao ler, etc)
            System.out.println(e.getMessage());
        }
    }
}