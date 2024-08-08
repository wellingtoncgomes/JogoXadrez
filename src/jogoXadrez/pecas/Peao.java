package jogoXadrez.pecas;

public class Peao extends Peca {
    public Peao(int x, int y, Cor cor) {
        super(x, y, cor);
    }

    @Override
    public boolean mover(int novoX, int novoY) {
        return y == novoY && (novoX - x == 1 || (x == 1 && novoX - x == 2));
    }

    @Override
    public char getIcone() {
        return cor == Cor.BRANCO ? '\u2659' : '\u265F'; // Unicode para Peão branco e Peão preto
    }
}
