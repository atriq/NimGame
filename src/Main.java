import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] heap = {1, 3, 5, 7};
        int player = 0;

        do {
            out(heap);
            turn(player);
            makeTurn(heap);
            changePlayer(player);
        } while (!haveWinner(heap));

        showWinner(player);
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

    public static void turn(int player) {
        System.out.println();
        System.out.println();
        System.out.println("It is " + player + " turn!");
    }

    public static boolean isInputOk(int[] woods, int heap, int count) {
        int countHeap = woods.length;

        if (heap > countHeap || heap < 0) return false;
        if (count > 3 || count < 1) return false;
        if (woods[heap - 1] < count) return false;

        return true;
    }

    public static void makeTurn(int[] woods) {
        int heap = 0;
        int count = 0;
        boolean userInputIsOk = false;

        do
        {
            System.out.println("Streichhoelzer von welchem Haufen entfernen? ");

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
                    System.out.println("Ungueltige Eingabe. Bitte nur Zahlen eingeben!");
                    System.out.println("Streichhoelzer von welchem Haufen entfernen? ");
                    ex.printStackTrace();
                    inputOk = false;
                }
            } while (!inputOk);

            System.out.println("Wieviele Hoelzer entfernen? ");

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
                    System.out.println("Ungueltige Eingabe. Bitte nur Zahen eingeben!");
                    System.out.println("Wieviele Hoelzer entfernen? ");
                    ex.printStackTrace();
                    inputOk = false;
                }
            } while (!inputOk);

            userInputIsOk = isInputOk(woods, heap, count);

            if (userInputIsOk)
            {
                woods[heap - 1] -= count;
            }
            else
            {
                System.out.println("Ungueltige Eingabe!");
            }
        } while (!userInputIsOk);
    }



    public static void changePlayer(int player)
    {
        if (player == 0) {player = 1;}
        else {player = 0;}
    }
    public static boolean haveWinner(int[] woods)
    {

        for (int i = 0; i < woods.length; i++) {
            if (woods[i] > 0) {return false;}
        }return true;
    }
    static void showWinner(int player)
    {
        System.out.println();
        switch (player)
        {
            case 1:
                System.out.println("Spieler 1 hat gewonnen!!!");
                break;
            default:
                System.out.println("Spieler 2 hat gewonnen!!!");
                break;
        } System.out.println();
    }
}