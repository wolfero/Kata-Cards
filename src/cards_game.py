class CardGame:
    CARDS_VALUES = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"]

    def play(self, player1Hand: list, player2Hand: list) -> str:
        self.isValid(player1Hand, player2Hand)

        return self.whoWins(player1Hand, player2Hand)

    def isValid(self, player1Hand: list, player2Hand: list):
        self.hadEmptyHand(player1Hand, player2Hand)

        # self.hadValidCards(player1Hand, player2Hand)

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
        return self.CARDS_VALUES.index(leftCard.upper()) + self.CARDS_VALUES.index(rightCard.upper())

    def hadEmptyHand(self, player1Hand: list, player2Hand: list):
        if len(player1Hand) != 2 or len(player2Hand) != 2:
            raise ValueError("You have to provide correct format")
