package LinkedList;

public class ListNode<Type> {
    public Type data;
    public ListNode<Type> next;

    public ListNode(){
        data = null;
        next = null;
    }
    public ListNode(Type data, ListNode<Type> node){
        this.data = data;
        this.next = node;
    }
}
