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
        if(verificaReiEmXeque(adversario).size()!=0){
                System.out.println("As peças que estão atacando: ");
            for (Peca peca:
                    verificaReiEmXeque(adversario)) {
                System.out.println(peca);
            }
        }
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
    public static ArrayList<Peca> verificaReiEmXeque(Jogador adversario){
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
}
