package jogoXadrez.tabuleiro;

import jogoXadrez.pecas.Bispo;
import jogoXadrez.pecas.Cavalo;
import jogoXadrez.pecas.Peao;
import jogoXadrez.pecas.Peca;
import jogoXadrez.pecas.Rainha;
import jogoXadrez.pecas.Rei;
import jogoXadrez.pecas.Torre;

public class Tabuleiro {
    private Peca[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new Peca[8][8];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        // Inicializa as peças brancas
        tabuleiro[0][0] = new Torre(0, 0, Peca.Cor.BRANCO);
        tabuleiro[0][1] = new Cavalo(0, 1, Peca.Cor.BRANCO);
        tabuleiro[0][2] = new Bispo(0, 2, Peca.Cor.BRANCO);
        tabuleiro[0][3] = new Rainha(0, 3, Peca.Cor.BRANCO);
        tabuleiro[0][4] = new Rei(0, 4, Peca.Cor.BRANCO);
        tabuleiro[0][5] = new Bispo(0, 5, Peca.Cor.BRANCO);
        tabuleiro[0][6] = new Cavalo(0, 6, Peca.Cor.BRANCO);
        tabuleiro[0][7] = new Torre(0, 7, Peca.Cor.BRANCO);
        for (int i = 0; i < 8; i++) {
            tabuleiro[1][i] = new Peao(1, i, Peca.Cor.BRANCO);
        }

        // Inicializa as peças pretas
        tabuleiro[7][0] = new Torre(7, 0, Peca.Cor.PRETO);
        tabuleiro[7][1] = new Cavalo(7, 1, Peca.Cor.PRETO);
        tabuleiro[7][2] = new Bispo(7, 2, Peca.Cor.PRETO);
        tabuleiro[7][3] = new Rainha(7, 3, Peca.Cor.PRETO);
        tabuleiro[7][4] = new Rei(7, 4, Peca.Cor.PRETO);
        tabuleiro[7][5] = new Bispo(7, 5, Peca.Cor.PRETO);
        tabuleiro[7][6] = new Cavalo(7, 6, Peca.Cor.PRETO);
        tabuleiro[7][7] = new Torre(7, 7, Peca.Cor.PRETO);
        for (int i = 0; i < 8; i++) {
            tabuleiro[6][i] = new Peao(6, i, Peca.Cor.PRETO);
        }
    }

    public Peca getPeca(int linha, int coluna) {
        if (linha < 0 || linha >= 8 || coluna < 0 || coluna >= 8) {
            throw new IllegalArgumentException("Posição fora do tabuleiro");
        }
        return tabuleiro[linha][coluna];
    }

    public void adicionarPeca(Peca peca, int linha, int coluna) {
        if (linha < 0 || linha >= 8 || coluna < 0 || coluna >= 8) {
            throw new IllegalArgumentException("Posição fora do tabuleiro");
        }
        tabuleiro[linha][coluna] = peca;
    }

    public boolean moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        if (linhaOrigem < 0 || linhaOrigem >= 8 || colunaOrigem < 0 || colunaOrigem >= 8 ||
            linhaDestino < 0 || linhaDestino >= 8 || colunaDestino < 0 || colunaDestino >= 8) {
            throw new IllegalArgumentException("Movimento fora do tabuleiro");
        }

        Peca pecaMovida = tabuleiro[linhaOrigem][colunaOrigem];
        if (pecaMovida == null || !pecaMovida.mover(linhaDestino, colunaDestino)) {
            return false;
        }

        tabuleiro[linhaOrigem][colunaOrigem] = null;
        tabuleiro[linhaDestino][colunaDestino] = pecaMovida;
        pecaMovida.setX(linhaDestino);
        pecaMovida.setY(colunaDestino); 
        return true;
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void imprimirTabuleiro() {
        final int larguraCelula = 8; // Largura de cada célula no tabuleiro
        
        // Imprime o rótulo das colunas
        System.out.print("   "); // Espaço para o rótulo das linhas
        for (int j = 0; j < 8; j++) {
            System.out.print(String.format("%" + larguraCelula + "s", (char) ('A' + j)));
        }
        System.out.println();

        // Imprime o tabuleiro
        for (int i = 0; i < 8; i++) {
            // Rótulo da linha
            System.out.print(String.format("%2d ", 8 - i));
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j] == null) {
                    System.out.print(String.format("|%" + (larguraCelula - 1) + "s", "  ")); // Espaço vazio
                } else {
                    System.out.print(String.format("|%" + (larguraCelula - 1) + "s", tabuleiro[i][j].getIcone()));
                }
            }
            System.out.println("|");

            // Linha divisória
            System.out.print("   ");
            for (int j = 0; j < 8; j++) {
                System.out.print("+" + "-".repeat(larguraCelula - 1));
            }
            System.out.println("+");
        }
    }
}
