import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] heap = {1, 3, 5, 7};
        int player = 0;


        do {
            out(heap);
            displayPlayer(player);
            makeTurn(heap);
            player = changePlayer(player);
        } while (!haveWinner(heap));

        showWinner(player);
    }

    public static int changePlayer(int player){
        int newPlayer = 1;

        if(player == 1){
            newPlayer = 2;
        }
        return newPlayer;
    }
    public static void out(int[] heap) {
        for (int i = 0; i < heap.length; i++) {
            for (int j = 0; j < ((2 * heap.length) - heap[i]) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < heap[i]; j++) {
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void displayPlayer(int player) {
        System.out.println();
        System.out.println();
        System.out.println("It is Player " + changePlayer(player) + "'s turn!");
    }

    public static boolean isInputOk(int[] matches, int heap, int count) {
        int countHeap = matches.length;

        if (heap > countHeap || heap < 0) return false;
        if (count > 3 || count < 1) return false;
        if (matches[heap - 1] < count) return false;

        return true;
    }

    public static void makeTurn(int[] matches) {
        int heap = 0;
        int count = 0;
        boolean userInputIsOk = false;

        do
        {
            System.out.println("Remove matches from what pile?");

            boolean inputOk = false;

            do
            {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();

                try {
                    heap = Integer.parseInt(input);
                    inputOk = true;
                }
                catch(Exception ex)
                {
                    System.out.println("Invalid Input! Only enter numbers!");
                    System.out.println("Remove matches from what pile?");
                    ex.printStackTrace();
                    inputOk = false;
                }
            } while (!inputOk);

            System.out.println("How many matches do you want to remove?");

            inputOk = false;
            do
            {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                try {
                    count = Integer.parseInt(input);
                    inputOk = true;
                }
                catch (Exception ex)
                {
                    System.out.println("Invalid Input! Only enter numbers!");
                    System.out.println("How many matches do you want to remove?");
                    ex.printStackTrace();
                    inputOk = false;
                }
            } while (!inputOk);

            userInputIsOk = isInputOk(matches, heap, count);

            if (userInputIsOk)
            {
                matches[heap - 1] -= count;
            }
            else
            {
                System.out.println("Invalid Input!");
            }
        } while (!userInputIsOk);
    }
    public static boolean haveWinner(int[] matches)
    {
        for (int i = 0; i < matches.length; i++) {
            if (matches[i] > 0) {return false;}
        }return true;
    }
    static void showWinner(int player)
    {
        System.out.println();
        switch (player)
        {
            case 1:
                System.out.println("Player 1 has won!!!");
                break;
            default:
                System.out.println("Player 2 has won!!!");
                break;
        } System.out.println();
    }
}