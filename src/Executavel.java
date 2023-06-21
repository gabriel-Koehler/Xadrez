import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        Jogador jogador1=new Jogador("Jorge","Senha@123");
        Jogador jogador2=new Jogador("Wilson","Wilson");

        Tabuleiro tabuleiro=new Tabuleiro();
        jogador1.setCor("Branco",tabuleiro);
        jogador2.setCor("Preto",tabuleiro);

        //escolha da peca
        System.out.println(jogador1.getPecas());
        for (Peca peca : jogador1.getPecas()){
            System.out.println(jogador1.getPecas().indexOf(peca)+(1)+" "+peca);
        }
        int escolhaPeca = sc.nextInt();
        System.out.println(escolhaPeca);
        Peca peca=jogador1.getPecas().get(escolhaPeca);
        System.out.println(peca);
        //escolha da posicao para movimento
        ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
        System.out.println(posicoes);
        int escolhaPosicao=sc.nextInt();
        Posicao posicao= posicoes.get(escolhaPosicao);
        // Movimentos da peca esccolhida para posicao desejada
        jogador1.moverPeca(peca,posicao,tabuleiro,jogador2);
        System.out.println(validarVitoria(jogador2));

    }
    private static boolean validarVitoria(Jogador adversario){
        for (Peca peca:adversario.getPecas()) {
            if (peca instanceof Rei){
                return false;
            }
        }
        return true;
    }
}
