package thisIsCodingTest.part3.sort.korEngMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private final String name;
    private final int korean;
    private final int english;
    private final int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        if (this.korean == other.korean && this.english == other.english && this.math == other.math) {
            return this.name.compareTo(other.name);
        }
        if (this.korean == other.korean && this.english == other.english) {
            return Integer.compare(other.math, this.math);
        }
        if (this.korean == other.korean) {
            return Integer.compare(this.english, other.english);
        }
        return Integer.compare(other.korean, this.korean);
    }
}

public class KorEngMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        for (Student student : list) {
            System.out.println(student.getName());
        }
    }
}
