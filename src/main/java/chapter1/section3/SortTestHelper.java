package chapter1.section3;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 20:56 2018/6/29
 * @Modified By:
 **/
public class SortTestHelper {

    // 生成n个元素的随机数组, 每个元素的随机范围是[rangeL, rangeR]
    public int[] generateRandomArray(int n, int rangeL, int rangeR){
        int[] arr = new int[n]; // 初始化一个长度为n的数组
        assert (rangeL < rangeR); // 断言 如果为true则程序进行, 如果为false则程序抛出java.lang.AssertionError，输出[错误信息]
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random()*(rangeR - rangeL + 1) + rangeL); // 生成从[rangeL, rangeR]的随机数
        }
        return arr;
    }

    public static void main(String[] args) {
        SortTestHelper s = new SortTestHelper();
        int[] arr = s.generateRandomArray(10, 2, 20);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
