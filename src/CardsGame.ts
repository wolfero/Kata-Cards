import { Rules } from "./Rules";

export class CardsGame {
  private readonly rules: Rules = new Rules();

  public play(player1Hand: string[], player2Hand: string[]): string {
    this.rules.validate(player1Hand, player2Hand);

    return this.whoIsWinner(player1Hand, player2Hand);
  }

  private whoIsWinner(player1Hand: string[], player2Hand: string[]): string {
    const player1CardsValue = this.getCardsValue(player1Hand);
    const player2CardsValue = this.getCardsValue(player2Hand);

    if (this.shouldPlayer1Win(player1CardsValue, player2CardsValue))
      return "Player 1 wins";
    if (this.shouldPlayer2Win(player1CardsValue, player2CardsValue))
      return "Player 2 wins";
    return "Players tied";
  }

  private getCardsValue([leftCard, rightCard]: string[]): number {
    const leftCardValue = this.rules.CARDS_VALUES.indexOf(leftCard.toUpperCase());
    const rightCardValue = this.rules.CARDS_VALUES.indexOf(rightCard.toUpperCase());
    return leftCardValue + rightCardValue;
  }

  private shouldPlayer1Win(player1CardsValue: number, player2CardsValue: number): boolean {
    return player1CardsValue > player2CardsValue;
  }

  private shouldPlayer2Win(player1CardsValue: number, player2CardsValue: number) {
    return player1CardsValue < player2CardsValue;
  }
}
