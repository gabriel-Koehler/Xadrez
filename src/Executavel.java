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
//            System.out.println(getPecas(jogador1,tabuleiro) + "\n");
//            mostrarTabuleiro();
//            for (Peca peca : jogador1.getPecas()) {
//                System.out.println(jogador1.getPecas().indexOf(peca) + (1) + " " + peca);
//            }
//            System.out.println("Escolha Uma Peça: ");
//            int escolhaPeca = sc.nextInt();
//            System.out.println(escolhaPeca);
//            Peca peca = jogador1.getPecas().get(escolhaPeca - 1);
//            System.out.println(peca);
//            //escolha da posicao para movimento
//            ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
//            System.out.println(posicoes);
//            int escolhaPosicao = sc.nextInt();
//            Posicao posicao = posicoes.get(escolhaPosicao-1);
//            // Movimentos da peca esccolhida para posicao desejada
//            jogador1.moverPeca(peca, posicao, tabuleiro, jogador2);
        }while (validarVitoria());


    }
    private static boolean validarVitoria(){
        for (Peca peca:jogador1.getPecas()) {
            if (peca instanceof Rei){
                return true;
            }
        }
        for (Peca peca:jogador2.getPecas()) {
            if (peca instanceof Rei){
                return true;
            }
        }
        return false;
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
                    System.out.print("|"+posicao.getPeca()+"| \n");
                }else {
                    System.out.print("|"+"⬛"+"| \n");
                }
            }else {
                if(posicao.getPeca()!=null){
                    System.out.print("|"+posicao.getPeca()+"|");
                }else{
                    System.out.print("|"+"⬛"+"|");
                }
            }

        }
    }
//    private static ArrayList<Peca> getPecas(Jogador jogador,Tabuleiro tabuleiro){
//        ArrayList<Peca> pecasJogador=new ArrayList<>();
//        for (Posicao posicao: tabuleiro.getPosicoes()) {
//            if(posicao.getPeca()!=null){
//                if (posicao.getPeca().getCor().equals(jogador.getCor())) {
//                    pecasJogador.add(posicao.getPeca());
//                }
//            }
//        }
//        return pecasJogador;
//    }
    private static boolean displayJogada(Jogador jogador,Jogador adversario){
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
        if(posicoes.size()!=0){
        System.out.println(posicoes);
        int escolhaPosicao = sc.nextInt();
        Posicao posicao = posicoes.get(escolhaPosicao-1);
        // Movimentos da peca esccolhida para posicao desejada
        jogador.moverPeca(peca, posicao, tabuleiro, adversario);
        return false;
        }else {
            System.out.println("Infelizmente essa peça não possui movimentos");
            return true;
        }
    }
}
