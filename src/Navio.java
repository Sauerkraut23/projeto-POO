public abstract class Navio {
    private int vida;
    private String tipoNavio;
    private int partesAtingidas;
    private boolean afundado;

    public Navio(String tipoNavio, int vida) {
        this.tipoNavio = tipoNavio;
        this.vida = vida;
        this.partesAtingidas = 0;
    }

    public void levarDano() {
        this.vida--;
        if (this.vida <= 0) {
            this.afundado = true;
        }
    }

    public int getVida() {
        return this.vida;
    }

    public String getTipoNavio() {
        return this.tipoNavio;
    }

    public boolean getAfundado() {
        return this.afundado;
    }

    public int partesAtingidas() {
        return this.partesAtingidas;
    }
}
