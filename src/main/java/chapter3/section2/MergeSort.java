package chapter3.section2;

import java.util.Arrays;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:16 2018/7/2
 * @Modified By:
 **/
public class MergeSort {

    // 对当前轮的元素进行归并:将arr[left...middle]和arr[mid+1...right]两部分进行归并。注意都是闭区间
    private static void merge(Comparable[] arr, int l, int mid, int r){
        // 声明辅助数组,注意copyOfRange是左闭右开区间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 开始合并
        int i = l; // 左侧游标
        int j = mid+1; // 右侧游标

        // k为要在arr中放入的位置
        for (int k = l; k <= r ; k++) {
            // 越界问题  一边被全部拿走   一边没动
            if (i > mid){
                // 说明左边排完了 只能用右边
                arr[k] = aux[j - l];
                j++;
            }else if (j > mid){
                // 说明右边排完了 只能用左边
                arr[k] = aux[i - l];
                i++;
            }else if (aux[i - l].compareTo(j - l) > 0){
                aux[k] = aux[i - l];
                i++;
            }else{
                aux[k] = aux[j - l];
                j++;
            }
            
        }

    }

    // 递归使用归并排序  对arr[l....r] 的范围进行排序  左右都是闭区间
    private static void sort(Comparable[] arr, int l, int r){
        // 如果左侧元素下标大于等于右侧元素下标，说明归并完成，直接退出即可
        if (l >= r){
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            // merge操作
            merge(arr, l, mid, r);
        }

    }

    // 归并算法  对arr[l...r]两部分进行归并
    public static void mergeSort(Comparable[] arr){
        int n = arr.length;
        // 左逼右闭区间
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // 测试自定义的算法辅助函数
        int N = 500;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        // 测试数组是否有序
        SortTestHelper.testSort("chapter3.section2.MergeSort", arr);
        chapter3.section1.SortTestHelper.testSort("chapter3.section1.MergeSort", arr);
    }

}
