package jogoXadrez;
import java.util.Scanner;
import jogoXadrez.tabuleiro.Tabuleiro;

public class Main {
    private static int converterColunaParaIndice(char coluna) {
        return coluna - 'a';
    }

    private static int converterLinhaParaIndice(int linha) {
        return 8 - linha;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Tabuleiro tabuleiro = new Tabuleiro();

            while (true) {
                tabuleiro.limparTela();
                System.out.println("\nTabuleiro atual:");
                tabuleiro.imprimirTabuleiro();

                System.out.println("Digite a posição da peça que deseja mover (linha(num) coluna(letra)):");
                int linhaOrigem = scanner.nextInt();
                char colunaOrigemLetra = scanner.next().charAt(0);
                int colunaOrigem = converterColunaParaIndice(colunaOrigemLetra);
                int linhaOrigemIndice = converterLinhaParaIndice(linhaOrigem);

                System.out.println("Digite a nova posição (novaLinha novaColuna):");
                int novaLinha = scanner.nextInt();
                char novaColunaLetra = scanner.next().charAt(0);
                int novaColuna = converterColunaParaIndice(novaColunaLetra);
                int novaLinhaIndice = converterLinhaParaIndice(novaLinha);

                if (!tabuleiro.moverPeca(linhaOrigemIndice, colunaOrigem, novaLinhaIndice, novaColuna)) {
                    System.out.println("Movimento inválido, tente novamente.");
                }
            }
        }
    }
}
