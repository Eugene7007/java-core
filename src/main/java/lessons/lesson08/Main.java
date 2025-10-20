package lessons.lesson08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        var list = List.of(1, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> listStr = list.stream().map(String::valueOf).toList();
        System.out.println(listStr);
        Set<String> set = new HashSet<>(){};
        Map<String, String> map = new HashMap<>(){};
    }
}
