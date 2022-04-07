package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 集合元素没有实现接口Comparable。只有实现了该接口的类
 *      才可以进行比较(实现接口后就必须重写方法compareTo()用于定义两个元素间的比较大小规则)。
 * 该操作对我们的代码具有侵入性，不建议这样做。
 * 侵入性:当我们调用一个功能时，其要求我们为其修改其他额外的代码，这就是侵入性
 *      它不利于程序后期的维护与扩展，应当尽量避免。
* */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list =new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(8,8));
        list.add(new Point(5,4));
        list.add(new Point(3,6));
        Collections.sort(list, (o1,o2)-> //lambda
                o1.getX()*o1.getX() + o1.getY()*o1.getY() -
                (o2.getX()*o1.getX() + o2.getY()*o1.getY())
            );

        //匿名内部类写法
//        Comparator<Point> c = new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {//compare:比较
//                int len1 = o1.getX()*o1.getX()+o1.getY()* o1.getY();
//                int len2 = o2.getX()*o2.getX()+o2.getY()* o2.getY();
//                return len1-len2;
//            }
//        };
//        Collections.sort(list,c);

        //没有侵入性的写法
//        Collections.sort(list,new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {//compare:比较
//                int len1 = o1.getX()*o1.getX()+o1.getY()* o1.getY();
//                int len2 = o2.getX()*o2.getX()+o2.getY()* o2.getY();
//                return len1-len2;
//            }
//        });


        System.out.println(list);
    }
}
