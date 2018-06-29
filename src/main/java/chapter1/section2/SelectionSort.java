package chapter1.section2;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 15:34 2018/6/29
 * @Modified By:
 **/
public class SelectionSort {

    // 对指定的整数型数组进行排序，默认是进行从小到大排序
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            int minIndex = i;
            // 寻找[i,n)区间里的最小值的索引
            for (int j = i + 1; j <n ; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            // 把本轮的最小元素的位置和循环的起始位置进行置换
            swap(arr, i, minIndex);
        }
    }
    // 把指定数组的两个下标的元素互换
    private static void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 对整型进行排序
        Integer[] arr= {3, 6, 8, 4, 2, 9, 10, 7, 1, 5};
        sort(arr);
        //遍历排序后的数组
        for (int i: arr) {
            System.out.print(i + "->");
        }
        System.out.println();
        // 2.对浮点数进行排序
        Float[] b = {2.2f, 1.1f, 4.4f, 3.3f};
        sort(b);
        for (int i = 0; i < 4; ++i) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        // 3.字符数组排序
        Character[] c = {'B', 'A', 'D', 'C'};
        sort(c);
        for (int i = 0; i < 4; ++i) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
        // 4.字符串数组排序
        String[] d = {"dba", "abd", "bbc", "abc"};
        sort(d);
        for (int i = 0; i < 4; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();

        // 5.自定义对象排序
        Student[] students = new Student[4];
        students[0] = new Student("B", 78);
        students[1] = new Student("A", 86);
        students[2] = new Student("G", 34);
        students[3] = new Student("D", 78);
        sort(students);
        for (int i = 0; i < 4; i++) {
            System.out.println(students[i]);
        }
        System.out.println();
    }
}
