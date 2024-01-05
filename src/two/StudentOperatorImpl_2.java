package two;

import java.util.ArrayList;

public class StudentOperatorImpl_2 implements StudentOperator{
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        int count_m = 0;
        int count_f = 0;
        System.out.println("----------------------------");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if(student.getSex()=="男"){
                count_m++;
            }else{
                count_f++;
            }
            System.out.println("name"+student.getName()+",sex"+student.getSex()+",score"+student.getScore());

        }
        System.out.println("male:" + count_m + "female:" + count_f);
        System.out.println("----------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        double allScore = 0;
        double min = students.get(0).getScore();
        double max = students.get(0).getScore();
        for (int i = 0; i < students.size(); i++) {
            if(min > students.get(i).getScore()) min = students.get(i).getScore();
            if(max < students.get(i).getScore()) min = students.get(i).getScore();
            allScore+=students.get(i).getScore();
        }
        System.out.println("min" + min);
        System.out.println("max" + max);
        System.out.println("averageScore=" + (allScore-max-min)/(students.size()-2));
    }
}

