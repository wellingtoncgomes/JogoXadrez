package jogoXadrez.pecas;


public abstract class Peca {
    public enum Cor { BRANCO, PRETO }

    protected int x;
    protected int y;
    protected Cor cor;

    public Peca(int x, int y, Cor cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    public abstract boolean mover(int novoX, int novoY);
    public abstract char getIcone();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}