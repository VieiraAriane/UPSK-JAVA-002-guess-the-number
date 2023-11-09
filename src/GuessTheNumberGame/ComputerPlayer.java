import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {
    protected Random random;

    @Override
    public Integer makeGuess() {
        random = new Random();
        int guessComputer = random.nextInt(100) + 1;
        System.out.println(getName() + ", digite seu palpite: " + guessComputer);
        return guessComputer;
    }
}
