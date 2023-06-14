import java.util.ArrayList;

public class Rei extends Peca{
    private boolean primeiroMovimento= true;

    Rei(String cor){
        super(cor);
    }
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos=new ArrayList<>();

        Posicao posicaoAtual=this.getPosicao();
        int posicaoNoTabuleiro= tabuleiro.getPosicoes().indexOf(posicaoAtual);

        for (Posicao posicao:tabuleiro.getPosicoes()) {
            int indice=tabuleiro.getPosicoes().indexOf(posicao);
            if(indice==posicaoNoTabuleiro-9 ||
                    indice==posicaoNoTabuleiro-8 ||
                    indice==posicaoNoTabuleiro-7 ||
                    indice==posicaoNoTabuleiro-1 ||
                    indice==posicaoNoTabuleiro+1 ||
                    indice==posicaoNoTabuleiro+7 ||
                    indice==posicaoNoTabuleiro+8 ||
                    indice==posicaoNoTabuleiro+9){
                //                coluna H
                if (validaExtremidade(posicaoNoTabuleiro+1) && !(
                        indice==posicaoNoTabuleiro-7 ||
                                indice==posicaoNoTabuleiro+1 ||
                                indice==posicaoNoTabuleiro+9
                )){
                    verificaPeca(posicao,possiveisMovimentos);

                }
                //    coluna A
                else if (validaExtremidade(posicaoNoTabuleiro) && !(
                        indice==posicaoNoTabuleiro+7 ||
                                indice==posicaoNoTabuleiro-9 ||
                                indice==posicaoNoTabuleiro+1
                )){
                    verificaPeca(posicao,possiveisMovimentos);
                }
            }
        }




        return possiveisMovimentos;
    }
}
