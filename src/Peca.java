import javax.swing.plaf.synth.SynthOptionPaneUI;
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
        boolean x;
        boolean y;

        ArrayList<Posicao> possiveisPosicoes = possiveisMovimentos(tabuleiro);
        Posicao posicaoAntiga=posicao;
        Posicao posicaoAtualAntiga=this.posicao;
        Peca pecaAntiga=posicao.getPeca();
        Peca pecaAtualAntiga=this.posicao.getPeca();

        for (Posicao possicaoPossivel: possiveisPosicoes) {
            if(possicaoPossivel==posicao){

                //atribuindo a peca para a nova posicao no tabuleiro
//                System.out.println("peça antiga "+pecaAntiga);
//                System.out.println("posição antiga "+posicaoAntiga);
                if(posicao.getPeca()!=null){
                    adversario.getPecas().remove(posicao.getPeca());
                }
                posicao.setPeca(this);
//                System.out.println("peça "+posicao.getPeca());
//                System.out.println("antiga "+posicaoAntiga);

                //removendo a peca da posicao anterior
//                System.out.println("this "+this.posicao);
//                System.out.println("this "+this.posicao.getPeca());
                this.posicao.setPeca(null);

                //trocando a posicao atual da peca no tabuleiro
//                System.out.println("this "+this.posicao);
//                System.out.println("this "+this.posicao.getPeca());
//                System.out.println("this "+pecaAtualAntiga);

                this.posicao=posicao;
//                System.out.println("this "+this.posicao);
//                System.out.println("this "+this.posicao.getPeca());
//                System.out.println("this "+pecaAtualAntiga);
                System.out.println(posicao);
                System.out.println(posicao.getPeca());
                System.out.println(this.posicao);
                System.out.println(this.posicao.getPeca());

                if(Executavel.verificaReiEmXeque(adversario).size()!=0){
                    System.out.println("simulação");
                    System.out.println( this.posicao);
                    System.out.println( this.posicao.getPeca());
                    this.posicao=posicaoAtualAntiga;
                    this.posicao.setPeca(pecaAtualAntiga);
                    System.out.println( this.posicao);
                    System.out.println( this.posicao.getPeca());
                    System.out.println(posicao);
                    System.out.println(posicao.getPeca());
                    posicao=posicaoAntiga;
                    posicao.setPeca(pecaAntiga);
                    System.out.println(posicao);
                    System.out.println(posicao.getPeca());
                    System.out.println(posicao);
                    System.out.println(posicao.getPeca());
                    //removendo a peca da posicao anterior

                    //trocando a posicao atual da peca no tabuleiro
//                    this.posicao=posicaoAtualAntiga;
//                    System.out.println(this.posicao);
//                    System.out.println(this.posicao.getPeca());
                    return false;
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
