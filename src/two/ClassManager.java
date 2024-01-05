package two;

import sun.awt.windows.WLightweightFramePeer;

import java.util.ArrayList;

public class ClassManager {
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private StudentOperator studentOperator = new StudentOperatorImpl_2();//面向接口编程
    public ClassManager() {
        Student student = new Student("wl","男",66);
        studentArrayList.add(student);
        studentArrayList.add(new Student("ll","男",34));
        studentArrayList.add(new Student("ww","女",56));

    }
    public void printInfo(){
        studentOperator.printAllInfo(studentArrayList);
    }
    public void printScore(){
        studentOperator.printAverageScore(studentArrayList);
    }

}
