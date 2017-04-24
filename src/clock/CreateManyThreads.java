
package clock;

public class CreateManyThreads {
    static Threader[] threads;
    static void createNewThread(int n){
        threads = new Threader[n];
        for(int i=0; i<n; i++){
            int time = i*86400/n;
            threads[i] = new Threader(time,n);
            threads[i].setPriority(10);
            threads[i].start();
        }
    }
}
