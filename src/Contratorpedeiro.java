public class Contratorpedeiro extends Navio{
    public Contratorpedeiro(){
        super("Contratorpedeiro", 3);
    }
    public void atacarLinhaSete(Tabuleiro tabuleiroInimigo,int centroX, int centroY, boolean horizontal){
        for(int i = -3; i<=3; i++){
            int alvoX= centroX;
            int alvoY= centroY;

            if(horizontal){
                alvoY=centroY+i;
            }
            else{
                alvoX=centroX+i;
            }

            if(tabuleiroInimigo.posicaoValida(alvoX,alvoY)){
                tabuleiroInimigo.receberAtaque(alvoX,alvoY);
            }
        }
    }
}