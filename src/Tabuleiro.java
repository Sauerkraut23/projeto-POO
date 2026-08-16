import java.util.Scanner;

public class Tabuleiro {

    private String[][] tabuleiro = new String[8][8];
    private Navio[][] navioNoTabuleiro = new Navio[8][8];
    private Navio frota[] = new Navio[2];

    public void iniciarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = "| ~ |";
            }
        }
    }

    public void exibirTabuleiro() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    private boolean posicionarNavio(Navio navio, int posicaoX, int posicaoY, boolean horizontal) {
        int vida = navio.getVida();
        posicaoX = posicaoX - 1;
        posicaoY = posicaoY - 1;
        if (posicaoX < 0 || posicaoY < 0 || posicaoX > 7 || posicaoY > 7) {
            return false;
        }
        if (horizontal) {
            if (posicaoX + vida > 8) {
                return false;
            }
            for (int i = 0; i < vida; i++) {
                if (navioNoTabuleiro[posicaoY][posicaoX + i] != null) {
                    return false;
                }
            }
            for (int i = 0; i < vida; i++) {
                navioNoTabuleiro[posicaoY][posicaoX + i] = navio;
                tabuleiro[posicaoY][posicaoX + i] = "| N |";
            }
            return true;

        } else if (posicaoY + vida > 8) {
            return false;
        }
        for (int i = 0; i < vida; i++) {
            if (navioNoTabuleiro[posicaoY + i][posicaoX] != null) {
                return false;
            }
        }

        for (int i = 0; i < vida; i++) {
            navioNoTabuleiro[posicaoY + i][posicaoX] = navio;
            tabuleiro[posicaoY + i][posicaoX] = "| N |";
        }
        return true;
    }

    public void colocarFrota() {
        Scanner ler = new Scanner(System.in);
        int contagemNavios = 0;

        frota[0] = new Fragata();
        frota[1] = new Fragata();
        // frota[2] = new Fragata();
        // frota[3] = new Fragata();
        // frota[4] = new Contratorpedeiro();
        // frota[5] = new Contratorpedeiro();
        // frota[6] = new Cruzador();
        // frota[7] = new PortaAviao();
        // frota[8] = new PortaAviao();
        boolean horizontal = false;
        while (contagemNavios < 2) {
            System.out.println("Posicione o navio: " + frota[contagemNavios].getTipoNavio() + " numero: "
                    + (contagemNavios + 1) + "\nPosicao X: ");
            int posicaoX = ler.nextInt();
            System.out.println("Posicao Y: ");
            int posicaoY = ler.nextInt();
            System.out.println("Digite 1 p/horizontal ou 2 p/vertical ");
            int escolherHorizontal = 0;

            while (escolherHorizontal < 1 || escolherHorizontal > 2) {
                escolherHorizontal = ler.nextInt();
                if (escolherHorizontal == 1) {
                    horizontal = true;
                } else if (escolherHorizontal == 2) {
                    horizontal = false;
                } else {
                    System.out.println("Invalido, digite novamente");

                }
            }

            if (posicionarNavio(frota[contagemNavios], posicaoX, posicaoY, horizontal)) {

                contagemNavios++;
            } else {
                System.out.println("Falha ao colocar navio, tente novamente");
            }

            exibirTabuleiro();
            ler.close();
        }
    }

    public boolean receberTiro(int posicaoTiroY, int posicaoTiroX) {
        int posicaoX = posicaoTiroX - 1;
        int posicaoY = posicaoTiroY - 1;
        if (posicaoX > 7 || posicaoX < 0 || posicaoY > 7 || posicaoY < 0) {
            return false;
        }

        if (tabuleiro[posicaoY][posicaoX].equals("| X |") || tabuleiro[posicaoY][posicaoX].equals("| O |")) {
            return false;
        }

        if (navioNoTabuleiro[posicaoY][posicaoX] != null) {
            navioNoTabuleiro[posicaoY][posicaoX].levarDano();
            tabuleiro[posicaoY][posicaoX] = "| X |";
            System.out.println("Acertou!");
            if (navioNoTabuleiro[posicaoY][posicaoX].getAfundado()) {

                System.out.println("O navio " + navioNoTabuleiro[posicaoY][posicaoX].getTipoNavio() + " afundou!");

            }

        } else {

            tabuleiro[posicaoY][posicaoX] = "| O |";

            System.out.println("Nao atingiu nenhum navio");

        }

        exibirTabuleiro();
        return true;
    }

    public boolean validarVitoria() {
        int naviosAfundados = 0;
        for (int i = 0; i < frota.length; i++) {
            if (frota[i].getAfundado()) {
                naviosAfundados++;
            }
        }
        return naviosAfundados == frota.length;
    }
}
