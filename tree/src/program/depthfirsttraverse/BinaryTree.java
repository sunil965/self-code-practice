package program.depthfirsttraverse;

public class BinaryTree {
    char data;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(char data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HeightTree {" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
