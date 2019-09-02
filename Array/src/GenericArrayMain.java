/**
 * @author :DengSiYuan
 * @date :2019/8/4 12:15
 * @desc :
 */
public class GenericArrayMain {

    public static void main(String[] args) {

        GenericArray<Integer> array =new GenericArray<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println("----------addLast----------\n" + array);
        array.add(1,100);
        System.out.println("------------add------------\n" + array);
        array.addFirst(-1);
        System.out.println("----------addFirst---------\n" + array);
        array.set(2,6);
        System.out.println("------------set------------\n" + array);
        System.out.println("------------get------------\n" + array.get(3));
        int removeResult = array.remove(1);
        System.out.println("----------remove-----------\n从array中删除元素：{" + removeResult + "} 后的结果为：\n" + array.toString());
        int removeFirst = array.removeFirst();
        System.out.println("--------removeFirst--------\n从array中删除首元素：{" + removeFirst + "} 后的结果为：\n" + array.toString());
        int removeLast = array.removeLast();
        System.out.println("--------removeLast--------\n从array中删除尾元素：{" + removeLast + "} 后的结果为：\n" + array.toString());
        int find = array.find(5);
        System.out.println("-----------find------------\n" + find);
        array.addLast(6);
        GenericArray findAll = array.findAll(6);
        System.out.println("----------findAll----------\n" + findAll);
        boolean contains = array.contains(6);
        System.out.println("----------contains---------\n" + contains);
        array.removeElement(3);
        System.out.println("-------removeElement-------\n" +array);
        array.removeAllElement(6);
        System.out.println("------removeAllElement-----\n" +array);

    }

}
