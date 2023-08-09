import java.util.ArrayList;

public abstract class Peca {

    private String cor;
    private Posicao posicao;

    Peca(String cor,Posicao posicao){
        this.cor=cor;
        this.posicao=posicao;
    }

    public boolean verificaPeca(Posicao posicao,ArrayList<Posicao> possiveisMovimentos){
        if (posicao.getPeca()==null){
            possiveisMovimentos.add(posicao);
            return false;
        }else if (!posicao.getPeca().getCor().equals(this.getCor())) {
                possiveisMovimentos.add(posicao);
        }
            return true;
    }

    public boolean mover(Tabuleiro tabuleiro,
                      Posicao posicao,Jogador adversario){

        ArrayList<Posicao> possiveisPosicoes = possiveisMovimentos(tabuleiro);
        Posicao posicaoAntiga=posicao;
        Posicao posicaoAtualAntiga=this.posicao;
        Peca pecaAntiga=posicao.getPeca();
        Peca pecaAtualAntiga=this.posicao.getPeca();

        for (Posicao possicaoPossivel: possiveisPosicoes) {
            if(possicaoPossivel==posicao){

                //atribuindo a peca para a nova posicao no tabuleiro
                System.out.println("peça antiga "+posicao.getPeca());
                System.out.println("antiga "+posicaoAntiga);
                posicao.setPeca(this);
                System.out.println("peça "+posicao.getPeca());
                System.out.println("antiga "+posicaoAntiga);

                //removendo a peca da posicao anterior
                System.out.println("this "+this.posicao);
                System.out.println("this "+this.posicao.getPeca());
                this.posicao.setPeca(null);

                //trocando a posicao atual da peca no tabuleiro
                System.out.println("this "+this.posicao);
                System.out.println("this "+this.posicao.getPeca());
                System.out.println("this "+pecaAtualAntiga);

                this.posicao=posicao;
                System.out.println("this "+this.posicao);
                System.out.println("this "+this.posicao.getPeca());
                System.out.println("this "+pecaAtualAntiga);


                if(Executavel.verificaReiEmXeque(adversario).size()!=0){

                    posicao=posicaoAntiga;
                    posicao.setPeca(pecaAntiga);

                    //removendo a peca da posicao anterior
                    this.posicao.setPeca(pecaAtualAntiga);

                    //trocando a posicao atual da peca no tabuleiro
                    this.posicao=posicaoAtualAntiga;
                }

                return true;

            }
        }
            return false;
    }

    public boolean validaExtremidade(int posicaoNoTabuleiro){
        return posicaoNoTabuleiro % 8 == 0;
    }

    public abstract ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro);

    public String getCor() {
        return cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }
    //icone

    @Override
    public String toString() {

        return
                "cor:" + cor + "\n" +
                "posicao=" + posicao;
    }
}
