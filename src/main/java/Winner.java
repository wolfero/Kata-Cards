import java.util.List;

public class Winner {

    private final Helpers helper;

    public Winner() {
        helper = new Helpers();
    }

    public String is(List<String> player1Hand, List<String> player2Hand) {
        var winsPlayer1 = 0;
        var winsPlayer2 = 0;

        for (var position = 0; position < 2; position++) {
            var player1Card = helper.formattedCard(player1Hand, position);
            var player2Card = helper.formattedCard(player2Hand, position);

            var Player1CardSize = helper.playerCardSize(player1Card);
            var Player2CardSize = helper.playerCardSize(player2Card);

            winsPlayer1 += shouldPlayer1Win(Player1CardSize, Player2CardSize);
            winsPlayer2 += shouldPlayer2Win(Player1CardSize, Player2CardSize);
        }

        if (winsPlayer1 > winsPlayer2) {
            return (winsPlayer1 == 1) ? messageWinOneGame("Player 1") : messageWinTwoGame("Player 1");
        }
        if (winsPlayer1 < winsPlayer2) {
            return (winsPlayer2 == 1) ? messageWinOneGame("Player 2") : messageWinTwoGame("Player 2");
        }
        return messageTied();
    }

    private int shouldPlayer1Win(int Player1Card, int Player2Card) {
        return (Player1Card > Player2Card) ? 1 : 0;
    }

    private int shouldPlayer2Win(int Player1Card, int Player2Card) {
        return (Player1Card < Player2Card) ? 1 : 0;
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
