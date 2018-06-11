package goldmansachs;

import java.util.Random;

public class ShuffleCards {

	public static void shuffle(){
        int[] cards = new int[52];

        //--- Initialize
        for (int i=0; i<cards.length; i++) {
            cards[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int randomPosition = random.nextInt(cards.length);
            int temp = cards[i];
            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }

        for(int card : cards){
            System.out.print(" " +card);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
