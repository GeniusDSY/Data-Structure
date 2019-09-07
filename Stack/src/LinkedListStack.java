/**
 * @author :DengSiYuan
 * @date :2019/9/7 14:26
 * @desc :
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<E>();
    }

    /**
     * 获取栈的大小
     * @return 栈的大小
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断栈是否为空
     * @return true 空 false 非空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈一个元素
     * @param e 入栈的元素
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * 出栈顶元素
     * @return 栈顶元素
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    @Override
    public E top() {
        return list.getFirst();
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack：")
                .append(list);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

}
