export class CardsGame {
  private readonly CARDS_VALUES:string[] = ["2","3","4","5","6","7","8","9","10","J","Q","K","A"];

  public play(player1Hand:string[],player2Hand:string[]): string {
    this.isValid(player1Hand,player2Hand);
    
    return "";
  }

  private isValid(player1Hand:string[],player2Hand:string[]): void {
    const hadEmptyHand = this.hadEmptyHands(player1Hand, player2Hand);
    if(hadEmptyHand){
      throw new Error("You have to provide correct format");
    }
    throw new Error("You have to provide valid cards");
  }

  private hadEmptyHands(player1Hand: string[], player2Hand: string[]) {
    return player1Hand.length != 2 && player2Hand.length != 2;
  }
}
