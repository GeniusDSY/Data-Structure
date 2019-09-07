/**
 * @author :DengSiYuan
 * @date :2019/9/7 9:53
 * @desc :
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);
        System.out.println("删除："+linkedList.remove(2));
        System.out.println(linkedList);
        System.out.println("删除："+linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println("删除："+linkedList.removeLast());
        System.out.println(linkedList);
    }

}
