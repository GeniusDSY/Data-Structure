/**
 * @author :DengSiYuan
 * @date :2019/9/7 15:48
 * @desc :
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
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
        return size == 0;
    }

    /**
     * 元素进队列
     * @param e 传入队列的元素
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 元素出队列
     *
     * @return 出队列的元素值
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("不能从一个空队列中出队列！！");
        }else {
            Node reNode = head;
            head = head.next;
            reNode.next = null;
            if (head == null) {
                tail = null;
            }
            size--;
            return reNode.e;
        }
    }

    /**
     * 得到队首元素
     * @return 队首元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空！！");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue：front  ");
        Node current = head;
        while (current != null){
            sb.append(current + "->");
            current = current.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if( i % 3 == 2){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }

}
