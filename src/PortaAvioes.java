public class PortaAvioes extends Navio {

    public PortaAvioes(){
        super("Porta-aviões",5);
    }

   public void atacarEmCruz(Tabuleiro tabuleiroInimigo, int centroX, int centroY){
        int[][] deslocamentoAtaque = {
            {0, 0},
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1};
        }  
    }

    for (int[] offset : deslocamentoAtaque) {
        int alvoX = centroX + offset[0];
        int alvoY = centroY + offset[1];

        if (tabuleiroInimigo.posicaoValida(alvoX, alvoY)) {
        tabuleiroInimigo.receberAtaque(alvoX, alvoY);
        }
    }
}
