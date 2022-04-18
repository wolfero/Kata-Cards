import java.util.List;

public class Rules {
    public static final List<String> CARDS_RANK = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private final Helpers helpers;

    public Rules() {
        helpers = new Helpers();
    }

    public void isValid(List<String> player1Hand, List<String> player2Hand) {
        areHandsEmpty(player1Hand, player2Hand);

        areCardsProvide(player1Hand, player2Hand);

        areCardsValid(player1Hand, player2Hand);
    }

    private void areHandsEmpty(List<String> player1Hand, List<String> player2Hand) {
        String message = "You have to provide correct format";
        if (player1Hand.size() != 2 || player2Hand.size() != 2) {
            throwMessage(message);
        }

        final int numberOfCardsPlayer1 = helpers.numberOfCardsInHand(player1Hand);
        final int numberOfCardsPlayer2 = helpers.numberOfCardsInHand(player2Hand);
        final boolean emptyHands = (numberOfCardsPlayer1 == 0) && (numberOfCardsPlayer2 == 0);
        if (emptyHands) {
            throwMessage(message);
        }
    }

    private void areCardsProvide(List<String> player1Hand, List<String> player2Hand) {
        final int numberOfCardsPlayer1 = helpers.numberOfCardsInHand(player1Hand);
        final int numberOfCardsPlayer2 = helpers.numberOfCardsInHand(player2Hand);
        final boolean differentCardsNumberInHand = numberOfCardsPlayer1 != numberOfCardsPlayer2;
        if (differentCardsNumberInHand) {
            throwMessage("You have to provide a player cards");
        }
    }

    private void areCardsValid(List<String> player1Hand, List<String> player2Hand) {
        var player1ValidCards = true;
        var player2ValidCards = true;

        for (int position = 0; position < 2; position++) {
            var player1FormattedCard = helpers.formattedCard(player1Hand, position);
            var player2FormattedCard = helpers.formattedCard(player2Hand, position);

            player1ValidCards &= CARDS_RANK.contains(player1FormattedCard);
            player2ValidCards &= CARDS_RANK.contains(player2FormattedCard);
        }

        if (!player1ValidCards && player2ValidCards) {
            throwMessage("You have to provide a valid card");
        }
    }

    private void throwMessage(String message) {
        throw new IllegalArgumentException(message);
    }
}
