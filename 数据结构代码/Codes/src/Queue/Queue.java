package Queue;

import java.util.ArrayList;

// 顺序数组实现队列
public class Queue<Type> {
    ArrayList<Type> objects;
    int front, rear;
    int maxsize;

    public Queue() {
        front = -1;
        rear = 1;
        objects = new ArrayList<>();
        maxsize = 0;
    }

    public Queue(ArrayList<Type> objects, int maxsize) {
        this.maxsize = maxsize;
        if (objects.size() == 0) {
            front = -1;
            rear = 1;
        } else if (objects.size() == 1) {
            front = 0;
            rear = 0;
        } else {
            front = 0;
            rear = objects.size() - 1;
        }
    }

    public boolean isEmpty(){
        return objects.isEmpty();
    }

    public boolean isFull(){
        return objects.size() == maxsize;
    }

    public void inQueue(Type data){
        objects.add(data);
        rear++;
    }

    public Type outQueue(){
        if (isEmpty()) return null;
        rear--;
        return objects.remove(0);
    }

    public Type first(){
        return objects.get(0);
    }

    public Type last(){
        return objects.get(objects.size() - 1);
    }
}
