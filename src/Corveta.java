public class Corveta extends Navio {
    public Corveta(){
        super("Corveta",1);
    }

    public void moverCorveta(int newX, int newY){
        setPosicao(newX, newY, getHorizontal());
    }

}