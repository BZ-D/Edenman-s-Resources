package LinkedList;

// 循环链表
public class CirLinkedList<Type> {
    ListNode<Type> first;

    public CirLinkedList() {
        first = new ListNode<Type>();
        first.next = first;
    }

    CirLinkedList(ListNode<Type> first) {
        this.first = first;
        this.first.next = first;
    }

    public void create(Type[] objects) {
        ListNode<Type> pointer = first;
        for (int i = 0; i < objects.length; i++) {
            if (pointer.data == null) {
                pointer.data = objects[i];
                continue;
            }
            if (i != objects.length - 1) {
                pointer.next = new ListNode<Type>(objects[i], first);
                pointer = pointer.next;
            } else {
                pointer.next = new ListNode<Type>(objects[i], first);
            }

        }
    }

    public ListIterator<Type> getFirst() {
        return new ListIterator<Type>(first, 0);
    }

    public int length() {
        int length = 0;
        ListIterator<Type> itr = new ListIterator<Type>(first, 0);
        while (itr.getNext() != first) {
            itr.advance();
            length++;
        }
        return length + 1;
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
        ListIterator<Type> previous = getKth((i + length() - 1) % length());
        previous.current.next = new ListNode<Type>(data, previous.current.next);
        if (i == 0) first = previous.current.next;
    }

    // 删除第i个位置的元素
    public ListNode<Type> delete(int i) {
        ListIterator<Type> toDelete = getKth(i);
        ListIterator<Type> pre = getKth((i + length() - 1) % length());
        pre.current.next = toDelete.current.next;
        if (i == 0) first = pre.current.next;
        return toDelete.current;
    }

    public void printList() {
        ListNode<Type> pointer = getFirst().current;
        int count = length();
        while (count > 0) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
            count--;
        }
    }

    public static void main(String[] args) {
        CirLinkedList<Integer> test = new CirLinkedList<Integer>();
        test.create(new Integer[]{1, 2, 3, 4});
        test.printList();
        test.insert(0, 5);
        test.printList();
    }
}
