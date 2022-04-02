package collection;

/**
 * 集合
 * java.util.Collection接口
 * 集合与数组一样，可以保存一组元素，并且对于元素的操作全部提供了对应的方法，使用便捷。
 * Collection是所有集合的顶级接口，里面规定了所有集合都应当具备的相关操作。
 * 其他有两个常见的子接口:
 * java.util.List:可重复集且有序。
 * java.util.Set:不可重复集
 * 重复指的是元素是否允许存放重复元素，重复的判定是根据元素自身的equals方法决定的。
 *
 *
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Filter;

public class CollectionDemo1 {
    public static void main(String[] args) {
        ArrayList a =new ArrayList();
        /*
        * 集合框架若是不指定泛型类型, 则可以添加任何引用类型的值;
        * boolean add(E e) -->返回是否添加成功-->Set不允许有重复, 重复就添加失败返回值为false
        * */
        a.add(new Object());
        a.add(123);  //自动封装成Integer引用类型了
        a.add("abcd");
        a.add(new HashMap<>());

        System.out.println(a.isEmpty());
        System.out.println(a.size());
        a.clear();
        System.out.println(a.size());
        System.out.println(a.isEmpty());
    }
}
