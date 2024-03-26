public class ArrayDeque<T> {
    private int Length = 100;
    private int front, end, size;
    private T[] array;

    /* Constructor */
    public ArrayDeque(){
        array = (T [])new Object[Length]; 
        front = Length/2; end = Length/2 + 1;
    }

    public boolean isEmpty(){
        return (end - front) == 1;
    }

    /* Add items */
    public void addfirst(T item) {
        size++;
        array[front] = item;
        front--;
    }

    public void addLast(T item){
        size++;
        array[end] = item;
        end++;
    }

    /* Return size */
    public int size(){
        return this.size;
    }

    public void printDeque(){
        if(isEmpty()){ System.out.println("Deque is empty"); return; }

        for(int i = front+1; i < end; i++)
            System.out.println(array[i]);
    }

    /* Remove items */
    public T removeFirst(){
        if(isEmpty())
            {System.out.println("remove error"); return null;}
        T re = array[front+1];
        size--;
        front++;
        return re;
    }

    public T removeLast(){
        if(isEmpty())
            {System.out.println("remove error"); return null;}
        T re = array[end-1];
        size--;
        end--;
        return re;
    }

    public T get(int index){
        return array[front+1+index];
    }
}
