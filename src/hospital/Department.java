package hospital;

import java.time.LocalDate;
import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Doctor> doctors = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //取出容器让别人使用
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }
}
