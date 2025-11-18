
import java.util.TreeMap;
import java.util.Map;
import qlogger.Qlogger;


public class Primes {
    private long maxPrime = 0;
    private Map<Long, Integer> primes = new TreeMap<>();

    public static boolean isPrime(long number){
        if (number < 2) return false;

        for (long i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }

        return true;
    }

    public void search(long begin, long end, int numThreads){
        findPrimes(begin, end, 1);
    }

    public int size(){
        return primes.size();
    }

    @Override
    public String toString(){
        int field = String.valueOf(maxPrime).length();

        String sum = "";
        for (var key : primes.keySet()){
            System.out.println(String.format("% " + field + "d found by thread %d\n", key, primes.get(key)));
            
        }
        
        return sum;
    }

    protected void findPrimes(long begin, long end, int threadID){
        Qlogger.log("Thread " + threadID + " is searching "  + begin + " to " + end + "\n");

        for (var i = begin; i < end-1; i++){
            if (isPrime(i)){
                addPrime(i, threadID);
            }

        }
        
    }

    protected void addPrime(long prime, int threadID){
        primes.put(prime, threadID);
        if (prime > maxPrime){
            maxPrime = prime;
        }
    }

}