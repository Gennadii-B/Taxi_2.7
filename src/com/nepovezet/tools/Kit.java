package com.nepovezet.tools;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by gendy on 11.12.16.
 */
public class Kit<K> implements Iterable<K> {

    private int volume = 0;
    transient Object[] elementData;
    transient int modCount = 0;
    private static final int DEFAULT_CAPACITY = 20;

    public Kit(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public boolean insert(K k) {
        insert(volume(), k);
        volume++;
        return true;
    }

    public int volume(){
        return volume;
    }

    public void insert(int index, K element) {
        elementData[index] = element;
    }

    public K pull(int index){
        volumeCheck(index);
        return ((K)elementData[index]);
    }

    public void rewrite(int index, K element) {
        volumeCheck(index);
        elementData[index] = element;
    }

    public boolean delete(int index) {
        volumeCheck(index);

        int numMoved = volume - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--volume] = null;


        return true;
    }

    public void cleaning() {
        for (int i = 0; i < volume; i++)
            elementData[i] = null;
        volume = 0;
    }

    @Override
    public Iterator iterator() {
        return new Iter();
    }

    @Override
    public void forEach(Consumer action) {
    }

    private void volumeCheck(int index) {
        if (index >= volume)
            throw new IndexOutOfBoundsException();
    }


    private class Iter<K> implements Iterator<K>{
        private int cursor = 0;
        private int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != volume;
        }

        @Override
        public K next() {
            int i = cursor;
            if (i >= volume)
                throw new NoSuchElementException();
            Object[] elementData = Kit.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (K) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                Kit.this.delete(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println(ex);
            }
        }

        public int nextIndex() {
            return cursor;
        }
    }

}
