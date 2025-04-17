package com.scalar;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyItio implements Iterable<Integer> {//iterable
    List<Integer> list=new ArrayList<>();


    @Override
    public Iterator<Integer> iterator() {
        return list.iterator();
    }
}
public class IterableExample {
    public static void main(String[] args) {

        MyItio myItio = new MyItio();

        myItio.list.add(1);
        myItio.list.add(2);
        myItio.list.add(3);
        myItio.list.add(4);
        myItio.list.add(5);
        myItio.list.add(6);
        myItio.list.add(7);
        myItio.list.add(8);
        myItio.list.add(9);
        myItio.list.add(10);

        Iterator<Integer> iterator = myItio.iterator();//iterator

        for (Integer integer : myItio) {
            System.out.println(integer);
        }
        while (iterator.hasNext()) {//iterator
            System.out.println(iterator.next());
        }

    }
}
