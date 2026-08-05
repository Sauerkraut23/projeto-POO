public class Fragata extends Navio{
    public Fragata(){
        super("Fragata",2);
    }

    public void revelarArea(Tabuleiro tabuleiroInimigo, int centroX, int centroY){
        tabuleiroInimigo.revelarArea(centroX,centroY, 2, 2);
    }
}