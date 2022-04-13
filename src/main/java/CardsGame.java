import java.util.List;

public class CardsGame {
    public String startOut(List<String> player1Hand, List<String> player2Hand) {
        isValid(player1Hand, player2Hand);

        final var firstCardPlayer1 = CARD_RANK.indexOf(player1Hand.get(0).toUpperCase());
        final var firstCardPlayer2 = CARD_RANK.indexOf(player2Hand.get(0).toUpperCase());
        if (firstCardPlayer1 > firstCardPlayer2) return "Player 1 win 1 to 0";
        return "Player 2 win 1 to 0";
    }

    private void isValid(List<String> player1Hand, List<String> player2Hand) {
        areHandsEmpty(player1Hand, player2Hand);

        areCardsProvide(player1Hand, player2Hand);

        areCardsValid(player1Hand, player2Hand);
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

    final List<String> CARD_RANK = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

    private void areCardsValid(List<String> player1Hand, List<String> player2Hand) {
        var player1Cards = CARD_RANK.contains(player1Hand.get(0).toUpperCase());
        player1Cards &= CARD_RANK.contains(player1Hand.get(1).toUpperCase());

        var player2Cards = CARD_RANK.contains(player2Hand.get(0).toUpperCase());
        player2Cards &= CARD_RANK.contains(player2Hand.get(1).toUpperCase());

        if (!player1Cards && player2Cards) {
            throw new IllegalArgumentException("You have to provide a valid card");
        }
    }
}
