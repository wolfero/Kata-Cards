export class Rules {
  public readonly CARDS_VALUES: string[] = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",];

  public validate(player1Hand: string[], player2Hand: string[]): void {
    this.hadEmptyHands(player1Hand, player2Hand);

    this.hadValidCards(player1Hand);

    this.hadValidCards(player2Hand);
  }

  private hadEmptyHands(player1Hand: string[], player2Hand: string[]): void {
    const hadEmptyHand = player1Hand.length != 2 && player2Hand.length != 2;
    if (hadEmptyHand) throw new Error("You have to provide correct format");
  }

  private hadValidCards([card1, card2]: string[]): void {
    const leftCard = this.CARDS_VALUES.includes(card1.toUpperCase());
    const rightCard = this.CARDS_VALUES.includes(card2.toUpperCase());
    if (!(leftCard && rightCard))
      throw new Error("You have to provide valid cards");
  }
}
