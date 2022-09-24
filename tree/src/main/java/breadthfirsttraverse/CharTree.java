package breadthfirsttraverse;

public class CharTree {
    public char data;
    public CharTree left = null;
    public CharTree right = null;

    public CharTree(char data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HeightTree {" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
