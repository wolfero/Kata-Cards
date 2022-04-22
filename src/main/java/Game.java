import java.util.List;

public class Game {
    private final Constraints constraints;
    private final Winner winner;

    public Game() {
        constraints = new Constraints();
        winner = new Winner();
    }

    public String findWinner(List<String> player1Hand, List<String> player2Hand) {
        constraints.isValid(player1Hand, player2Hand);

        return winner.message(player1Hand, player2Hand);
    }
}
