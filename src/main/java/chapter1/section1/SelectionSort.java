package chapter1.section1;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 15:34 2018/6/29
 * @Modified By:
 **/
public class SelectionSort {

    // 对指定的整数型数组进行排序，默认是进行从小到大排序
    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            int minIndex = i;
            // 寻找[i,n)区间里的最小值的索引
            for (int j = i + 1; j <n ; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // 把本轮的最小元素的位置和循环的起始位置进行置换
            swap(arr, i, minIndex);
        }
    }
    // 把指定数组的两个下标的元素互换
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr= {3, 6, 8, 4, 2, 9, 10, 7, 1, 5};
        sort(arr);
        //遍历排序后的数组
        for (int i: arr) {
            System.out.print(i + "->");
        }
    }
}
