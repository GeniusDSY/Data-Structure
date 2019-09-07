/**
 * @author :DengSiYuan
 * @date :2019/9/7 18:21
 * @desc :
 */
public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    //计算（l...n）这个区间所有数字之和
    private static int sum(int[] arr,int l){
        if (l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr,l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(nums));
    }

}
