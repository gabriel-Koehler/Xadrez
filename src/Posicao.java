public class Posicao {
    private Peca peca;
    private int posicao;

    public int getPosicaoTabuleiro() {
        return posicao;
    }

    public void setPosicaoTabuleiro(int posicao) {
        this.posicao = posicao;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
