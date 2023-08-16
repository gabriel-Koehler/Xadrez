import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String cor;
    private double points;
    private ArrayList<Peca> pecas;

    Jogador(String nome, String senha){
        this.nome=nome;
        this.senha=senha;
        this.pecas = new ArrayList<>();
    }

    public void setCor(String cor,Tabuleiro tabuleiro) {
        this.cor = cor;
        for (Posicao posicao:tabuleiro.getPosicoes()) {
            if(posicao.getPeca()!=null &&
            posicao.getPeca().getCor().equals(this.getCor())
                ){
                adicionarPeçaAJogador(posicao.getPeca());
            }
        }
    }

    public String getCor() {
        return cor;
    }
    private void adicionarPeçaAJogador(Peca peca){
        pecas.add(peca);
    }

    public boolean moverPeca(Peca peca,
                             Posicao posicao,
                             Tabuleiro tabuleiro,
                             Jogador adversario){

        Peca pecaAdversaria=posicao.getPeca();
        boolean valida=peca.mover(tabuleiro,posicao,adversario,this);



        if(peca instanceof Peao && valida){
            if(((Peao) peca).isPrimeiroMovimento()){
                ((Peao) peca).setPrimeiroMovimento(false);
            }
        }
        if(pecaAdversaria!=null && valida){
            System.out.println(pecaAdversaria);
            adversario.pecas.remove(pecaAdversaria);
        }

        return valida;
    }



    public ArrayList<Peca> getPecas() {
        return pecas;
    }


}
