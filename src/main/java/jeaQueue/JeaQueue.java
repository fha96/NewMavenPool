package jeaQueue;

import java.util.LinkedList;

public class JeaQueue<T> {
    private LinkedList<T> item;
    private int maxSize;
    public JeaQueue(int maxSize){
        this.item=new LinkedList<T>();
        this.maxSize=maxSize;
    }

    public void enQueue(T item){
        if (isFull()){
            throw new RuntimeException("You cannot enQueue items, Queue is full");
        }
        this.item.addFirst(item);
    }
    public T deQueue(){
        if (isEmpty()){
            throw  new RuntimeException("Queue is Empty, you cannot dequeue any elements");
        }

        T item =this.item.getLast();
        this.item.removeLast();
        return item;
    }
    public boolean isFull(){
        return this.item.size()>=maxSize;
    }
    public boolean isEmpty(){
        return this.item.size()==0;
}

    @Override
    public String toString() {
        return this.item.toString();
    }
}
