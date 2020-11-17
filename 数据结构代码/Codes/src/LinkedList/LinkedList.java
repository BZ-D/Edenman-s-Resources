package LinkedList;


public class LinkedList<Type> {
    ListNode<Type> head; // 头结点，认为位置为-1

    public LinkedList() {
        head = new ListNode<Type>(null, new ListNode<Type>());
    }

    public LinkedList(ListNode<Type> head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void makeEmpty() {
        this.head.next = null;
    }

    public ListIterator<Type> getZeroth() {
        return new ListIterator<Type>(head, -1);
    }

    public ListIterator<Type> getFirst() {
        return new ListIterator<Type>(head.next, 0);
    }

    public ListIterator<Type> getLast() {
        ListIterator<Type> itr = new ListIterator<Type>(head, length() - 1);
        while (!itr.isEnd())
            itr.advance();
        return itr;
    }

    public ListNode<Type> getHead() {
        return head;
    }

    /**
     *
     * @param objects : 要存储的一系列数据
     */
    public void create(Type[] objects) {
        ListNode<Type> pointer = head;
        for (int i = 0; i < objects.length; i++) {
            if (i != objects.length - 1) {
                pointer.next = new ListNode<>(objects[i], new ListNode<>());
                pointer = pointer.next;
            } else{
                pointer.next = new ListNode<>(objects[i], null);
            }

        }
    }

    public int length() {
        int length = 0;
        ListIterator<Type> itr = new ListIterator<Type>(head, 0);
        while (!itr.isEnd()) {
            itr.advance();
            length++;
        }
        return length;
    }

    public ListIterator<Type> getKth(int k) {
        int count = 0;
        ListIterator<Type> p = getFirst();
        while (!p.isEnd() && count < k) {
            p.advance();
            count++;
        }
        if (count == k)
            return new ListIterator<Type>(p.current, k);
        return null;
    }

    // 在第i个位置插入新元素，即在第i-1个位置后插入，需要改变指针的指向
    public void insert(int i, Type data) {
        if (i == 0) { // 插在表头
            ListIterator<Type> first = getFirst();
            head.next = new ListNode<Type>(data, first.current);
        }
        ListIterator<Type> previous = getKth(i - 1);
        previous.current.next = new ListNode<Type>(data, previous.current.next);
    }

    // 删除第i个位置的元素
    public ListNode<Type> delete(int i) {
        if (i == 0) {
            ListIterator<Type> toDelete = getFirst();
            head.next = toDelete.current.next;
            return toDelete.current;
        } else {
            ListIterator<Type> toDelete = getKth(i);
            ListIterator<Type> pre = getKth(i - 1);
            pre.current.next = toDelete.current.next;
            return toDelete.current;
        }
    }

    public void printList() {
        ListNode<Type> pointer = head.next;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
    }


}
