package collection;

import java.util.*;

public class CollectionDemo4 {
    public static void main(String[] args) {

        Set c1= new HashSet();
        Set c2 =new HashSet();

        c1.add(111);
        c1.add(222);
        c1.add(333);

        c2.addAll(c1); //并入
        c2.add(444);

//        c2.remove(111);

        //只保留交集, 仅保留与给定集合共同的部分
//        c2.retainAll(c1);
//        System.out.println(c2);
        //与retainAll正好相反,只删除交集部分
        c2.removeAll(c1);
        System.out.println(c2);

//        int[] a =new int[10];
//        Arrays.fill(a,1);
//        System.out.println(Arrays.toString(a));
//        int[] b =a.clone();
//        Arrays.fill(a,5);
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.toString(a));
//
//
//        System.out.println(c2.containsAll(c1));

    }
}
