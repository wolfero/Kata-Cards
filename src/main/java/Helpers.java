import java.util.List;

public class Helpers {

    public String formattedCard(List<String> Hand, int position) {
        return Hand.get(position).toUpperCase();
    }

    public int playerCardSize(String card) {
        return Rules.CARDS_RANK.indexOf(card);
    }

    public int numberOfCardsInHand(List<String> hand) {
        if (hand.get(0).isEmpty() && hand.get(1).isEmpty()) return 0;
        if (hand.get(0).isEmpty() || hand.get(1).isEmpty()) return 1;
        return 2;
    }
}
