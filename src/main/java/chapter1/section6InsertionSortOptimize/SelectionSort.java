package chapter1.section6InsertionSortOptimize;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 20:56 2018/6/29
 * @Modified By:
 **/
public class SelectionSort {

    // 插入排序
    //对任何可比较的元素数组进行排序,默认是进行从小到大排序(升序)
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int minIndex = i;
            // 寻找arr[i]合适的插入位置
            Comparable temp = arr[i]; // 把起始位置元素的值暂存
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0) {
                    // 把本轮的最小元素的位置和循环的起始位置进行置换
                    arr[j] = arr[j - 1];
                }else{
                    // 一直到j前面的元素j-1小于j了，说明升序排列完成，直接退出即可
                    arr[j] = temp;
                    break;
                }
            }

        }
    }


    //把指定数组的两个指定下标的元素互换
    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        // 测试自定义的算法辅助函数
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        // 插入排序  优化前
        SortTestHelper.testSort("chapter1.section5InsertionSort.SelectionSort", arr);
        // 选择排序   优化后
        SortTestHelper.testSort("chapter1.section6InsertionSortOptimize.SelectionSort", arr);
    }
}
