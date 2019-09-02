import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/8/5 17:01
 * @desc : 数组栈
 */
public class ArrayStack<E> implements Stack<E> {

    DynamicArray<E> array;

    /**
     * 含参（容量）的构造函数
     * @param capacity 容量
     */
    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayStack() {
        array = new DynamicArray<>();
    }

    /**
     * 获取栈的大小
     * @return 栈的大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     * @return true 空 false 非空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入栈一个元素
     *
     * @param e 入栈的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈顶元素
     *
     * @return 栈顶元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    @Override
    public E top() {
        return array.get(-1);
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {
        array = new DynamicArray<>();
    }

    /**
     * @return 数组容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ArrayStack{");
        for (int i = array.getSize() - 1; i >= 0; i--) {
            result.append(array.get(i));
            if (i != 0){
                result.append(",");
            }
        }
        result.append("}");
        return  result.toString();
    }

    public StringBuilder toString2() {
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize()){
                result.append(" ");
            }
        }
        return  result;
    }
}
