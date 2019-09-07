/**
 * @author :DengSiYuan
 * @date :2019/9/6 10:59
 * @desc : 链表结构
 */
public class LinkedList<T> {

    private class Node{
        public T t;
        public Node next;

        public Node(T t,Node next){
            this.t = t;
            this.next = next;
        }

        public Node(T t){
            this(t,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新元素e
    public void addFirst(T t){
        dummyHead.next = new Node(t,dummyHead.next);
        size++;
    }

    //在链表index（0-based）位置添加新的元素e
    public void add(int index,T t){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("添加失败，无效的索引！");
        }
        /*if (index == 0){
            addFirst(t);
        }else {*/
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            /*Node newNode = new Node(t);
            newNode.next = prev.next;
            prev.next = newNode;*/
            prev.next = new Node(t,prev.next);
            size++;
        //}
    }

    //在链表的末尾添加一个元素
    public void addLast(T t){
        add(size,t);
    }

    //获得链表index处的元素
    public T get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("添加失败，无效的索引！");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.t;
    }

    //获取第一个元素
    public T getFirst(){
        return get(0);
    }

    //获取最后一个元素
    public T getLast(){
        return get(size - 1);
    }

    //修改第index位置的元素
    public void set(int index,T t){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("修改失败，无效的索引！");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.t = t;
    }

    //查找链表中是否存在某元素
    public boolean contains(T t){
        Node current = dummyHead.next;
        while (current != null){
            if(current.t == t){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //删除索引位置的元素
    public T remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("删除失败，无效的索引！");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.t;
    }

    //删除链表中第一个元素，并返回
    public T removeFirst(){
        return remove(0);
    }
    //删除连变种最后一个元素，返回删除的元素
    public T removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null){
            sb.append(current + "->");
            current = current.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
