package breadthfirsttraverse;

public class CharTree {
    char data;
    CharTree left = null;
    CharTree right = null;

    public CharTree(char data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HeightTree {" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
