package interview.morgan;

import java.util.Arrays;

public class Parametric {
    int i = 85;
    Parametric() {
        i = 41;
    }
    {
        i = 27;
    }
    public static void main(String[] args) {
        // Que1
        Parametric param = new Parametric();
        System.out.println(param.i);

        // Que2
        int sum = Arrays.stream(new int[]{1, 2, 3, 4, 5}).filter(value -> value % 2 == 0).map(operand -> operand * 2).sum();
        System.out.println(sum);
    }
}
