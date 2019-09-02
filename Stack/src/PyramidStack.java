/**
 * @author :DengSiYuan
 * @date :2019/8/12 11:38
 * @desc : 使用栈创建金字塔（未全部完成，仅玩耍）
 */
public class PyramidStack {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        for (int i = 9 ; i >= 0 ; i--){
            for (int j = 0 ; j <= i ; j ++){
                stack.push(" ");
            }
            for (int m = 0 ;  m < 10 - i ; m++){
                stack.push(m);
            }
            System.out.println(stack.toString2().append(stack.toString2().reverse()));
            stack.clear();
        }
    }

}
