import java.util.List;

public class CardsGame {
    public String startOut(List<String> player1Hand, List<String> player2Hand) {
        isValid(player1Hand, player2Hand);

        return "";
    }

    private void isValid(List<String> player1Hand, List<String> player2Hand) {
        areHandsEmpty(player1Hand, player2Hand);
        areCardsProvide(player1Hand, player2Hand);
        throw new IllegalArgumentException("You have to provide a valid card");
    }

    private void areHandsEmpty(List<String> player1Hand, List<String> player2Hand) {
        if (player1Hand.size() != 2 || player2Hand.size() != 2) {
            throw new IllegalArgumentException("You have to provide correct format");
        }
    }

    private void areCardsProvide(List<String> player1Hand, List<String> player2Hand) {
        final int numberOfCardsPlayer1 = numberOfCardsInHand(player1Hand);
        final int numberOfCardsPlayer2 = numberOfCardsInHand(player2Hand);
        final boolean emptyHands = (numberOfCardsPlayer1 == 0) && (numberOfCardsPlayer2 == 0);
        final boolean differentCardsNumberInHand = numberOfCardsPlayer1 != numberOfCardsPlayer2;
        if (emptyHands || differentCardsNumberInHand) {
            throw new IllegalArgumentException("You have to provide a player cards");
        }
    }

    private int numberOfCardsInHand(List<String> hand) {
        if (hand.get(0).isEmpty() && hand.get(1).isEmpty()) return 0;

        if (hand.get(0).isEmpty() || hand.get(1).isEmpty()) return 1;

        return 2;
    }
}
