package 华为108;

import java.util.*;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 成绩排序 {
    /**
     * 题目描述
     * <p>
     * 输入描述:
     * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
     * 输出描述:
     * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nInt = sc.nextLine();
            int n = Integer.parseInt(nInt);
            String modelInt = sc.nextLine();
            int model = Integer.parseInt(modelInt);
            Student[] students=new Student[n];
            String[] name = new String[n];
            int[] nNums = new int[n];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                name[i] = s.split(" ")[0];
                nNums[i] = Integer.parseInt(s.split(" ")[1]);
                students[i]=new Student(s.split(" ")[0],Integer.parseInt(s.split(" ")[1]));


            }
            paixu(model, students);
        }
        sc.close();
    }

    private static void paixu(int model, Student[] students) {
        Student.flag=model;
        Arrays.sort(students);
        for(Student s :students){
            System.out.println(s);
        }
    }


}
class Student implements Comparable<Student>{
    String name;
    int score;
    public static int flag;

    public Student( String name,int score){
        this.name=name;
        this.score=score;
    }

    public int compareTo(Student other) {
        if (flag == 0)
            return other.score - score;
        return score - other.score;
    }

    public String toString() {
        return name + " " + score;
    }
}
