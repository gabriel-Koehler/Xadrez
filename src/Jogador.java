import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String cor;
    private double points;
    private ArrayList<Peca> pecas = new ArrayList<>();

    Jogador(String nome, String senha){
        this.nome=nome;
        this.senha=senha;
    }

    public void setCor(String cor,Tabuleiro tabuleiro) {
        this.cor = cor;
        for (Posicao posicao:tabuleiro.getPosicoes()) {
            if(posicao.getPeca().getCor().equals(this.getCor())){
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
        boolean valida=peca.mover(tabuleiro,posicao);
        if(pecaAdversaria!=null && valida){
            adversario.pecas.remove(posicao.getPeca());
        }

        return valida;
    }



    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void desistir(){

    }
}
