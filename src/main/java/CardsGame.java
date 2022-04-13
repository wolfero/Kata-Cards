import java.util.List;

public class CardsGame {
    public String startOut(List<String> player1Card, List<String> player2Card) {
        isValid(player1Card, player2Card);
        return "";
    }

    private void isValid(List<String> player1Card, List<String> player2Card) {
        if (player1Card.isEmpty() || player2Card.isEmpty()) {
            throw new IllegalArgumentException("You have to provide correct format");
        }
    }
}
