package Tree;

public class BinTreeNode<Type> {
    Type data;
    int tag = 0; // 标记，为0表示首次访问该节点，为1表示该节点已经被访问过
    BinTreeNode<Type> lChild, rChild;
    BinTreeNode(){
        this.data = null;
        this.rChild = null;
        this.lChild = null;
    }
    BinTreeNode(Type data){
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }
    BinTreeNode(BinTreeNode<Type> lChild, BinTreeNode<Type> rChild, Type data){
        super();
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public Type getData(){
        return this.data;
    }
    public void setData(Type data){
        this.data = data;
    }
    public BinTreeNode<Type> getLChild(){
        return this.lChild;
    }
    public void setLChild(BinTreeNode<Type> lChild){
        this.lChild = lChild;
    }
    public BinTreeNode<Type> getRChild(){
        return this.rChild;
    }
    public void setRChild(BinTreeNode<Type> rChild){
        this.rChild = rChild;
    }
    public boolean isLeaf(BinTreeNode<Type> b){
        return b.lChild == null && b.rChild == null;
    }
    public boolean isLeaf(){
        return this.lChild == null && this.rChild == null;
    }

}
