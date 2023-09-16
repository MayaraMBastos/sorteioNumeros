package avaliacao.sorteio.mayara.sorteioNumeros.Service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class S_Sortear {


    public static int[] sortearNumeros(int quantidade, int inicio, int fim) {
        int[] vetorNumeros = new int[quantidade]; // Cria um vetor de tamanho 5 para armazenar os números sorteados
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int numeroSorteado = random.nextInt(fim) + inicio; // Gera um número aleatório de 1 a 100
            vetorNumeros[i] = numeroSorteado;
        }

        return vetorNumeros;
    }

    public static int[] sortearNumerosSemRepetir(int quantidade, int inicio, int fim) {
        if (quantidade > fim) {
            throw new IllegalArgumentException("A quantidade de números a serem sorteados não pode ser maior que o limite.");
        }

        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();

        while (numerosSorteados.size() < quantidade) {
            int numeroSorteado = random.nextInt(fim) + inicio; // Gera um número aleatório entre 1 e o limite
            numerosSorteados.add(numeroSorteado);
        }

        // Converter o Set em um vetor
        int[] vetorNumeros = new int[quantidade];
        int index = 0;
        for (int numero : numerosSorteados) {
            vetorNumeros[index++] = numero;
        }

        return vetorNumeros;
    }


    public static int[] ordenarNumeros(int[] numerosOrdenados) {
        Arrays.sort(numerosOrdenados); // Ordena a lista em ordem crescente

        return numerosOrdenados;
    }


}
