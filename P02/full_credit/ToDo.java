import java.util.Scanner;
// Part 1 
class Item {
    public int priority;
    public String task;
}

public class ToDo {
    public static void main (String[] args) {
        int numOfItem;

        if(args.length < 1) {
            numOfItem = 5;
        }
        else {
            numOfItem = Integer.parseInt(args[0]);
        }

        // Initialize array
        Item[] item = new Item[numOfItem];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numOfItem; i++)
        {   
            item[i] = new Item();
            System.out.printf("Task #" + i + ": ");
            item[i].task = scanner.nextLine();
        
        }

    }
}