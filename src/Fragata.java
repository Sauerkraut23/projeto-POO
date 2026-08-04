public class Fragata extends Navio{
    public Fragata(){
        super("Fragata",2);
    }

    public void revelarArea(Tabuleiro tabuleiroInimigo, int x, int y){
        tabuleiroInimigo.revelarArea(x,y, 2, 2);
    }
}