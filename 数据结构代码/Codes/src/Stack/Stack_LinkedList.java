package Stack;

import LinkedList.*;

// 链表实现堆栈，用head代表top
public class Stack_LinkedList<Type> extends LinkedList<Type> {
    int maxsize;
    Stack_LinkedList(int maxsize){
        this.maxsize = maxsize;
    }
    public Stack_LinkedList<Type> createStack(int maxsize){
        Stack_LinkedList<Type> stack = new Stack_LinkedList<>(maxsize);
        stack.makeEmpty();
        return stack;
    }

    public void push(Type data){
        insert(1, data);
    }

    public ListNode<Type> pop(){
        return delete(1);
    }

    public boolean isFull(){
        return length() == maxsize;
    }
}
