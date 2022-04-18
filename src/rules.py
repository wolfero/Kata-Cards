class Rules:
    CARDS_VALUES = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"]

    def isValid(self, player1Hand: list, player2Hand: list):
        self.hadEmptyHand(player1Hand, player2Hand)

    def hadEmptyHand(self, player1Hand: list, player2Hand: list):
        if len(player1Hand) != 2 or len(player2Hand) != 2:
            raise ValueError("You have to provide correct format")
