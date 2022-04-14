import { CardsGame } from "../CardsGame";

describe("Cards Game Should", () => {
  let cardsGame: CardsGame;

  beforeEach(() => {
    cardsGame = new CardsGame();
  });

  describe("Exception handling", () => {
    it("Returns message when player hands are empty", () => {
      const player1Hand: string[] = [];
      const player2Hand: string[] = [];

      expect(() => cardsGame.play(player1Hand, player2Hand)).toThrowError(
        "You have to provide correct format"
      );
    });
    it("Returns message when player cards are invalid", () => {
      const player1Hand: string[] = ["", ""];
      const player2Hand: string[] = ["", ""];

      expect(() => cardsGame.play(player1Hand, player2Hand)).toThrowError(
        "You have to provide valid cards"
      );
    });
  });

  describe("Winner", () => {
    it("Returns winner", () => {
      const player1Hand: string[] = ["k", "j"];
      const player2Hand: string[] = ["6", "3"];

      expect(cardsGame.play(player1Hand, player2Hand)).toBe("Player 1 wins");
    });
    it("Returns tied if nobody is winner", () => {
      const player1Hand: string[] = ["A", "2"];
      const player2Hand: string[] = ["2", "A"];

      expect(cardsGame.play(player1Hand, player2Hand)).toBe("Players tied");
    });
  });
});
