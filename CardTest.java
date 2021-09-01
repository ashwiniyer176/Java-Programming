import java.util.Scanner;

public class CardTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cards = new char[4];
        for (int i = 0; i < cards.length; ++i) {
            System.out.print("Give Card:");
            char s = in.next().charAt(0);
            cards[i] = s;
        }
        Hand myHand = new Hand();
        myHand.encodeCards(cards);
        myHand.showHand();
        int score = myHand.handScore();
        System.out.println("\nCurrent Hand Value:" + score);
        in.close();
    }
}

class Hand {
    int[] currentHand = new int[] { 0, 0, 0, 0 };

    public void encodeCards(char[] cards) {
        for (int i = 0; i < cards.length; ++i) {
            switch (Character.toLowerCase(cards[i])) {
                case 'a':
                    this.currentHand[i] = 1;
                    break;

                case 'j':
                    this.currentHand[i] = 11;
                    break;

                case 'k':
                    this.currentHand[i] = 13;
                    break;

                case 'q':
                    this.currentHand[i] = 12;
                    break;
                default:
                    this.currentHand[i] = Character.getNumericValue(cards[i]);
            }

        }
    }

    public void showHand() {
        System.out.println("Current Hand");
        for (int card : this.currentHand) {
            System.out.print(card + " ");
        }
    }

    public int handScore() {
        int score = 0;
        for (int i = 0; i < currentHand.length; ++i) {
            if (currentHand[i] <= 10)
                score += this.currentHand[i];
            else
                score += 10;
        }
        return score;
    }
}