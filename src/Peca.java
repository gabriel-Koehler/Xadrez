import java.util.ArrayList;

public abstract class Peca {

    private String cor;
    private Posicao posicao;

    public boolean verificaPeca(Posicao posicao,ArrayList<Posicao> possiveisMovimentos){
        if (posicao.getPeca()==null){
            possiveisMovimentos.add(posicao);
            return false;
        }else if (!posicao.getPeca().getCor().equals(this.getCor())) {
                possiveisMovimentos.add(posicao);
        }
            return true;
    }

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

    public String getCor() {
        return cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }
    //icone
}
