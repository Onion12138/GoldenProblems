package algorithm.design;

/**
 * @author onion
 * @date 2020/4/28 -9:36 上午
 *
 * 已知一个消息流会不断地吐出整数1 \sim N1∼N，但不一定按照顺序吐出。
 * 如果上次打印的数为i，那么当i+1出现时，请打印i+1及其之后接收过的并且连续的所有数，直到1 \sim N1∼N全部接收并打印完。
 * 请设计这种接收并打印的结构
 * [要求]
 * 消息流最终会吐出全部的1 \sim N1∼N，当然最终也会打印完所有的1\sim N1∼N，要求接收和打印1 \sim N1∼N的整个过程，时间复杂度为O(N)O(N)。
 */
import java.util.HashMap;
import java.util.Scanner;

class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val=val;
    }
}

class Message{
    HashMap<Integer,Node> headMap=new HashMap();
    HashMap<Integer,Node> tailMap=new HashMap();
    int lastPrint=0;

    public void receive(int num) {
        Node node=new Node(num);
        headMap.put(num, node);
        tailMap.put(num,node);

        if(headMap.containsKey(num+1)) {
            node.next=headMap.get(num+1);
            headMap.remove(num+1);
            headMap.put(num,node);
        }
        if(tailMap.containsKey(num-1)) {
            tailMap.get(num-1).next=node;
            tailMap.remove(num-1);
            tailMap.put(num,node);
        }
        if(headMap.containsKey(lastPrint+1)) {
            print();
        }
    }

    private void print() {//
        Node node=headMap.get(lastPrint+1);
        headMap.remove(lastPrint+1);
        while(node.next!=null) {
            System.out.println(node.val);
            ++lastPrint;
            node=node.next;
        }
        System.out.println(node.val);
        ++lastPrint;
        tailMap.remove(node.val);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Message mes=new Message();
        while(in.hasNext()) {
            int num=in.nextInt();
            mes.receive(num);
        }
    }
}
