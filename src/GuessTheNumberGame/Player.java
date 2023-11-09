import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    protected List<Integer> guesses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGuess() {

        return guesses;
    }


    public abstract Integer makeGuess();
}
