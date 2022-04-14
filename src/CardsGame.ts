export class CardsGame {
  private readonly CARDS_VALUES:string[] = ["2","3","4","5","6","7","8","9","10","J","Q","K","A"];

  public play(player1Hand:string[],player2Hand:string[]): string {
    this.validate(player1Hand,player2Hand);
    
    return "";
  }

  private validate(player1Hand:string[],player2Hand:string[]): void {
    const hadEmptyHand = this.hadEmptyHands(player1Hand, player2Hand);
    if(hadEmptyHand){
      throw new Error("You have to provide correct format");
    }
    
    const shouldValidCard=this.isValidCard(player1Hand)&& this.isValidCard(player2Hand);
    if(!shouldValidCard){
      throw new Error("You have to provide valid cards");
    }
  }

  private isValidCard([card1, card2]: string[]):boolean {
    if (this.CARDS_VALUES.includes(card1) && this.CARDS_VALUES.includes(card2)) return true;
    return false;
  }

  private hadEmptyHands(player1Hand: string[], player2Hand: string[]):boolean {
    return player1Hand.length != 2 && player2Hand.length != 2;
  }
}
