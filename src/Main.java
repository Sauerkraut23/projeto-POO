import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner ler = new Scanner(System.in)) {
            Tabuleiro tabuleiroJogador1 = new Tabuleiro();
            Tabuleiro tabuleiroJogador2 = new Tabuleiro();

            System.out.println("-----Jogador 1 deve posicionar os navios-----\n");
            tabuleiroJogador1.iniciarTabuleiro();
            tabuleiroJogador1.exibirTabuleiro();
            tabuleiroJogador1.colocarFrota();

            System.out.println("-----Jogador 2 deve posicionar os navios-----\n1");
            tabuleiroJogador2.iniciarTabuleiro();
            tabuleiroJogador2.exibirTabuleiro();
            tabuleiroJogador2.colocarFrota();

            System.out.println("\n------Inicio do JOGO------\n");
            int turno = 1;
            boolean jogoAtivo = true;

            while (jogoAtivo) {
                if (turno == 1) {
                    System.out.println("Turno do jogador 1");
                    System.out.println("Digite o eixo X: ");
                    int x = ler.nextInt();
                    System.out.println("Digite o eixo Y: ");
                    int y = ler.nextInt();
                    if (tabuleiroJogador2.receberTiro(y, x)) {
                        if (tabuleiroJogador2.validarVitoria()) {
                            System.out.println("O jogador 1 venceu, player 2 foi feito de boneca! ");
                            jogoAtivo = false;
                        }

                        else {
                            turno = 2;
                        }
                    }
                } else {
                    System.out.println("Turno do jogador 2");
                    System.out.println("Digite o eixo X: ");
                    int x = ler.nextInt();
                    System.out.println("Digite o eixo Y: ");
                    int y = ler.nextInt();
                    if (tabuleiroJogador1.receberTiro(y, x)) {
                        if (tabuleiroJogador1.validarVitoria()) {
                            System.out.println("O jogador 2 venceu, player 1 foi feito de danada! ");
                            jogoAtivo = false;
                        } else {
                            turno = 1;
                        }
                    }
                }
            }
        }
    }

}