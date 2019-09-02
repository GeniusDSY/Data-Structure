/**
 * @author :DengSiYuan
 * @date :2019/8/4 16:57
 * @desc :
 */
public class StudentArrayMain {

    public static void main(String[] args) {

        GenericArray<Student> array = new GenericArray<>();
        array.addLast(new Student("Alice",100));
        array.addLast(new Student("Bob",66));
        array.addLast(new Student("Charlie",88));
        System.out.println(array);

    }

}
