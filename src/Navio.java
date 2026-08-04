
public abstract class Navio {

    private String nome;
    private int tamanho;
    private int partesAtingidas;
    private int localNavioEixoX;
    private int localNavioEixoY;
    private boolean afundado;
    private boolean horizontal;

    public Navio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.partesAtingidas = 0;
        this.afundado = false;
    }

    public void levarDano() {
        this.partesAtingidas++;
        if (this.partesAtingidas >= this.tamanho) {
            this.afundado = true;
        }
    }

    public boolean getAfundado() {
        return this.afundado;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public String getNome() {
        return this.nome;
    }
    public boolean getHorizontal(){
        return this.horizontal;
    }

    public void setPosicao(int x, int y, boolean horizontal) {
        this.localNavioEixoX = x;
        this.localNavioEixoY = y;
        this.horizontal = horizontal;
    }

}
