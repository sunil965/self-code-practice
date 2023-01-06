public class Tree {
    int data;
    Tree left = null;
    Tree right = null;

    public Tree(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HeightTree {" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
