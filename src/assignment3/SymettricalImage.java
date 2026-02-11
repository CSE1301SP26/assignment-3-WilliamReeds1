
import java.util.Scanner;

public class SymettricalImage {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How big do you want your image? ");
        System.out.print("\n How many rows: ");
        int n = in.nextInt();
        System.out.print("\n How many columns: ");
        int m = in.nextInt();

        String[][] image = new String[n][m];
        int[] numPerRow = new int[n];
        int num = (n * m) / 4;
        System.out.println("Number of Stars should be " + num);
        //for a cooler image because i go above and beyond
        int numMaxPerRow = (int) num / (m / 2);
        for (int i = 0; i < image.length; i++) {
            boolean isEnd = true;
            double random = (Math.random() * (numMaxPerRow));
            int randomRounded = (int) Math.round(random);

            //this area is to check if the number of generated stars on the row is possible
            //for example, an uneven number cannot be even on an even number of columns
            while (((m % 2) != 0) && ((randomRounded % 2) == 0)) {
                random = (Math.random() * (numMaxPerRow));
                randomRounded = (int) Math.round(random);
            }
            while (((m % 2) == 0) && ((randomRounded % 2) != 0)) {
                random = (Math.random() * (numMaxPerRow));
                randomRounded = (int) Math.round(random);
            }

            while ((num - randomRounded) < 0) {
                if ((image.length - 1) == 1) {

                    if ((m % 2) == 0) {
                        isEnd = false;
                    } else {
                        randomRounded = num;
                    }
                } else {
                    random = (Math.random() * (numMaxPerRow));
                    randomRounded = (int) Math.round(random);
                }
                if (isEnd == false) {

                    //to redo entire generation
                    while (((m % 2) != 0) && ((randomRounded % 2) == 0)) {
                        random = (Math.random() * (numMaxPerRow));
                        randomRounded = (int) Math.round(random);
                    }
                    while (((m % 2) == 0) && ((randomRounded % 2) != 0)) {
                        random = (Math.random() * (numMaxPerRow));
                        randomRounded = (int) Math.round(random);
                    }
                }

            }

            numPerRow[i] = randomRounded;
            num -= randomRounded;

            //but for even ones, we have to make sure the result doesn't end in an 
            System.out.println("Num on this row: " + randomRounded + ". Num Remaining: " + num);
        }

        System.out.println("\n \n Image Generationing... \n");

        for (int i = 0; i < image.length; i++) {

            int stars = numPerRow[i];
            int half = image[i].length / 2;

            // Fill left half
            int starsOnLeft = stars / 2;

            for (int j = 0; j < half; j++) {
                if (j < starsOnLeft) {
                    image[i][j] = "*";
                } else {
                    image[i][j] = ".";
                }
            }

            // Handle middle if odd number of columns
            if (image[i].length % 2 != 0) {
                int middle = half;
                if (stars % 2 != 0) {
                    image[i][middle] = "*";
                } else {
                    image[i][middle] = ".";
                }
            }

            // Mirror left half to right half
            for (int j = 0; j < half; j++) {
                image[i][image[i].length - 1 - j] = image[i][j];
            }
        }

        System.out.println("Image Generation Done! \n \n ");

        System.out.println("Printed image \n");
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {

                System.out.print(image[i][j]);
            }
            System.out.println(" ");
        }

    }
}
