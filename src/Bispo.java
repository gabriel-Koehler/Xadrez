import java.util.ArrayList;

public class Bispo extends  Peca{
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {

        ArrayList<Posicao> possiveisMovimentos=new ArrayList<>();

        Posicao posicaoAtual=this.getPosicao();
        int posicaoNoTabuleiro= tabuleiro.getPosicoes().indexOf(posicaoAtual);
        int posicaoPossivel=posicaoNoTabuleiro;
        //if ternario

        for(int i=(posicaoNoTabuleiro%8 ==0 ? 64 : posicaoNoTabuleiro+7);
                i<tabuleiro.getPosicoes().size();i+=7) {

            Posicao posicao=tabuleiro.getPosicoes().get(i);

            if(verificaPeca(posicao,possiveisMovimentos)) {
                break;
            }

            if (i%8==0){
                break;
            }
        }
        for(int i=((posicaoNoTabuleiro+1)%8 ==0 ? -1 : posicaoNoTabuleiro-7);
                i>=0;i-=7) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if ((i+1)%8==0){
                break;
            }
        }
        for(int i=((posicaoNoTabuleiro+1)%8 ==0 ? 64 : posicaoNoTabuleiro+9);
                i<tabuleiro.getPosicoes().size();i+=9) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if (i%8==0){
                break;
            }
        }
        for(int i=(posicaoNoTabuleiro %8 ==0 ? -1 : posicaoNoTabuleiro-9);
                i>=0;i-=9) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if ((i+1)%8==0){
                break;
            }
        }



//            if(posicao.getPosicaoTabuleiro()==(posicaoPossivel+=7)){
//                if (posicao.getPeca()==null || posicao.getPeca().getCor()!=this.getCor()){
//                posicaoPossivel+=7;
//                possiveisMovimentos.add();
//                }
//            }
        return possiveisMovimentos;
    }

//        for (int i = 0; i < tabuleiro.getPosicoes().size(); i) {
//
//        }

    }

