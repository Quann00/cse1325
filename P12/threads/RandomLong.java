import java.util.Random;

public class RandomLong{
    private int digits;
    private Random random;
    private long result;
    private static final Object lock = new Object();


    // thread main
    public static void main(String[] args){
        if (args.length != 1){
        System.out.println("usage: >>java ListPrimes <digits> "); return;
        }
        int digits = Integer.parseInt(args[0].replaceAll("_", ""));

        RandomLong random = new RandomLong(digits);

        System.out.println("A long with " + digits + " digits is " + random.nextLong());
        // something return to default if java RandomLong only
    }

    

    public RandomLong(int digits){
        this.digits = digits;
        this.random = new Random();
        this.result = 0;

    }

    public long nextLong(){

        Thread[] threads = new Thread[digits];

        for (int i = 0; i <= digits-1; i++){
            final int digit = i;

        

            threads[i] = new Thread(() -> {insertDigit(digit);});

            threads[i].start();

        }

        for (Thread thread : threads) try {
            thread.join();} catch (InterruptedException e){

            }

        return result;        
    }
    

    // thread interference something syschronize
    private void insertDigit(int digit){
        //random time
        try{
            Thread.sleep(random.nextInt(201));
            } catch(InterruptedException e) {
                }
        
        synchronized(lock) { // default formula
            result = result * 10 + digit;
        }
    
    }
}