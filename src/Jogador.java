import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private int quantiaVitorias;
    private List<Navio> navios;
    private Tabuleiro meuTabuleiro;
    private Tabuleiro tabuleiroInimigo;

    public Jogador (String nome, Tabuleiro meuTabuleiro, Tabuleiro tabuleiroInimigo){
        this.nome=nome;
        this.quantiaVitorias=0;
        this.navios=new ArrayList<>();
        this.meuTabuleiro=meuTabuleiro;
        this.tabuleiroInimigo=tabuleiroInimigo;
    }

    public void adicionarNavio(Navio navio){
        this.navios.add(navio);
    }

    public void adicionarNavios(){
        this.navios.add(new PortaAvioes());
        this.navios.add(new Cruzador());
        this.navios.add(new Contratorpedeiro());
        this.navios.add(new Fragata());
        this.navios.add(new Corveta());
    }

    public void ganharVitoria(){
        this.quantiaVitorias++;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantiaVitorias() {
        return quantiaVitorias;
    }

    public List<Navio> getNavios() {
        return navios;
    }
    
    public Tabuleiro getMeuTabuleiro() {
        return meuTabuleiro;
    }

    public Tabuleiro getTabuleiroInimigo() {
        return tabuleiroInimigo;
    }
}
