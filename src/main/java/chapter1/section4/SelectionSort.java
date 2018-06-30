package chapter1.section4;

import chapter1.section4.SortTestHelper;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 20:56 2018/6/29
 * @Modified By:
 **/
public class SelectionSort {

    //对任何可比较的元素数组进行排序,默认是进行从小到大排序(升序)
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找[i, n)区间里的最小值的索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 把本轮的最小元素的位置和循环的起始位置进行置换
            swap(arr, i, minIndex);
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
        sort(arr);
        SortTestHelper.testSort("chapter1.section4.SelectionSort", arr);
    }
}
