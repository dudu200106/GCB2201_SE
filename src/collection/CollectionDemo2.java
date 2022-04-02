package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Point(1, 1));
        c.add(new Point(3, 2));
        c.add(new Point(1, 3));
        c.add(new Point(2, 2));

        //打印集合的对象引用, 默认输出所有元素[collection1,collection2...collection...]
        // 其中, 若是引用类型, 则需看他是否实现了toString方法, 不然只打印哈希地址
        System.out.println(c);

        Point p=new Point(6,6);
        System.out.println();

        // Collection中d都有contain方法,remove方法
        System.out.println(c.contains(p));
    }

}
