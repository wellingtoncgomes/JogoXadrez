package jogoXadrez.pecas;

public class Torre extends Peca {
    public Torre(int x, int y, Cor cor) {
        super(x, y, cor);
    }

    @Override
    public boolean mover(int novoX, int novoY) {
        return x == novoX || y == novoY;
    }

    @Override
    public char getIcone() {
        return cor == Cor.BRANCO ? '\u2656' : '\u265C'; // Unicode para Torre branca e Torre preta
    }
}
