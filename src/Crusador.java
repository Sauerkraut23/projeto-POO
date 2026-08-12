public class Cruzador extends Navio {

    public Cruzador(){
        super("Cruzador", 4);
    }

    public void atacar3x3(Tabuleiro tabuleiroInimigo, int centroX, int centroY){
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int alvoX = centroX + i;
                int alvoY = centroY + j;

                if(tabuleiroInimigo.posicaoValida(alvoX, alvoY)){
                    tabuleiroInimigo.receberAtaque(alvoX, alvoY);
                }
        }
    }
}
