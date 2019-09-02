/**
 * @author :DengSiYuan
 * @date :2019/9/2 17:06
 * @desc : 循环队列
 */
public class LoopQueue<T> implements Queue<T> {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if( i % 3 == 2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
    private T[] data;
    private int front, tail;
    private int size;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * 队列大小
     * @return 队列的容量大小
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     * @return true：为空 false：不为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 元素进队列
     * @param t 传入队列的元素
     */
    @Override
    public void enqueue(T t) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = t;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 元素出队列
     * @return 出队列的元素值
     */
    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("空队列无法出列！");
        }
        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 得到队首元素
     * @return 队首元素
     */
    @Override
    public T getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空！");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size = %d , capacity %d\n",size,getCapacity()));
        result.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if((i + 1) % data.length != tail){
                result.append(',');
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
