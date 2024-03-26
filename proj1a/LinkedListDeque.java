public class LinkedListDeque<T> {
    /* Not use outer method or variables */
    private class TNode{
        T data;
        TNode pre, next;
        public TNode(T item, TNode p, TNode n){
            data = item; pre = p; next = n;
        }
    }

    private TNode guard, front, back;
    private int size;       /* Automatic declare size = 0 */
    public LinkedListDeque(){
        guard = new TNode(null, null, null);
        front = back = guard;
    }

    /* Add node fuction */
    public void addFirst(T item){
        size += 1;
        TNode node = new TNode(item, null, front);
        front.pre = node;
        front = node;
    }

    public void addLast(T item){
        size += 1;
        TNode node = new TNode(item, back, null);
        back.next = node;
        back = node;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    public void printDeque(){
        TNode p = front;
        while(p != null){
            if(p.data != null)
                System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public T removeLast(){
        size--;
        TNode re = back;
        back = back.pre;
        back.next = null;
        return re.data;
    }

    public T removeFirst(){
        size--;
        TNode re = front;
        front = front.next;
        front.pre = null;
        return re.data;
    }

    public T get(int index){
        TNode p = front;
        for(int i = 0; i < index; i++){
            if(p == guard)      /* Except guard node */
                i++;
            p = p.next;
        }
        return p.data;
    }
}
