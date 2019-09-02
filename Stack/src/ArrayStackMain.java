/**
 * @author :DengSiYuan
 * @date :2019/8/8 17:22
 * @desc :
 */
public class ArrayStackMain {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

}
