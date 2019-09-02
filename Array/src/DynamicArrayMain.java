/**
 * @author :DengSiYuan
 * @date :2019/8/4 18:40
 * @desc :
 */
public class DynamicArrayMain {

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println("扩容前：\n" + array);
        array.addLast(10);
        System.out.println("扩容后：\n" + array);
        array.addFirst(-1);
        array.add(1,100);
        System.out.println("添加三个元素后：\n" + array);
        int removeResult = array.remove(1);
        System.out.println("----------remove-----------\n从array中删除元素：{" + removeResult + "} 后的结果为：\n" + array);
        int removeFirst = array.removeFirst();
        System.out.println("--------removeFirst--------\n从array中删除首元素：{" + removeFirst + "} 后的结果为：\n" + array);
        int removeLast = array.removeLast();
        System.out.println("--------removeLast--------\n从array中删除尾元素：{" + removeLast + "} 后的结果为：\n" + array);
        array.removeElement(3);
        System.out.println("-------removeElement-------\n" +array);
    }

}
