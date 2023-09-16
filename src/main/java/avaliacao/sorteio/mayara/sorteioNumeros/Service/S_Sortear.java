package avaliacao.sorteio.mayara.sorteioNumeros.Service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class S_Sortear {


    public static Integer[] sortearNumeros(Integer quantidade, Integer inicio, Integer fim) {
        Integer[] vetorNumeros = new Integer[quantidade]; // Cria um vetor de tamanho 5 para armazenar os números sorteados
        Random random = new Random();

        for (Integer i = 0; i < quantidade; i++) {
            Integer numeroSorteado = random.nextInt(fim) + inicio; // Gera um número aleatório de 1 a 100
            vetorNumeros[i] = numeroSorteado;
        }

        return vetorNumeros;
    }



    public static Integer[] ordenarNumeros(Integer[] numerosOrdenados) {
        Arrays.sort(numerosOrdenados); // Ordena a lista em ordem crescente

        return numerosOrdenados;
    }

    public static Set<Integer> ordenarNumeros(Set<Integer> setnumeros) {
        Collections.sort(setnumeros.stream().toList()); // Ordena a lista em ordem crescente

        return setnumeros;
    }
}
