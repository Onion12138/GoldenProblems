package multithread.future;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author onion
 * @date 2020/4/27 -9:01 上午
 */
public class MultiFuture {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = service.submit(() -> {
                TimeUnit.SECONDS.sleep(3);
                return new Random().nextInt();
            });
            futures.add(future);
        }
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = futures.get(i);
            try {
                Integer integer = future.get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
