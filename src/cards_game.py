class CardGame:
    CARDS_VALUES = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"]

    def play(self,player1Hand: list, player2Hand: list) -> str:
        self.isValid(player1Hand, player2Hand)
        return ""

    def isValid(self, player1Hand: list, player2Hand: list):
        self.hadEmptyHand(player1Hand, player2Hand)
        
        self.CARDS_VALUES.index(player1Hand.__getitem__(0))
        self.CARDS_VALUES.index(player1Hand.__getitem__(1))
        self.CARDS_VALUES.index(player2Hand.__getitem__(0))
        self.CARDS_VALUES.index(player2Hand.__getitem__(1))
        
        
        
        

    def hadEmptyHand(self, player1Hand: list, player2Hand: list):    
        if len(player1Hand)!=2 or len(player2Hand)!=2:
            raise ValueError("You have to provide correct format")
