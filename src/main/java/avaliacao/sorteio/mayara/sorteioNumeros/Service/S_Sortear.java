package avaliacao.sorteio.mayara.sorteioNumeros.Service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class S_Sortear {

    public static int[] sortearNumeros(int quantidade, int inicio, int fim, boolean ordenar, boolean repeticao) {
        int[] vetorNumeros = new int[quantidade];
        Random random = new Random();

        if (repeticao == false) { // if sem repetir numeros

//            if (quantidade > fim) { // quantidade nao deve ser maior que o limite: erro 500
//                throw new IllegalArgumentException(
//                        "A quantidade de números a serem sorteados não pode ser maior que o limite.");
//            }

            Set<Integer> numerosSorteados = new HashSet<>();

            while (numerosSorteados.size() < quantidade) {
                //int numeroSorteado = random.nextInt(fim) + inicio; // Gera um número aleatório entre 1 e o limite
                int numeroSorteado = random.nextInt(fim - inicio + 1) + inicio;
                numerosSorteados.add(numeroSorteado);
            }

            int index = 0;
            for (int numero : numerosSorteados) {
                vetorNumeros[index++] = numero;
            }
        } else { // senao pode repetir numeros

            for (int i = 0; i < quantidade; i++) {
                //int numeroSorteado = random.nextInt(fim) + inicio;// Gera um número aleatório de 1 a 100
                int numeroSorteado = random.nextInt(fim - inicio + 1) + inicio;
                vetorNumeros[i] = numeroSorteado;
            }
        }

        if (ordenar == true) { // if para ordenação
            vetorNumeros = ordenarNumeros(vetorNumeros);
        }

        return vetorNumeros;
    }

    public static int[] ordenarNumeros(int[] numerosOrdenados) {
         return Arrays.stream(numerosOrdenados).sorted().toArray();
    }

}
