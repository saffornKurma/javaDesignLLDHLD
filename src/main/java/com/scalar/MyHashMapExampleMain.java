package com.scalar;

//I WILL IMPLEMENT THESE
//PUT(KEY,VALUE)->returns void
//GET(KEY)->returns the VALUE
//REMOVE(KEY)->void removes the key


import java.security.Key;
import java.util.HashMap;

class MyHashMap<K,V>
{
    static class Node<K,V>{
        K key;
        V value;
        Node next;

        Node(K key,V value)
        {
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    private static final int INT_SIZE_DEFAULT=16;
    private  Node<K,V>[] bucket;

    public MyHashMap()
    {
        bucket=new Node[INT_SIZE_DEFAULT];
    }

    private int getHasIndex(K key)
    {
        return Math.abs(key.hashCode())%INT_SIZE_DEFAULT;
    }

    public void put(K key,V value)
    {
        int index=getHasIndex(key);
        Node head=bucket[index];
        Node<K,V> newNode=new Node<>(key,value);

        Node<K,V> current=head;
        while(current!=null)
        {
            if(current.key.equals(key))
            {
                current.value=value;
                return;
            }
            current=current.next;
        }
        newNode.next=head;
        bucket[index]=newNode;
    }

    public V get(K key)
    {
        int index=getHasIndex(key);

        if(bucket[index]==null)
            return null;

        Node<K,V> current=bucket[index];
        while(current!=null)
        {
            if(current.key.equals(key))
            {
                return current.value;
            }
            current=current.next;
        }
        return null;
    }

}
public class MyHashMapExampleMain {

    public static void main(String[] args)
    {
        MyHashMap<Integer,String> hashMap=new MyHashMap<>();
        hashMap.put(1,"Hello");
        hashMap.put(2,"world");
        hashMap.put(3,"how");
        hashMap.put(4,"are");
        hashMap.put(5,"you");
        hashMap.put(6,"can");
        hashMap.put(7,"you");
        hashMap.put(8,"give");
        hashMap.put(9,"number");

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(6));
        System.out.println(hashMap.get(7));
        System.out.println(hashMap.get(8));
        hashMap.put(8,"radhe");
        System.out.println(hashMap.get(8));
        System.out.println(hashMap.get(9));


    }
}



