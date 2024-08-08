package jogoXadrez.pecas;

public class Cavalo extends Peca {
    public Cavalo(int x, int y, Cor cor) {
        super(x, y, cor);
    }

    @Override
    public boolean mover(int novoX, int novoY) {
        return (Math.abs(novoX - x) == 2 && Math.abs(novoY - y) == 1) ||
               (Math.abs(novoX - x) == 1 && Math.abs(novoY - y) == 2);
    }

    @Override
    public char getIcone() {
        return cor == Cor.BRANCO ? '\u2658' : '\u265E'; // Unicode para Cavalo branco e Cavalo preto
    }
}
