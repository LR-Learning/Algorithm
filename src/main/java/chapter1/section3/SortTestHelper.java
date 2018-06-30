package chapter1.section3;


/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 20:56 2018/6/29
 * @Modified By:
 **/
public class SortTestHelper {
    private SortTestHelper() {
    }

    // 生成n个元素的随机数组, 每个元素的随机范围是[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        Integer[] arr = new Integer[n]; // 初始化一个长度为n的数组
        assert (rangeL < rangeR); // 断言 如果为true则程序进行, 如果为false则程序抛出java.lang.AssertionError，输出[错误信息]
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random()*(rangeR - rangeL + 1) + rangeL); // 生成从[rangeL, rangeR]的随机数
        }
        return arr;
    }

    // 打印arr数组的全部内容
    public static void printArray(Object[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
