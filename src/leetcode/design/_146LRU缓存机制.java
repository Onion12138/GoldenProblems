package leetcode.design;

import algorithm.annotation.AnotherSolution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author onion
 * @date 2020/4/28 -9:17 上午
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */
public class _146LRU缓存机制 {
    class LRUCache {
        private class ListNode{
            private int key;
            private int value;
            private ListNode pre;
            private ListNode post;
            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private int capacity;
        private Map<Integer,ListNode> map;
        private ListNode head;
        private ListNode tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.post = tail;
            tail.pre = head;

        }
        public int get(int key) {
            if(map.containsKey(key)){
                ListNode node = map.get(key);
                move2head(key);
                return node.value;
            }
            return -1;
        }
        public void put(int key, int value) {
            if(map.containsKey(key)){
                map.get(key).value = value;
                move2head(key);
                return;
            }
            if(map.size() == capacity){
                ListNode node = removeTail();
                map.remove(node.key);
            }
            ListNode newNode = new ListNode(key, value);
            map.put(key,newNode);
            add2head(newNode);
        }
        private void add2head(ListNode node) {
            ListNode oldNode = head.post;
            oldNode.pre = node;
            node.post = oldNode;
            node.pre = head;
            head.post = node;
        }
        private ListNode removeTail() {
            ListNode oldTail = tail.pre;
            ListNode newTail = oldTail.pre;
            newTail.post = tail;
            tail.pre = newTail;
            oldTail.pre = null;
            oldTail.post = null;
            return oldTail;
        }
        private void move2head(int key) {
            ListNode node = map.get(key);
            node.pre.post = node.post;
            node.post.pre = node.pre;
            add2head(node);
        }
    }
    @AnotherSolution
    class LRUCache2 extends LinkedHashMap<Integer,Integer> {
        private int capacity;
        public LRUCache2(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }
        public int get(int key) {
            return getOrDefault(key,-1);
        }
        public void put(int key, int value) {
            super.put(key, value);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > capacity;
        }
    }

}
