package interview.morgan;

import java.util.HashMap;
import java.util.Map;

public class HashMapQue {
    public static void main(String[] args) {
        Map<Color, String> map = new HashMap<>();
        map.put(new Color("Red"), "Red");
        map.put(new Color("Blue"), "Blue");
        map.put(new Color("Green"), "Green");
        System.out.println(map.size());
        System.out.println(map.get(new Color("Red")));
    }
}
class Color {
    private String name;
    public Color(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
