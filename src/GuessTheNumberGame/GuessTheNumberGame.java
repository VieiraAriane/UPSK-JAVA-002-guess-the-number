
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static Random random;
    private static int targetNumber;
    private static boolean inciarJogo = true;
    public static int tentativas = 0;
    public static final int maximoTentativas = 10;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        random = new Random();

        targetNumber = random.nextInt(100) + 1;

        System.out.println("\n\uD83C\uDFB2 Adivinhe o número sorteado!\n" +
                "\n" +
                "\uD83C\uDFAF Você deve escolher um número de 1 a 100 e possui 10 chances de acertar.\n" +
                "\n" +
                "\uD83C\uDF40 Boa sorte!");
        System.out.println(targetNumber); //não printar esse número depois

        while (true) {
            System.out.println("\n\uD83C\uDFAE Quer iniciar o jogo? (sim/não)");
            String sim = scanner.nextLine();
            if (sim.equalsIgnoreCase("sim")) {
                break;
            } else if (sim.equalsIgnoreCase("não")) {
                System.out.println("\uD83D\uDC4B Obrigado por jogar! Até mais!");
                return;
            } else {
                System.out.println("\uD83D\uDC4E Resposta inválida! Digite 'sim' ou 'não'.");
            }
        }
        System.out.println("\nO jogo está começando!");
        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();
        System.out.println("\nBem vindo: " + name);

        Player human = new HumanPlayer();
        human.setName(name);

        Player computer = new ComputerPlayer();
        computer.setName("\nCOMPUTADOR");

        do {
            tentativas++;
            System.out.println("\n\033[1;33mRound:" + tentativas + "\033[0m");
            boolean inciarHumano = chekGuess(human);
            if (inciarHumano) {
                boolean iniciarComputer = chekGuess(computer);
                if (!iniciarComputer) {
                    break;
                }
            } else {
                System.out.println("Você acertou em: " + tentativas + " rounds.");
                break;
            }

        } while (inciarJogo && tentativas < maximoTentativas);
        if (tentativas == maximoTentativas) {
            System.out.println("\n\u274C\uDC80\u001B[31m GAMEOVER\033[0m");
        }
    }
    public static boolean chekGuess(Player player) {
        int guess = player.makeGuess();
        if (guess < targetNumber) {
            System.out.println("\033[0;36mMuito baixo!\033[0m");
        } else if (guess > targetNumber) {
            System.out.println("\033[0;36mMuito alto!\033[0m");
        } else if (guess == targetNumber) {
            System.out.println("\n\uD83C\uDFC6" + player.getName() + ", você venceu!");
            System.out.println("você apostou no número " + guess + " e essas foram as suas suposições: " + player.getGuess() + ".");
            inciarJogo = false;
                    }
        player.getGuess();
        return inciarJogo;
    }

}

