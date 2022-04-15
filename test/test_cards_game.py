from unittest import TestCase
from assertpy import assert_that

from src.cards_game import CardGame


class TestCardsGame(TestCase):
    def test_returns_message_when_player_hands_are_empty(self):
        cardGame = CardGame()

        assert_that(cardGame.play).raises(ValueError).when_called_with([], [])

    def test_returns_message_when_player_cards_are_invalid(self):
        cardGame = CardGame()

        assert_that(cardGame.play).raises(
            ValueError).when_called_with(["z", "f"], ["f", "f"])

    def test_returns_winner(self):
        cardGame = CardGame()

        assert_that(cardGame.play(["K", "J"], ["K", "2"])).is_equal_to("Player 1 wins")

    def test_returns_draw_if_nobody_is_winner(self):
        cardGame = CardGame()

        assert_that(cardGame.play(["Q", "A"], ["A", "Q"])).is_equal_to("Draw")
