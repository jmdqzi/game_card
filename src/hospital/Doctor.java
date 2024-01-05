package hospital;

import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor {

    private String doctorID;
    private String departmentName;
    private String specialty;
    private LocalDate joinDate;
    private String name;
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID='" + doctorID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", joinDate=" + joinDate +
                ", name='" + name + '\'' +
                ", schedules=" + schedules +
                '}';
    }

    public Doctor(String doctorID, String departmentName, String specialty, LocalDate joinDate, String name, ArrayList<Schedule> schedules) {
        this.doctorID = doctorID;
        this.departmentName = departmentName;
        this.specialty = specialty;
        this.joinDate = joinDate;
        this.name = name;
        this.schedules = schedules;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}