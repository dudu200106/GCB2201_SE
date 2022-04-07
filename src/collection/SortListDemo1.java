package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortListDemo1 {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        Random rand =new Random();
        for (int i = 0; i < 100; i++) {
            list.add(rand.nextInt(100));
        }

        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list); //打乱集合元素
        System.out.println(list);
    }
}
