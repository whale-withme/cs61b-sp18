// package com.cs61b_sp18.proj1a;

public class ArrayDeque<T> implements Deque<T>{
    private int Length = 100;
    private int front, end, size;
    private T[] array;

    /* Constructor */
    public ArrayDeque(){
        array = (T [])new Object[Length]; 
        front = Length/2; end = Length/2 + 1;
    }

    @Override
    public int front(){ return front; }

    @Override
    public int end(){ return end;  }

    @Override
    public boolean Equal(int i, int j){ return array[i] == array[j]; }

    @Override
    public boolean isEmpty(){
        return (end - front) == 1;
    }

    /* Add items */
    @Override
    public void addFirst(T item) {
        size++;
        array[front] = item;
        front--;
    }

    @Override
    public void addLast(T item){
        size++;
        array[end] = item;
        end++;
    }

    /* Return size */
    @Override
    public int size(){
        return this.size;
    }

    @Override
    public void printDeque(){
        if(isEmpty()){ System.out.println("Deque is empty"); return; }

        for(int i = front+1; i < end; i++)
            System.out.println(array[i]);
    }

    /* Remove items */
    @Override
    public T removeFirst(){
        if(isEmpty())
            {System.out.println("remove error"); return null;}
        T re = array[front+1];
        size--;
        front++;
        return re;
    }

    @Override
    public T removeLast(){
        if(isEmpty())
            {System.out.println("remove error"); return null;}
        T re = array[end-1];
        size--;
        end--;
        return re;
    }

    @Override
    public T get(int index){
        return array[front+1+index];
    }

    @Override
    public T getIndex(int i){  return array[i]; }
}
