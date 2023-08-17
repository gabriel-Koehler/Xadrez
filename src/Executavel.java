import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
        static Scanner sc=new Scanner(System.in);
        static Tabuleiro tabuleiro=new Tabuleiro();
        static Jogador jogador1=new Jogador("Jorge","Senha@123");
        static Jogador jogador2=new Jogador("Wilson","Wilson");
    public static void main(String[]args){



        jogador1.setCor("Branco",tabuleiro);
        jogador2.setCor("Preto",tabuleiro);

        //escolha da peca
        do {
            do {
            }while (displayJogada(jogador1,jogador2));

            do {
            }while (displayJogada(jogador2,jogador1));

        }while (validarVitoria());
        if(!validarVitoria()){
            System.out.println("O jogo Acabou");
        }

    }
    private static boolean validarVitoria(){
        boolean x=false;
        boolean y=false;
        for (Peca peca:jogador1.getPecas()) {
            if (peca instanceof Rei){
                x=true;
            }
        }
        for (Peca peca:jogador2.getPecas()) {
            if (peca instanceof Rei){
                y=true;
            }
        }
        return x==y;
    }

    private static void mostrarTabuleiro(){
        for (Posicao posicao: tabuleiro.getPosicoes() ) {

            if(tabuleiro.getPosicoes().indexOf(posicao)==7
            || tabuleiro.getPosicoes().indexOf(posicao)==15
            || tabuleiro.getPosicoes().indexOf(posicao)==23
            || tabuleiro.getPosicoes().indexOf(posicao)==31
            || tabuleiro.getPosicoes().indexOf(posicao)==39
            || tabuleiro.getPosicoes().indexOf(posicao)==47
            || tabuleiro.getPosicoes().indexOf(posicao)==55
            || tabuleiro.getPosicoes().indexOf(posicao)==63){
                if(posicao.getPeca()!=null){
                    System.out.print("["+posicao.getPeca()+"] \n");
                }else {
                    System.out.print("["+"➕"+"] \n");
                }
            }else {
                if(posicao.getPeca()!=null){
                    System.out.print("["+posicao.getPeca()+"]");
                }else{
                    System.out.print("["+"➕"+"]");
                }
            }

        }
    }

    private static boolean displayJogada(Jogador jogador,Jogador adversario){
        cheque_Mate(adversario,jogador);
        if(verificaReiEmXeque(adversario,jogador).size()!=0){
                System.out.println("As peças que estão atacando: ");
            for (Peca peca:
                    verificaReiEmXeque(adversario,jogador)) {
                System.out.println(peca);
            }
        }
        do {
        System.out.println(jogador.getPecas() + "\n");
        mostrarTabuleiro();
            for (Peca peca : jogador.getPecas()) {
                System.out.println(jogador.getPecas().indexOf(peca) + (1) + " " + peca);
            }
            System.out.println("Escolha Uma Peça: ");
            int escolhaPeca = sc.nextInt();
            System.out.println(escolhaPeca);
            Peca peca = jogador.getPecas().get(escolhaPeca - 1);
            System.out.println(peca);
            //escolha da posicao para movimento
            ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
            if (posicoes.size() != 0) {
                System.out.println(posicoes);
                int escolhaPosicao = sc.nextInt();
                Posicao posicao = posicoes.get(escolhaPosicao - 1);

                // Movimentos da peca esccolhida para posicao desejada
                jogador.moverPeca(peca, posicao, tabuleiro, adversario);

            } else {
                System.out.println("Infelizmente essa peça não possui movimentos");
                return true;
            }
        }while (verificaReiEmXeque(adversario,jogador).size()!=0);
        return false;
    }

    public static ArrayList<Peca> verificaReiEmXeque(Jogador adversario,Jogador atuando){

        ArrayList<Peca> pecaAtacandoRei=new ArrayList();
        for (Peca peca: adversario.getPecas()) {
            for (Posicao posicao:peca.possiveisMovimentos(tabuleiro)) {
                if(posicao.getPeca()!=null && posicao.getPeca() instanceof Rei){
                    pecaAtacandoRei.add(peca);
                }
            }
        }

        return pecaAtacandoRei;

    }

    private static void cheque_Mate(Jogador adversario,Jogador atuando){
        ArrayList temJogadas=new ArrayList();
        if(verificaReiEmXeque(adversario,atuando).size()!=0){
            Peca rei=null;
            for (Peca peca:atuando.getPecas()){
                if (peca instanceof  Rei){
                    rei=peca;
                }
            }
            ArrayList posicaoFuga=new ArrayList();
            for (Posicao posicao:rei.possiveisMovimentos(tabuleiro)) {
                for (Peca peca: adversario.getPecas()) {
                    for (Posicao posicao2:peca.possiveisMovimentos(tabuleiro)) {
                        if (posicao == posicao2){
                            System.out.println("posicaoFuga"+posicao);
                            posicaoFuga.add(posicao);
                        }
                    }
                }
            }

//            for (Peca peca:atuando.getPecas()){
//                System.out.println(peca);
//                for (Posicao posicao:peca.possiveisMovimentos(tabuleiro)){
//                    System.out.println(posicao);
//                    if (!peca.simulacao(posicao,adversario,atuando)){
//                        System.out.println("temJogadas"+posicao);
//                        temJogadas.add(posicao);
//                    }
//                }
//            }

            if(rei.possiveisMovimentos(tabuleiro).size()==posicaoFuga.size() && verificaReiEmXeque(adversario,atuando).size()==0){
                atuando.getPecas().remove(rei);
                System.out.println("sim");
            }
        }
    }
//posso colocar verificaCheque, e verificar dentro desse if ^ acima

}
