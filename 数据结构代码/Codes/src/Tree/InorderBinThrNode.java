package Tree;

public class InorderBinThrNode {
    static class PointerTag {
        public static int link = 0; // 用于指示指针指向后继
        public static int thread = 1; // 用于指示线索
    }
    char data;
    int lTag, rTag;
    InorderBinThrNode lChild, rChild;
    InorderBinThrNode(char data, int lTag, int rTag, InorderBinThrNode lChild, InorderBinThrNode rChild){
        this.data = data;
        this.lTag = lTag;
        this.rTag = rTag;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    // 线索化方法
    void in_thread(InorderBinThrNode p){
        if(p!=null){
            in_thread(p.lChild); // 左子树线索化
            p.lTag = p.lChild == null ? PointerTag.thread : PointerTag.link;
            p.rTag = p.rChild == null ? PointerTag.thread : PointerTag.link;
        }
    }
}
