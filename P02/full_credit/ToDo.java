import java.util.Scanner;
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
    }
}