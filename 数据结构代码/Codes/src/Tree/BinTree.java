package Tree;

import Queue.Queue;
import Stack.Stack_List;

public class BinTree<Type> {
    private BinTreeNode<Type> root;

    public BinTree() {
        this.root = new BinTreeNode<>();
    }

    public boolean isEmpty(BinTree<Type> t) {
        return t.root == null;
    }

    public BinTreeNode<Type> getRoot() {
        return this.root;
    }

    public void createBinTree(BinTreeNode<Type> node, Type data) {
        if (root.data == null) {
            root = new BinTreeNode<>(data);
        } else {
            if (Math.random() > 0.5) { // 随机创建
                if (node.lChild == null)
                    node.lChild = new BinTreeNode<>(data);
                else
                    createBinTree(node.lChild, data);
            } else {
                if (node.rChild == null)
                    node.rChild = new BinTreeNode<>(data);
                else
                    createBinTree(node.rChild, data);
            }
        }
    }

    public void visit(BinTreeNode<Type> current) {
        System.out.print(current.getData() + " ");
    }

    // 广度优先层序遍历二叉树，利用队列
    public void levelOrder(BinTree<Type> tree) {
        Queue<BinTreeNode<Type>> queue = new Queue<BinTreeNode<Type>>();
        BinTreeNode<Type> pointer = tree.getRoot();
        if (pointer != null)
            queue.inQueue(pointer);
        // 出队顺序：根->左->右
        while (!queue.isEmpty()) {
            pointer = queue.first();
            visit(pointer);
            queue.outQueue();
            if (pointer.lChild != null)
                queue.inQueue(pointer.lChild);
            if (pointer.rChild != null)
                queue.inQueue(pointer.rChild);
        }
    }

    // 先序遍历（递归）
    public void preOrder_recurse(BinTreeNode<Type> root) {
        if (root != null) {
            visit(root);
            preOrder_recurse(root.lChild);
            preOrder_recurse(root.rChild);
        }
    }

    // 先序遍历（非递归）利用堆栈
    public void preOrder_nonRecurse(BinTree<Type> tree) {
        // 遇到一个节点，访问它，然后将其压栈，然后遍历左子树，左子树遍历结束后，从栈顶弹出这个节点
        // 左子树遍历结束后，再依次前序遍历右子树
        Stack_List<BinTreeNode<Type>> s = new Stack_List<>();
        BinTreeNode<Type> pointer = tree.getRoot();
        while (pointer != null || !s.isEmpty()) {
            while (pointer != null) {  // 一直向左并将沿途结点压栈
                visit(pointer);   // 先访问
                s.push(pointer);  // 后压栈
                pointer = pointer.lChild; // 左孩子
            }
            if (!s.isEmpty()) {
                pointer = s.pop(); // 已经访问，只需弹出
            }
            pointer = pointer.rChild;
        }
    }

    // 中序遍历（递归）
    public void inOrder_recurse(BinTreeNode<Type> root) {
        if (root != null) {
            inOrder_recurse(root.lChild);
            visit(root);
            inOrder_recurse(root.rChild);
        }
    }

    // 中序遍历（非递归）利用堆栈
    public void inOrder_nonRecurse(BinTree<Type> tree) {
        // 遇到一个节点，先将其压栈，然后遍历左子树，左子树遍历结束后，从栈顶弹出这个节点并访问它
        // 左子树遍历结束后，再依次中序遍历右子树
        Stack_List<BinTreeNode<Type>> s = new Stack_List<>();
        BinTreeNode<Type> pointer = tree.getRoot();
        while (pointer != null || !s.isEmpty()) {
            while (pointer != null) {  // 一直向左并将沿途结点压栈
                s.push(pointer);  // 根
                pointer = pointer.lChild; // 左孩子
            }
            if (!s.isEmpty()) {
                pointer = s.pop(); // 开始访问
                visit(pointer);
            }
            pointer = pointer.rChild;
        }
    }

    // 后序遍历（递归）
    public void postOrder_recurse(BinTreeNode<Type> root) {
        if (root != null) {
            postOrder_recurse(root.lChild);
            postOrder_recurse(root.rChild);
            visit(root);
        }
    }

    // 后序遍历（非递归）利用堆栈
    public void postOrder_nonRecurse(BinTree<Type> tree) {
        // 遇到一个节点，先将其压栈，然后遍历左子树，左子树遍历结束后，先判断该节点的tag，如果为0,
        // 将其标位1，然后继续遍历右子树，遍历结束后，再判断该节点的tag，如果为1，说明第二次访问，就弹出并访问它
        Stack_List<BinTreeNode<Type>> s = new Stack_List<>();
        BinTreeNode<Type> pointer = tree.getRoot();
        while (pointer != null || !s.isEmpty()) {
            while (pointer != null) {  // 一直向左并将沿途结点压栈
                s.push(pointer);  // 根
                pointer = pointer.lChild; // 左孩子
            }
            if (!s.isEmpty()) {
                pointer = s.pop(); // 开始访问
                if (pointer.tag == 0) {
                    pointer.tag = 1;
                    s.push(pointer);
                    pointer = pointer.rChild;
                } else {
                    visit(pointer);
                    pointer = null;
                }
            }

        }
    }
}

