package chapter3.section2;


import java.lang.reflect.Method;

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

    /**
     * 测试sortClassName所对应的排序算法arr数所得到正确结果和算法运行时间
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName, Comparable[] arr){
        try {
            // 通过Java反射的机制，通过排序的类别 运行排序函数
            Class sortClass = Class.forName(sortClassName); //forName 返回与给定字符串名称的类或接口相关联的 类对象
            // 通过排序函数的Class对象获得排序方法.name 表示排序类中的排序方法名  第二个参数表示sort函数的入参必须是可比较的
            Method sortMethod = sortClass.getMethod("mergeSort", new Class[]{Comparable[].class});
            // 排序参数只有一个  是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);  // invoke 在具有指定参数的 方法对象上调用此 方法对象表示的底层方法
            long endTime = System.currentTimeMillis();
            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + ": " + (endTime - startTime) + "ms");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    // 判断数组是否排序成功
    private static boolean isSorted(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return  true;
    }
}
