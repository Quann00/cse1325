import java.util.Scanner;

public class Hello
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("What is your name? ");
    String s1 = scanner.nextLine();
    System.out.println("Hello, " + s1 + "!");

  }
}