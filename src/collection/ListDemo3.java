package collection;

import java.util.LinkedList;
import java.util.List;

public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list =new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            int e =list.get(i);
            e*=10;
            list.set(i,e);
        }

        System.out.println(list);

        List<Integer> list2=new LinkedList<>();
        list2.addAll(list);
        list2.set(0,99);
        System.out.println(list);
        System.out.println(list2);

        List<Integer> sublist = list.subList(1,3);
        sublist.set(0,666); //获得的子集操作的还是原来集合的实例对象
        System.out.println(list);
        System.out.println(sublist);

    }
}

