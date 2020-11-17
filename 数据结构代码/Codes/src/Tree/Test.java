package Tree;

public class Test {
    public static void main(String[] a) {
        BinTree<Integer> tree = new BinTree<>();
        for (int i = 0; i <= 10; i++) {
             tree.createBinTree(tree.getRoot(), i);
        }
        System.out.println("下面是层序遍历");
        tree.levelOrder(tree);System.out.println();
        System.out.println("下面是递归先序遍历");
        tree.preOrder_recurse(tree.getRoot());System.out.println();
        System.out.println("下面是非递归先序遍历");
        tree.preOrder_nonRecurse(tree);System.out.println();
        System.out.println("下面是递归中序遍历");
        tree.inOrder_recurse(tree.getRoot());System.out.println();
        System.out.println("下面是非递归中序遍历");
        tree.inOrder_nonRecurse(tree);System.out.println();
        System.out.println("下面是递归后序遍历");
        tree.postOrder_recurse(tree.getRoot());System.out.println();
        System.out.println("下面是非递归后序遍历");
        tree.postOrder_nonRecurse(tree);
    }
}
