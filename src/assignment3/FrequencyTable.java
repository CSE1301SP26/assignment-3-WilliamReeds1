
import java.util.Scanner;

public class FrequencyTable {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many dice do you want rolled per round? ");
        int numberDice = in.nextInt();

        int[] dice = new int[numberDice]; //for each dice role

        //for calculating total size of array for sum
        int largestSum = (numberDice * 6);
        int[] sum = new int[((largestSum - numberDice) + 1)]; //minus numberDice because smallest sum is the number of dice
        //added by 1 because the way I coded my array to corespond with the sum values, the sum will be associated with the index 
        //the number of dice less than it, but this makes it only go through all, but the last value in the array since it includes the end point.

        for (int i = 0; i < 10000; i++) { //this code is for each roll round that is simulated
            int sumTemp = 0;

            for (int rolls = 0; rolls < dice.length; rolls++) {
                double random = (Math.random() * (5) + 1);
                int diceRoll = (int) Math.round(random);  //rounding an generating dice rolls for each round
                sumTemp += diceRoll;  //this creates a temporary sum for the round
            }

            sum[((sumTemp - (numberDice)))] += 1; //this uses sum as a number counter and for each time the sum is hit, at the coresponding
            //point it should be ticked up by 1.

        }

        System.out.println("Number of Times each value was rolled: ");
        for (int i = 0; i < sum.length; i++) {  //prints all sums that occured
            System.out.println((i + numberDice) + ": " + sum[i]);
        }
        System.out.println((int) 7 / 2);
    }
}
