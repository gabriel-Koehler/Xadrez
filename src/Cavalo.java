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


            if (indice== posicaoNoTabuleiro-17 ||
                    indice== posicaoNoTabuleiro-15 ||
                    indice== posicaoNoTabuleiro-10 ||
                    indice== posicaoNoTabuleiro-6 ||
                    indice== posicaoNoTabuleiro+6 ||
                    indice== posicaoNoTabuleiro+10 ||
                    indice== posicaoNoTabuleiro+15 ||
                    indice== posicaoNoTabuleiro+17 ){
                System.out.println(indice);
                //                coluna A
                if (this.validaExtremidade(posicaoNoTabuleiro)){
                    if(!(
                        indice==posicaoNoTabuleiro+15 ||
                        indice==posicaoNoTabuleiro+6 ||
                        indice==posicaoNoTabuleiro-10 ||
                        indice==posicaoNoTabuleiro-17
                        )
                    ){
                        System.out.println(indice+"A");
                        verificaPeca(posicao,possiveisMovimentos);
                    }

                }
//                coluna B
                else if (this.validaExtremidade(posicaoNoTabuleiro-1)){
                    if(     indice==posicaoNoTabuleiro-15||
                            indice==posicaoNoTabuleiro+15||
                            indice==posicaoNoTabuleiro+17||
                            indice==posicaoNoTabuleiro-17||
                            indice==posicaoNoTabuleiro+10||
                            indice==posicaoNoTabuleiro-6
                    ){
                        System.out.println(indice+"B");
                        verificaPeca(posicao,possiveisMovimentos);
                    }
                }
//                coluna G
                 else if (this.validaExtremidade(posicaoNoTabuleiro+2)){
                     if(    indice==posicaoNoTabuleiro-15 ||
                            indice==posicaoNoTabuleiro+15||
                            indice==posicaoNoTabuleiro+17||
                            indice==posicaoNoTabuleiro-17||
                            indice==posicaoNoTabuleiro-10||
                            indice==posicaoNoTabuleiro+6){
                        System.out.println(indice+"G");
                        verificaPeca(posicao,possiveisMovimentos);
                     }
                }
                //    coluna H
                else if (this.validaExtremidade(posicaoNoTabuleiro+1)){
                    if(!(
                            indice==posicaoNoTabuleiro+17 ||
                            indice==posicaoNoTabuleiro+10 ||
                            indice==posicaoNoTabuleiro-6 ||
                            indice==posicaoNoTabuleiro-15
                        )
                    ){
                        System.out.println(indice+"H");
                        verificaPeca(posicao,possiveisMovimentos);
                    }
                }else {
                        System.out.println(indice+"any");
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
