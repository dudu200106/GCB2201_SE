package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionToArrayDemo {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

//        Integer[] arr = list.toArray(new Integer[list.size()]);
        //要是传入的数组长度小了, 就用不到这个数组, 而是将自己内部的数组返回给引用对象
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
    }
}
