/**
 * @author :DengSiYuan
 * @date :2019/8/4 18:08
 * @desc :
 */
public class DynamicArray<T> {

    private T[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数组容量
     */
    public DynamicArray(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }


    /**
     * 无参构造函数，数组大小为10
     */
    public DynamicArray(){
        this(10);
    }

    /**
     * @return size获取数组中的元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return data.length 数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return true/false 数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向数组中指定位置插入元素
     * @param index 索引值
     * @param e 元素值
     */
    public void add(int index, T e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add arg failed.Require index >= 0 and index <=size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data [i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 向数组尾部添加元素
     * @param e 元素值
     */
    public void addLast(T e){
        add(size,e);
    }

    /**
     * 向数组头部添加元素
     * @param e 添加的元素
     */
    public void addFirst(T e){
        add(0,e);
    }

    /**
     * 查询索引值所对应的元素值
     * @param index 查询的索引值
     * @return 索引值上的元素值
     */
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed. Index is illegal");
        }
        return data[index];
    }

    /**
     * @param index 要设置的索引值
     * @param e 要设置的元素值
     */
    public void set(int index, T e ){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set Failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 判断某元素是否存在
     * @param e 查询元素值
     * @return true/false 存在/不存在
     */
    public boolean contains(T e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }


    /**
     * 查找元素值第一次出现的位置（索引值）
     * @param e 查找的元素值
     * @return 元素值所对应的索引值,不存在返回-1
     */
    public int find(T e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找某元素在数组中的所有索引值
     * @param e 要查找的元素值
     * @return 所有匹配的索引值
     */
    public DynamicArray findAll(T e){
        DynamicArray result = new DynamicArray();
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e){
                result.addLast(i);
            }
        }
        return result;
    }

    /**
     * 删除索引所对应的元素值
     * @param index 要删除元素的索引
     */
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Removed failed. Index is illegal.");
        }
        T result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return result;
    }

    /**
     * 删除数组中第一个元素
     * @return 被删除的元素值
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return 被删除的元素值
     */
    public T removeLast(){
        return remove(size - 1);
    }

    /**
     * 判断某元素是否存在，若存在则删除
     * @param e 查询的元素值
     */
    public void removeElement(T e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public void removeAllElement(T e){
        DynamicArray indexs = findAll(e);
        for (int i = 0; i < indexs.size; i++) {
            //删除一个元素之后所有元素前移需要进行所要删除元素索引值的减少
            remove((int)indexs.get(i) - i);
        }
    }

    /**
     * 将数组转化成字符串进行输出
     * @return 格式化后的数组
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("DynamicArray: size = %d , capacity %d\n",size,data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if(i != size - 1){
                result.append(',');
            }
        }
        result.append(']');
        return result.toString();
    }

    /**
     * 动态扩充数组的容量
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
}
