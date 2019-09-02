
/**
 * @author :DengSiYuan
 * @date :2019/9/2 16:20
 * @desc : 数组队列
 */
public class ArrayQueue<T> implements Queue<T> {

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if( i % 3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }

    private DynamicArray<T> array;

    public ArrayQueue(){
        array = new DynamicArray<>();
    }

    public ArrayQueue(int capacity){
        array = new DynamicArray<>(capacity);
    }

    /**
     * 获取当前队列大小
     * @return 队列的大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断队列是否为空
     * @return true：为空 false：不为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取容量大小
     * @return 数组队列的容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 元素进队列
     */
    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    /**
     * 元素出队列
     * @return 出队列的元素值
     */
    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    /**
     * 得到队首元素
     * @return 队首元素
     */
    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size = %d , capacity %d\n",getSize(),getCapacity()));
        result.append('[');
        for (int i = 0; i < getSize(); i++) {
            result.append(array.get(i));
            if(i != getSize() - 1){
                result.append(',');
            }
        }
        result.append(']');
        return result.toString();
    }
}
