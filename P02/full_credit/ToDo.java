import java.util.Scanner;
// Final Part
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

            System.out.printf("Priority from 1 (highest) to 5 (lowest): ");
            item[i].priority = scanner.nextInt(); //read which one is highest priority
            scanner.nextLine(); // take newline character
        
        }
        for (int j = 1; j <= 5; j++)
        {
            for (int i = 0; i < numOfItem; i++)
            {
                if (item[i].priority == j)
                {
                    System.out.println(j + " " + item[i].task);
                }

            }
        }

    }
}