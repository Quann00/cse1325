
import qlogger.Qlogger;

public class ListPrimes{
   public void main(String[] args){
    Qlogger.enabled = true;

    if (args.length != 3){
        System.out.println("usage: java ListPrimes <begin> <end> <#threads>"); return;
    }
   
    long begin = Long.parseLong(args[0].replaceAll("_", ""));
    long end = Long.parseLong(args[1].replaceAll("_", ""));
    int numThreads = Integer.parseInt(args[2].replaceAll("_", ""));

    Primes primes = new Primes();

    primes.search(begin, end, numThreads);

   
    Qlogger.log("Primes:  " + primes.size());
    Qlogger.log(primes.toString());
   
   }
}