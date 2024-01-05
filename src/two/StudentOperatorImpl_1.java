package two;

import java.util.ArrayList;

public class StudentOperatorImpl_1 implements StudentOperator{
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("----------------------------");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("name:"+student.getName()+",sex:"+student.getSex()+",score:"+student.getScore());

        }
        System.out.println("----------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        double allScore = 0;
        for (int i = 0; i < students.size(); i++) {
            allScore+=students.get(i).getScore();
        }
        System.out.println("averageScore==" + allScore/students.size());
    }
}
