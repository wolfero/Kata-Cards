import java.util.List;

public class CardsGame {
    public String startOut(List<String> player1Hand, List<String> player2Hand) {
        isValid(player1Hand, player2Hand);

        return whoIsWinner(player1Hand, player2Hand);
    }

    final List<String> CARDS_RANK = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

    private String whoIsWinner(List<String> player1Hand, List<String> player2Hand) {
        int winsPlayer1 = 0;
        var winsPlayer2 = 0;
        var Player1Card = 0;
        var Player2Card = 0;

        for (int position = 0; position < player1Hand.size(); position++) {
            Player1Card = playerCardSize(formattedCard(player1Hand, position));
            Player2Card = playerCardSize(formattedCard(player2Hand, position));
            winsPlayer1 += shouldPlayer1Win(Player1Card, Player2Card);
            winsPlayer2 += shouldPlayer2Win(Player1Card, Player2Card);
        }

        if (winsPlayer1 > winsPlayer2) {
            return (winsPlayer1 == 1) ? "Player 1 win 1 to 0" : "Player 1 win 2 to 0";
        } else if (winsPlayer1 < winsPlayer2) {
            return (winsPlayer2 == 1) ? "Player 2 win 1 to 0" : "Player 2 win 2 to 0";
        }
        return "";
    }

    private int shouldPlayer1Win(int Player1Card, int Player2Card) {
        return (Player1Card > Player2Card) ? 1 : 0;
    }

    private int shouldPlayer2Win(int Player1Card, int Player2Card) {
        return (Player1Card < Player2Card) ? 1 : 0;
    }

    private int playerCardSize(String card) {
        return CARDS_RANK.indexOf(card);
    }

    private String formattedCard(List<String> Hand, int position) {
        return Hand.get(position).toUpperCase();
    }

    private void isValid(List<String> player1Hand, List<String> player2Hand) {
        areHandsEmpty(player1Hand, player2Hand);

        areCardsProvide(player1Hand, player2Hand);

        areCardsValid(player1Hand, player2Hand);
    }

    private void areHandsEmpty(List<String> player1Hand, List<String> player2Hand) {
        String message = "You have to provide correct format";
        if (player1Hand.size() != 2 || player2Hand.size() != 2) {
            throwMessage(message);
        }

        final int numberOfCardsPlayer1 = numberOfCardsInHand(player1Hand);
        final int numberOfCardsPlayer2 = numberOfCardsInHand(player2Hand);
        final boolean emptyHands = (numberOfCardsPlayer1 == 0) && (numberOfCardsPlayer2 == 0);
        if (emptyHands) {
            throwMessage(message);
        }
    }

    private void areCardsProvide(List<String> player1Hand, List<String> player2Hand) {
        final int numberOfCardsPlayer1 = numberOfCardsInHand(player1Hand);
        final int numberOfCardsPlayer2 = numberOfCardsInHand(player2Hand);
        final boolean differentCardsNumberInHand = numberOfCardsPlayer1 != numberOfCardsPlayer2;
        if (differentCardsNumberInHand) {
            throwMessage("You have to provide a player cards");
        }
    }

    private void areCardsValid(List<String> player1Hand, List<String> player2Hand) {
        var player1Cards = CARDS_RANK.contains(formattedCard(player1Hand, 0));
        player1Cards &= CARDS_RANK.contains(formattedCard(player1Hand, 1));

        var player2Cards = CARDS_RANK.contains(formattedCard(player2Hand, 0));
        player2Cards &= CARDS_RANK.contains(formattedCard(player2Hand, 1));

        if (!player1Cards && player2Cards) {
            throwMessage("You have to provide a valid card");
        }
    }

    private int numberOfCardsInHand(List<String> hand) {
        if (hand.get(0).isEmpty() && hand.get(1).isEmpty()) return 0;
        if (hand.get(0).isEmpty() || hand.get(1).isEmpty()) return 1;
        return 2;
    }

    private void throwMessage(String message) {
        throw new IllegalArgumentException(message);
    }
}
