import java.arraylist;
import java.util.List;

public class Crusador extends Navio {

    private boolean habilidadeUsada;

    public Crusador() {
        super("Crusador", 4);
        this.habilidadeUsada = false;
    }

    public list<int[]> usarHabilidadeEspecial(int centroX, int centroY);
     List<int[]> areaAtaque = new ArrayList<>();

    for(int x = centroX -1; x <= centroX +1; x++){
        for(int y = centroY -1; y <= centroY +1; y++){
            areaAtaque.add(new int[]{x, y});   
        }
    }
}