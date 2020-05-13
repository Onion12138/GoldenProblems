package multithread.future;

import java.util.concurrent.*;

/**
 * @author onion
 * @date 2020/4/27 -8:56 上午
 */
public class OneFuture {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            throw new RuntimeException("执行异常");
        });
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                TimeUnit.MILLISECONDS.sleep(500);
            }
            System.out.println(future.isDone());
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
