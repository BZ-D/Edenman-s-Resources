package LinkedList;

// 迭代器
public class ListIterator<Type> {
    ListNode<Type> current;
    int position;

    public ListIterator(ListNode<Type> current, int position) {
        this.position = position;
        this.current = current;
    }

    public boolean isEnd() {
        return current.next.data == null;
    }

    public Type retrieve() {
        return isEnd() ? null : current.data;
    }

    public ListNode<Type> getNode() {
        return current;
    }

    public ListNode<Type> getNext() {
        return current.next;
    }

    public void advance() {
        if (!isEnd()) current = current.next;
        position++;
    }

    public int getPosition(){
        return position;
    }
}
