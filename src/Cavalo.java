import java.util.ArrayList;

public class Cavalo extends Peca {

    Cavalo(String cor,Posicao posicao){
        super(cor,posicao);
    }
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos=new ArrayList<>();

        Posicao posicaoAtual=this.getPosicao();

        int posicaoNoTabuleiro=tabuleiro.getPosicoes().indexOf(posicaoAtual);

        for (Posicao posicao:
                tabuleiro.getPosicoes()) {
            int indice=tabuleiro.getPosicoes().indexOf(posicao);


            if (tabuleiro.getPosicoes().indexOf(posicao)== posicaoNoTabuleiro-17 ||
                    indice== posicaoNoTabuleiro-15 ||
                    indice== posicaoNoTabuleiro-10 ||
                    indice== posicaoNoTabuleiro-6 ||
                    indice== posicaoNoTabuleiro+6 ||
                    indice== posicaoNoTabuleiro+10 ||
                    indice== posicaoNoTabuleiro+15 ||
                    indice== posicaoNoTabuleiro+17 ){
                System.out.println(indice);
                //                coluna A
                if (!(
                        indice==posicaoNoTabuleiro+15 ||
                                indice==posicaoNoTabuleiro+6 ||
                                indice==posicaoNoTabuleiro-10 ||
                                indice==posicaoNoTabuleiro-17
                        )&& this.validaExtremidade(posicaoNoTabuleiro+1)){
                    System.out.println(indice+"A");
                    verificaPeca(posicao,possiveisMovimentos);

                }
//                coluna B
                else if (
                                indice==posicaoNoTabuleiro-15||
                                indice==posicaoNoTabuleiro+15||
                                indice==posicaoNoTabuleiro+17||
                                indice==posicaoNoTabuleiro-17||
                                indice==posicaoNoTabuleiro+10||
                                indice==posicaoNoTabuleiro-6 &&
                this.validaExtremidade(posicaoNoTabuleiro-1)
                ){
                    System.out.println(indice+"B");
                    verificaPeca(posicao,possiveisMovimentos);
                }
//                coluna G
                 else if (
                                indice==posicaoNoTabuleiro-15 ||
                                indice==posicaoNoTabuleiro+15||
                                indice==posicaoNoTabuleiro+17||
                                indice==posicaoNoTabuleiro-17||
                                indice==posicaoNoTabuleiro-10||
                                indice==posicaoNoTabuleiro+6 &&
                this.validaExtremidade(posicaoNoTabuleiro+2)
                ){
                    System.out.println(indice+"G");
                    verificaPeca(posicao,possiveisMovimentos);
                }
                //    coluna H
                else if (!(
                        indice==posicaoNoTabuleiro+17 ||
                                indice==posicaoNoTabuleiro+10 ||
                                indice==posicaoNoTabuleiro-6 ||
                                indice==posicaoNoTabuleiro-15
                        )&& this.validaExtremidade(posicaoNoTabuleiro)){
                    System.out.println(indice+"H");
                    verificaPeca(posicao,possiveisMovimentos);
                }

            }
        }

        return possiveisMovimentos;
    }
    @Override
    public String toString() {
        if(this.getCor().equals("Branco")){
            return "♘";
        }else{
            return "♞";
        }
    }
}
