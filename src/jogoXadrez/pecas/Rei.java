package jogoXadrez.pecas;

public class Rei extends Peca {
    public Rei(int x, int y, Cor cor) {
        super(x, y, cor);
    }

    @Override
    public boolean mover(int novoX, int novoY) {
        return Math.abs(novoX - getX()) <= 1 && Math.abs(novoY - getY()) <= 1;
    }

    @Override
    public char getIcone() {
        return cor == Cor.BRANCO ? '\u2654' : '\u265A'; // Unicode para Rei branco e Rei preto
    }
}