from src.rules import Rules


class CardGame:
    rules: Rules = Rules()

    def play(self, player1Hand: list, player2Hand: list) -> str:
        self.rules.isValid(player1Hand, player2Hand)

        return self.whoWins(player1Hand, player2Hand)

    def whoWins(self, player1Hand: list, player2Hand: list) -> str:
        player1Value = self.getCardsValue(
            player1Hand.__getitem__(0), player1Hand.__getitem__(1))
        player2Value = self.getCardsValue(
            player2Hand.__getitem__(0), player2Hand.__getitem__(1))

        if player1Value > player2Value:
            return "Player 1 wins"
        if player1Value < player2Value:
            return "Player 2 wins"
        return "Draw"

    def getCardsValue(self, leftCard: str, rightCard) -> int:
        return self.rules.CARDS_VALUES.index(leftCard.upper()) + self.rules.CARDS_VALUES.index(rightCard.upper())
