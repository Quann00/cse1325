package mdi;

public class SplashScreen {
    
    public static void show() {
        System.out.println("\n");
        
        System.out.println(" /$$      /$$                                                              ");
        System.out.println("| $$$    /$$$                                                              ");
        System.out.println("| $$$$  /$$$$  /$$$$$$  /$$$$$$$  /$$   /$$                                ");
        System.out.println("| $$ $$/$$ $$ /$$__  $$| $$__  $$| $$  | $$                                ");
        System.out.println("| $$  $$$| $$| $$$$$$$$| $$  \\ $$| $$  | $$                                ");
        System.out.println("| $$\\  $ | $$| $$_____/| $$  | $$| $$  | $$                                ");
        System.out.println("| $$ \\/  | $$|  $$$$$$$| $$  | $$|  $$$$$$/                                ");
        System.out.println("|__/     |__/ \\_______/|__/  |__/ \\______/");
        System.out.println("\n");
        System.out.println("                           CSE 1325");
        System.out.println("                    Loading . . . . . .\n");
        
        try {
            Thread.sleep(3000);  //  3 seconds pause
        } catch (Exception e) {

        }
    }
}