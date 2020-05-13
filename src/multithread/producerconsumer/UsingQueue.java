package multithread.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author onion
 * @date 2020/4/30 -2:55 下午
 */
public class UsingQueue {
    public static void main(String[] args) {
        Resource resource = new Resource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            try {
                resource.product();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"produce").start();
        new Thread(()->{
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consume").start();
    }
}
class Resource{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;
    public Resource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void product() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t" + "插入队列" + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t" + "插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("生产结束");
    }
    public void consume() throws InterruptedException {
        String data = null;
        while (flag) {
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (data == null){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "超时，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "消费队列" + data + "成功");
        }
        System.out.println("生产结束");
    }
}
