package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteractorDemo {

    public static void main(String[] args) {
        Set c1 =new HashSet();

        c1.add(111);
        c1.add(222);
        c1.add(333);

        //Iterator是个迭代器接口
        Iterator it = c1.iterator();
        while (it.hasNext()){
            Integer integer =(Integer)it.next();
            System.out.println(integer);
        }

    }


}
