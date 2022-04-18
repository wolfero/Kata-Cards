import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameShould {
    private Game cardsGame;

    @BeforeEach
    void init() {
        cardsGame = new Game();
    }

    @Test
    void return_message_when_hands_are_empty() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.startOut(List.of(), List.of())
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide correct format");
    }

    @Test
    void return_message_when_hands_are_missing_two_cards() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.startOut(List.of("3"), List.of("J", "K"))
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide correct format");
    }

    @Test
    void return_message_when_one_hand_gave_two_cards_and_the_other_gave_only_one_card() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.startOut(List.of("k", ""), List.of("j", "j"))
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide a player cards");
    }

    @Test
    void return_message_when_given_invalid_card() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.startOut(List.of("Z", "K"), List.of("J", "3"))
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide a valid card");
    }

    @Test
    void return_winner_whit_only_one_card() {
        assertThat(cardsGame.startOut(List.of("3", ""), List.of("A", ""))).isEqualTo("Player 2 win 1 to 0");
    }

    @Test
    void return_winner_whit_two_cards() {
        assertThat(cardsGame.startOut(List.of("K", "9"), List.of("J", "5"))).isEqualTo("Player 1 win 2 to 0");
    }

    @Test
    void return_tied_if_no_body_win() {
        assertThat(cardsGame.startOut(List.of("K", "A"), List.of("A", "K"))).isEqualTo("Players tied");
    }
}
