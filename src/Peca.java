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
                      Posicao posicao,Jogador adversario,Jogador jogador){
        System.out.println(simulacao(posicao,adversario,jogador));
        if(simulacao(posicao,adversario,jogador)){

            if (posicao.getPeca() != null) {
                adversario.getPecas().remove(posicao.getPeca());
            }
            posicao.setPeca(this);

            this.posicao.setPeca(null);


            this.posicao = posicao;

        }

                return true;

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
    public boolean simulacao( Posicao posicao,Jogador adversario,Jogador jogador){

            Posicao posicaoAntiga = posicao;
            Posicao posicaoAtualAntiga = this.posicao;
            Peca pecaAntiga = posicao.getPeca();
            Peca pecaAtualAntiga = this.posicao.getPeca();
            System.out.println(pecaAntiga+
                            "\n" +pecaAtualAntiga+
                            "\n" +posicaoAntiga+
                            "\n" +posicaoAtualAntiga);
            if (posicao.getPeca() != null) {
                adversario.getPecas().remove(posicao.getPeca());
            }
            posicao.setPeca(this);

            this.posicao.setPeca(null);


            this.posicao = posicao;

            if (Executavel.verificaReiEmXeque(adversario, jogador).size() != 0) {
                System.out.println("ainda cheque");
                System.out.println(posicao.getPeca()!=null? posicao.getPeca():"");
                this.posicao = posicaoAtualAntiga;
                this.posicao.setPeca(pecaAtualAntiga);

                posicao = posicaoAntiga;
                posicao.setPeca(pecaAntiga);

                //removendo a peca da posicao anterior

                return false;
            }

            this.posicao = posicaoAtualAntiga;
            this.posicao.setPeca(pecaAtualAntiga);

            posicao = posicaoAntiga;
            posicao.setPeca(pecaAntiga);

        System.out.println("não cheque");
        System.out.println(posicao.getPeca()!=null? posicao.getPeca():"");
        return true;
    }

    @Override
    public String toString() {

        return
                "cor:" + cor + "\n" +
                "posicao=" + posicao;
    }
}
