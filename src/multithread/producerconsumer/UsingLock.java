package multithread.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author onion
 * @date 2020/4/30 -2:37 下午
 */
public class UsingLock {
    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.increment();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.decrement();
            }
        },"BB").start();
    }
}
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement() {
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
