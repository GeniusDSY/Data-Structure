/**
 * @author :DengSiYuan
 * @date :2019/9/2 16:17
 * @desc : 队列接口类
 */
public interface Queue<T> {

    /**
     * 队列大小
     * @return 队列的容量大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return true：为空 false：不为空
     */
    boolean isEmpty();

    /**
     * 元素进队列
     * @param t 传入队列的元素
     */
    void enqueue(T t);

    /**
     * 元素出队列
     * @return 出队列的元素值
     */
    T dequeue();

    /**
     * 得到队首元素
     * @return 队首元素
     */
    T getFront();

}
