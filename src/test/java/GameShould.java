import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameShould {
    private Game cardsGame;

    @BeforeEach
    void init() {
        cardsGame = new Game();
    }

    @Test
    void stop_game_with_message_if_the_format_is_incorrect() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.findWinner(List.of("3"), List.of("J", "K"))
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide correct format");

        exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.findWinner(List.of("k", ""), List.of("j", "j"))
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide a player cards");

        exception = assertThrows(
                IllegalArgumentException.class, () -> cardsGame.findWinner(List.of("Z", "K"), List.of("J", "3"))
        );

        assertThat(exception.getMessage()).isEqualTo("You have to provide a valid card");
    }

    @Test
    void return_winner_whit_only_one_card() {
        assertThat(cardsGame.findWinner(List.of("3", ""), List.of("A", ""))).isEqualTo("Player 2 win 1 to 0");
    }

    @Test
    void return_winner_whit_two_cards() {
        assertThat(cardsGame.findWinner(List.of("K", "9"), List.of("J", "5"))).isEqualTo("Player 1 win 2 to 0");
    }

    @Test
    void return_tied_if_nobody_win() {
        assertThat(cardsGame.findWinner(List.of("K", "A"), List.of("A", "K"))).isEqualTo("Players tied");
    }
}
