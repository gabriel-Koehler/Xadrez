import java.util.ArrayList;

public abstract class Peca {

    private String cor;
    private Posicao posicao;

    public void mover(Tabuleiro tabuleiro,
                      Posicao posicao){
        ArrayList<Posicao> possiveisPosicoes = possiveisMovimentos(tabuleiro);
        for (Posicao possicaoPossivel: possiveisPosicoes) {
            if(possicaoPossivel==posicao){
                //atribuindo a peca para a nova posicao no tabuleiro
                posicao.setPeca(this);
                //removendo a peca da posicao anterior
                this.posicao.setPeca(null);
                //trocando a posicao atual da peca no tabuleiro
                this.posicao=posicao;
                break;
            }
        }
            this.posicao=posicao;
    }
    public abstract ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro);

    public Posicao getPosicao() {
        return posicao;
    }
    //icone
}
