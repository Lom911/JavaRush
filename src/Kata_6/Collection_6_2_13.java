package Kata_6;

import java.util.HashSet;
import java.util.Set;

public class Collection_6_2_13 {
    public static void main(String[] args) {
//        Collection<?> collection = new HashSet<Object>();
//        Object object = new Object();
//        collection.remove(object);
//        collection.iterator();
//        collection.toArray();
//        collection.clear();
//        collection.size();
//        collection.contains(object);

        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);

    }

//        Set<String> set = new LinkedHashSet<>();
//// add some elements to the set
//        set.add("Абырвалг");
//        set.add("Главрыба");
//        set.add("Преображенский");
//        set.add("Булгаков");
//        set.add("Собачье сердце");
//        set.add("Друг человека");
//        set.add("Управдом");
//        set.add("Советские газеты");
//        set.add("Шариков");
//        Iterator<String> iterator = set.iterator();
//        for (String s:set
//        ) {
//            iterator.next();
//            System.out.println(s);
//        }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> symmetricD = new HashSet<>(set1);
        symmetricD.addAll(set2);
        Set<T> untiSymmetric = new HashSet<>(set1);
        untiSymmetric.retainAll(set2);
        symmetricD.removeAll(untiSymmetric);
        return symmetricD;
    }
}
