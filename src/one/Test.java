package one;

import javafx.scene.media.EqualizerBand;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("新年快乐！！！！！！");

        Student[] students = new Student[3];
        students[0] = new Student("w", 23);
        students[1] = new Student("wl", 234);
        students[2] = new Student("wwl", 231);
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (Double.compare(o1.getAge(), o2.getAge()));
            }
        });
        System.out.println(Arrays.toString(students));

    }

}
class Student implements Comparable<Student>{
    private String name;
    private double age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.age-o.age);
    }
}