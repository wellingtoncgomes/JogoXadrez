package jogoXadrez.pecas;

public class Bispo extends Peca {
    public Bispo(int x, int y, Cor cor) {
        super(x, y, cor);
    }

    @Override
    public boolean mover(int novoX, int novoY) {
        return Math.abs(novoX - x) == Math.abs(novoY - y);
    }

    @Override
    public char getIcone() {
        return cor == Cor.BRANCO ? '\u2657' : '\u265D'; // Unicode para Bispo branco e Bispo preto
    }
}
