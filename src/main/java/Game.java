import java.util.List;

public class Game {
    private final Constraints constraints;
    private final Winner winner;

    public Game() {
        constraints = new Constraints();
        winner = new Winner();
    }

    public String startOut(List<String> player1Hand, List<String> player2Hand) {
        constraints.isValid(player1Hand, player2Hand);

        return winner.is(player1Hand, player2Hand);
    }
}
