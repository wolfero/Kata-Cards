import java.util.List;

public class Game {
    private final Rules rules;
    private final Winner winner;

    public Game() {
        rules = new Rules();
        winner = new Winner();
    }

    public String startOut(List<String> player1Hand, List<String> player2Hand) {
        rules.isValid(player1Hand, player2Hand);

        return winner.is(player1Hand, player2Hand);
    }
}
