import java.util.List;

public class CardsGame {
    public String startOut(List<String> player1Hand, List<String> player2Hand) {
        isValid(player1Hand, player2Hand);
        return "";
    }

    private void isValid(List<String> player1Hand, List<String> player2Hand) {
        areHandsEmpty(player1Hand, player2Hand);
        throw new IllegalArgumentException("You have to provide correct format");
        //areCardsProvide(player1Hand, player2Hand);
    }

    private void areHandsEmpty(List<String> player1Hand, List<String> player2Hand) {
        if (player1Hand.isEmpty() || player2Hand.isEmpty()) {
            throw new IllegalArgumentException("You have to provide correct format");
        }
    }

    private void areCardsProvide(List<String> player1Hand, List<String> player2Hand) {
        if (player1Hand.get(0).isEmpty() && player1Hand.get(1).isEmpty()) {
            throwMessage();
        }
        if (player2Hand.get(0).isEmpty() && player2Hand.get(1).isEmpty()) {
            throwMessage();
        }
    }

    private void throwMessage() {
        throw new IllegalArgumentException("You have to provide a player card");
    }
}
