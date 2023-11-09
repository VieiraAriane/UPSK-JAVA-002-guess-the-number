
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public Integer makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getName() + ", digite seu palpite: ");
        int guess = scanner.nextInt();
        guesses.add(guess);
        return guess;
    }
}