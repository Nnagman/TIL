package thisIsCodingTest.part2.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    public String name;
    public int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student other) {
        return this.grade < other.grade ? -1 : 1;
    }
}

public class OrderOfGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Student(sc.next(), sc.nextInt()));
        }

        Collections.sort(list);

        for (Student student : list) {
            System.out.print(student.name + " ");
        }
    }
}
