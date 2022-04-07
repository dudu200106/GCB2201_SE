package collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list =new LinkedList<>();

        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        String old =list.set(1,"666");
        System.out.println(old);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list );
    }
}
