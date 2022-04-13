import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardsGameShould {
    /* TODO
     * * CARD RANK -> ["1","2","3","4","5","6","7","8","9","10","J","Q","K","A"]
     * * DONE --> ([],[]) -> throw exception "You have to provide correct format"
     * *  --> ([""],["",""]) -> throw exception "You have to provide correct format"
     * * DONE --> (["",""],["",""]) -> throw exception "You have to provide a player card"
     * *  --> (["K",""],["A","J"]) -> throw exception "You have to provide a player card"
     * * (["z",""],["5",""]) -> throw exception "You have to provide a valid card"
     * * (["3",""],["A",""]) -> return "Player 2 win 1 to 0"
     * * (["K","9"],["J","5"]) -> return "Player 1 win 2 to 0"
     * * (["K","9"],["J","A"]) -> return "Players tied"
     * */

    @Test
    void return_message_when_hands_are_not_given() {
        var cardsGame = new CardsGame();

        var exception = assertThrows(IllegalArgumentException.class, () -> cardsGame.startOut(List.of(), List.of()));

        assertThat(exception.getMessage()).isEqualTo("You have to provide correct format");
    }

    @Test
    void return_to_message_when_hands_are_missing_two_cards() {
        var cardsGame = new CardsGame();

        var exception = assertThrows(IllegalArgumentException.class, () -> cardsGame.startOut(List.of(""), List.of("", "")));

        assertThat(exception.getMessage()).isEqualTo("You have to provide correct format");
    }

    @Disabled
    @Test
    void return_message_when_cards_are_not_given() {
        var cardsGame = new CardsGame();

        var exception = assertThrows(IllegalArgumentException.class, () -> cardsGame.startOut(List.of("", ""), List.of("", "")));

        assertThat(exception.getMessage()).isEqualTo("You have to provide a player card");
    }
}
