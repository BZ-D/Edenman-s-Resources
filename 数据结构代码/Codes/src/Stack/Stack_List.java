package Stack;

import java.util.ArrayList;

// 顺序数组实现堆栈
public class Stack_List<Type> {
    private ArrayList<Type> objects;
    private int top, maxsize;
    public Stack_List(){
        objects = new ArrayList<>();
        top = -1;
    }
    public Stack_List(ArrayList<Type> objects, int maxsize){
        assert objects.size() <= maxsize;
        top = objects.size() - 1;
        this.objects = objects;
        this.maxsize = maxsize;
    }

    public void push(Type data){
        objects.add(data);
        top++;
    }
    public Type pop(){
        top--;
        return objects.remove(objects.size() - 1);
    }
    public boolean isFull(){
        return this.objects.size() > this.maxsize;
    }
    public boolean isEmpty(){
        return this.objects.isEmpty();
    }


}
