package breadthfirsttraverse;

public class BFDBinaryTree {
    char data;
    BFDBinaryTree left = null;
    BFDBinaryTree right = null;

    public BFDBinaryTree(char data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HeightTree {" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
