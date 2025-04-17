package com.scalar.lldRealExamples;


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    //THIS IS NODE PRESENT IN EACH CACHE
    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head=null;
        tail=null;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }
        if(capacity == map.size()) {
            //Node toRemove = tail;           // Save the actual tail first
            System.out.println("Removed " + tail.key);
            removeNode(tail);           // Remove it from DLL
            map.remove(tail.key);       // Remove it from map

        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
       addToFront(newNode);
    }


void addToFront(Node node)
{
    if(head == null) {
        System.out.println("Adding first element " + node.key);
    }
    node.next = head;
    node.prev = null;

    if(head != null) { head.prev = node; }
    head = node;
    if(tail == null) { tail = node; }
}

void moveToFront(Node node)
{
    System.out.println("moveToFront called with key " + node.value+" will be moved to front ");
    removeNode(node);
    addToFront(node);
}

void removeNode(Node node)
    {
        System.out.println("removing node " + node.value + " from cache");
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

    }

    void print(){
        Node node = head;
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
public class LRUCacheMain {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(5);

        cache.put(1, 1);
        //cache.print();
        cache.put(2, 2);
        //cache.print();
        cache.put(3, 3);
        //cache.print();
        cache.put(4, 4);
        //cache.print();
        cache.put(5, 5);
        cache.print();
        cache.put(6,6);
        cache.print();

    }
}
