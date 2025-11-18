
import java.util.TreeMap;
import java.util.Map;
import qlogger.Qlogger;

public class ThreadedPrimes extends Primes{
    
    private static final Object lock = new Object();


    @Override
    public void search(long begin, long end, int numThreads){

        Thread[] threads = new Thread[numThreads];
        long delta = (end - begin) / numThreads;

        for (int i = 0; i <= numThreads-1; i++){
            final int threadID = i;
            final long beginSlice = begin;
            final long endSlice;

            if ( i == numThreads - 1){
                endSlice = end;
            }
            else {
                endSlice = begin + delta;
            }
        


            threads[i] = new Thread(() -> {findPrimes(beginSlice, endSlice, threadID);});

            threads[i].start();

            begin += delta + 1;
        }

        for (Thread thread : threads) try {
            thread.join();} catch (InterruptedException e){

            }
    }


    @Override
    protected void addPrime(long prime, int threadID){
        synchronized(lock) {
            super.addPrime(prime, threadID);
        }
    }
}