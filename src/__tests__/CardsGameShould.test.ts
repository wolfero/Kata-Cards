import { CardsGame } from "../CardsGame";

describe("Cards Game Should", () => {
  describe("Exception handling", () => {
    it("Returns message when player hands are empty", () => {
      const cardsGame = new CardsGame();
      
      const player1Hand:string[]= [];
      const player2Hand:string[]= [];

      expect(() => cardsGame.play(player1Hand,player2Hand)).toThrowError(
        "You have to provide correct format"
      );
    });
    
  });

});
