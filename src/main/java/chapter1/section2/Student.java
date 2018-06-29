/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/14 11:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1.section2;


public class Student implements Comparable<Student> {
    String name;
    Integer score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 判断对象地大小
     *
     * @param that 被比较的对象
     * @return ths < that 返回大于0的整数；等于返回0；小于返回负整数
     */

    public int compareTo(Student that) {
        return this.score.equals(that.score) ? this.name.compareTo(that.name) : this.score.compareTo(that.score);
    }


}
