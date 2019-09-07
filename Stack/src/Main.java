import java.util.Random;

/**
 * @author :DengSiYuan
 * @date :2019/9/7 14:40
 * @desc : 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
 */
public class Main {

    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("ArrayStack,Time:" + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack,opCount);
        System.out.println("LinkedStack,Time:" + time2 + "s");
    }

}
