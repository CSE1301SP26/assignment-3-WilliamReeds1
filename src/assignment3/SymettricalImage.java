
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
        int num = (n * m) / 2;
        //my code is wierd so im adjusting the calculation for num
        for (int i = 0; i < image.length; i++) {
            boolean isEnd = true;
            double random = (Math.random() * (m));
            int randomRounded = (int) Math.round(random);

            //this area is to check if the number of generated stars on the row is possible
            //for example, an uneven number cannot be even on an even number of columns
            while (((m % 2) != 0) && ((randomRounded % 2) == 0)) {
                random = (Math.random() * (m));
                randomRounded = (int) Math.round(random);
            }
            while (((m % 2) == 0) && ((randomRounded % 2) != 0)) {
                random = (Math.random() * (m));
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
                    random = (Math.random() * (m));
                    randomRounded = (int) Math.round(random);
                }
                if (isEnd == false) {

                    //to redo entire generation
                    while (((m % 2) != 0) && ((randomRounded % 2) == 0)) {
                        random = (Math.random() * (m));
                        randomRounded = (int) Math.round(random);
                    }
                    while (((m % 2) == 0) && ((randomRounded % 2) != 0)) {
                        random = (Math.random() * (m));
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
            if ((image[i].length % 2) != 0) {// checking even or odd
                for (int j = 0; j < image[i].length; j++) {

                    if ((numPerRow[i] % 2) != 0) {
                        int counter = 2;
                        int numOfSpaces = (image[i].length - numPerRow[i]) / 2;
                        //for this we know that if the number is odd, then there must be on in the middle and the remainer on each side\
                        int middle = ((image[i].length) / 2);//correct by index
                        if ((j != middle) && (j < middle) && (numOfSpaces != 0)) {
                            double space = Math.random();
                            if (space >= 0.5) {
                                image[i][j] = ".";
                            } else {
                                image[i][j] = "*";
                            }
                        } else if ((j == middle)) {
                            image[i][j] = "*";
                        } else {
                            image[i][j] = image[i][(j - counter)];
                            counter += 2;
                        }
                    } else {
                        //this is the case in which the number of columns are uneven, but even number of Stars
                        int numOfSpaces = ((image[i].length - numPerRow[i]) / 2) + 1; //1 added do to round down
                        int middle = ((image[i].length) / 2);
                        int counter = 2;
                        if ((j != middle) && (j < middle) && (numOfSpaces != 0)) {
                            double space = Math.random();
                            if (space >= 0.5) {
                                image[i][j] = ".";
                            } else {
                                image[i][j] = "*";
                            }
                            image[i][image[i].length - 1 - j] = image[i][j];
                        } else if ((j == middle)) {
                            image[i][j] = ".";
                        }
                    }
                    if (image[i].length % 2 != 0) {
                        int middle = image[i].length / 2;

                        double space = Math.random();

                        if (space >= 0.5) {
                            image[i][middle] = ".";
                        } else {
                            image[i][middle] = "*";
                        }
                    }
                    image[i][image[i].length - 1 - j] = image[i][j];
                }
                if (image[i].length % 2 != 0) {
                    int middle = image[i].length / 2;

                    double space = Math.random();

                    if (space >= 0.5) {
                        image[i][middle] = ".";
                    } else {
                        image[i][middle] = "*";
                    }
                }
            } else {// even
                int counter = -1;
                for (int j = 0; j < image[i].length; j++) {

                    int numOfSpaces = (image[i].length - numPerRow[i]) / 2;
                    int halfwayIndex = (image[i].length / 2);
                    if ((j < halfwayIndex) && (numOfSpaces != 0)) {
                        double space = Math.random();
                        if (space >= 0.5) {
                            image[i][j] = ".";
                        } else {
                            image[i][j] = "*";
                        }

                    } else {
                        image[i][j] = "*";
                    }
                    if (j >= halfwayIndex) {
                        image[i][j] = image[i][image[i].length - j - 1];
                    }
                }
            }
        }

        System.out.println("Image Generation Done! \n \n ");
        for (int i = 0; i < image[0].length; i++) {
            System.out.print(image[3][i]);
        }

        System.out.println("Printed image \n");
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {

                System.out.print(image[i][j]);
            }
            System.out.println(" ");
        }

    }
}
