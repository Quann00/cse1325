
import qlogger.Qlogger;


public class ListPrimes {
   public static void main(String[] args){
    Qlogger.enabled = false;

    if (args.length != 3){
        System.out.println("usage: java ListPrimes <begin> <end> <#threads>"); return;
    }
   
    long begin = Long.parseLong(args[0].replaceAll("_", ""));
    long end = Long.parseLong(args[1].replaceAll("_", ""));
    int numThreads = Integer.parseInt(args[2].replaceAll("_", ""));


    Primes primes = new Primes();

    if (numThreads == 0) {
        primes = new Primes();
    }
    else {
        primes = new ThreadedPrimes();
    }
    /*if (numThreads < 0 ){
        primes = new PooledPrimes();    this for bonus part
    }*/

    primes.search(begin, end, numThreads);

   
    Qlogger.log("Found:  " + primes.size() + " primes! " + "\n");
    Qlogger.log(primes.toString());
   
   }
}