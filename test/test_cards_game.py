from unittest import TestCase
from assertpy import assert_that

from src.cards_game import CardGame


class TestCardsGame(TestCase):
    def test_returns_message_when_player_hands_are_empty(self):
        cardGame = CardGame()

        assert_that(cardGame.play).raises(ValueError).when_called_with([], [])
    
    def test_returns_message_when_player_cards_are_invalid(self):
        cardGame = CardGame()

        assert_that(cardGame.play).raises(ValueError).when_called_with(["z", "f"], ["f", "f"])