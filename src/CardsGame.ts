export class CardsGame {
  public play(player1Hand:string[],player2Hand:string[]): string {
    this.isValid(player1Hand,player2Hand);

    return "";
  }

  private isValid(player1Hand:string[],player2Hand:string[]): void {
    const hadEmptyHand = this.hadEmptyHands(player1Hand, player2Hand);
    if(hadEmptyHand){
      throw new Error("You have to provide correct format");
    }

  }

  private hadEmptyHands(player1Hand: string[], player2Hand: string[]) {
    return player1Hand.length != 2 && player2Hand.length != 2;
  }
}
