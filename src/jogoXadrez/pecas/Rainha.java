package jogoXadrez.pecas;

public class Rainha extends Peca {
    public Rainha(int x, int y, Cor cor) {
        super(x, y, cor);
    }

    @Override
    public boolean mover(int novoX, int novoY) {
        return getX() == novoX || getY() == novoY || Math.abs(novoX - getX()) == Math.abs(novoY - getY());
    }

    @Override
    public char getIcone() {
        return cor == Cor.BRANCO ? '\u2655' : '\u265B'; // Unicode para Rainha branca e Rainha preta
    }
}
