import java.util.List;

public class Winner {

    private final Format format;

    public Winner() {
        this.format = new Format();
    }

    public String message(List<String> player1Hand, List<String> player2Hand) {
        var player1 = formattedCards(player1Hand);
        var player2 = formattedCards(player2Hand);

        var winsList = numberOfWins(player1, player2);

        boolean player1Win = winsList.get(0) > winsList.get(1);
        if (player1Win) {
            return winnerMessage(winsList.get(0), "Player 1");
        }

        boolean player2Win = winsList.get(0) < winsList.get(1);
        if (player2Win) {
            return winnerMessage(winsList.get(1), "Player 2");
        }

        return messageTied();
    }

    private List<String> formattedCards(List<String> hand) {
        return List.of(format.card(hand, 0), format.card(hand, 1));
    }

    private List<Integer> numberOfWins(List<String> player1, List<String> player2) {
        var winsPlayer1 = 0;
        var winsPlayer2 = 0;

        for (var position = 0; position < 2; position++) {
            var Player1CardSize = format.playerCardSize(player1.get(position));
            var Player2CardSize = format.playerCardSize(player2.get(position));

            winsPlayer1 += shouldPlayer1Win(Player1CardSize, Player2CardSize);
            winsPlayer2 += shouldPlayer2Win(Player1CardSize, Player2CardSize);
        }

        return List.of(winsPlayer1, winsPlayer2);
    }

    private int shouldPlayer1Win(int Player1Card, int Player2Card) {
        return (Player1Card > Player2Card) ? 1 : 0;
    }

    private int shouldPlayer2Win(int Player1Card, int Player2Card) {
        return (Player1Card < Player2Card) ? 1 : 0;
    }

    private String winnerMessage(int numberOfWins, String player) {
        return (numberOfWins == 1) ? messageWinOneGame(player) : messageWinTwoGame(player);
    }

    private String messageWinOneGame(String player) {
        return player + " win 1 to 0";
    }

    private String messageWinTwoGame(String player) {
        return player + " win 2 to 0";
    }

    private String messageTied() {
        return "Players tied";
    }
}
