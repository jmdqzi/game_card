package hospital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {
    private String UserName;
    private String departName;
    private String doctorId;
    private LocalDateTime appointDataTime;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointDataTime() {
        return appointDataTime;
    }

    public void setAppointDataTime(LocalDateTime appointDataTime) {
        this.appointDataTime = appointDataTime;
    }
}
