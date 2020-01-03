public class TreeNode {

    public int id;
    public String name;

    public TreeNode leftChild = null;
    public TreeNode rightChild = null;

    public boolean hasChildren() {
        return this.leftChild != null || this.rightChild != null;
    }
    public boolean hasLeftChild() {
        return this.leftChild != null;
    }
    public boolean hasRightChild() {
        return this.rightChild != null;
    }

}
