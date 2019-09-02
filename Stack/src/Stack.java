/**
 * @author :DengSiYuan
 * @date :2019/8/5 16:38
 * @desc : 栈的接口类
 */
public interface Stack<E> {


    /**
     * 获取栈的大小
     * @return 栈的大小
     */
    int getSize();


    /**
     * 判断栈是否为空
     * @return true 空 false 非空
     */
    boolean isEmpty();


    /**
     * 入栈一个元素
     * @param e 入栈的元素
     */
    void push(E e);


    /**
     * 出栈顶元素
     * @return 栈顶元素
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    E top();

    /**
     * 清空栈
     */
    void clear();

}
