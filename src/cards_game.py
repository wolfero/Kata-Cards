class CardGame:
    CARDS_VALUES = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"]

    def play(self,player1Hand: list[str], player2Hand: list[str]) -> str:
        self.isValid(player1Hand, player2Hand)
        
        return ""

    def isValid(self, player1Hand: list[str], player2Hand: list[str]):
        self.hadEmptyHand(player1Hand, player2Hand)

    def hadEmptyHand(self, player1Hand: list[str], player2Hand: list[str]):        
        if player1Hand.count!=2 or player2Hand.count!=2:
            raise ValueError("You have to provide correct format")
