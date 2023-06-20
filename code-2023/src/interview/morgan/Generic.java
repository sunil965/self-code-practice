package interview.morgan;

public class Generic<T> {
    T value;

    public Generic(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Generic<String> one = new Generic<>("Sunil");
        Generic<Integer> two = new Generic<>(123);

        System.out.print(one.getValue());
        System.out.print(two.getValue());
    }
}
