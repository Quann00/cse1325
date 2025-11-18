
import java.util.TreeMap;
import java.util.Map;

public class PooledPrimes extends ThreadedPrimes{
    private long currentSlice;
    private long endSlice;
    private long sliceSize;

    @Override
    public void search(long begin, long end, int numThreads){

        int SLICES = 50;
        sliceSize = 1 + (end - begin) / SLICES;

        currentSlice = begin - sliceSize;

        endSlice = end;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i <= numThreads-1; i++){
            final int threadID = i;
            threads[i] = new Thread(() -> searchWorker(threadID));
            threads[i].start();
            }
        for (Thread thread : threads) try {
            thread.join();} catch (InterruptedException e){

            }


    }

    public void searchWorker(int threadID){

        while (true){
            long slice = nextSlice();
            if (slice < 0 ) return;

            if (slice => 0){
                findPrimes(endSlice);
            }
        }

        

    }

    public long nextSlice(){

    }
}