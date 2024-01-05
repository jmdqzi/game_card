package hospital;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private LocalDate today;
    public boolean isUpdate;
    //morning
    private boolean morning;// 是否看诊
    private LocalTime mstart;
    private LocalTime mend;
    private int mTotalNumber;//接诊总人数
    private int mAppointNumber;//预约人数

    //afternoon
    private boolean afternoon;
    private LocalTime astart;
    private LocalTime aend;
    private int aTotalNumber;
    private int aAppointNumber;

    public Schedule(LocalDate today, boolean isUpdate, boolean morning, LocalTime mstart, LocalTime mend, int mTotalNumber, int mAppointNumber, boolean afternoon, LocalTime astart, LocalTime aend, int aTotalNumber, int aAppointNumber) {
        this.today = today;
        this.isUpdate = isUpdate;
        this.morning = morning;
        this.mstart = mstart;
        this.mend = mend;
        this.mTotalNumber = mTotalNumber;
        this.mAppointNumber = mAppointNumber;
        this.afternoon = afternoon;
        this.astart = astart;
        this.aend = aend;
        this.aTotalNumber = aTotalNumber;
        this.aAppointNumber = aAppointNumber;
    }

    public Schedule() {
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public LocalTime getMstart() {
        return mstart;
    }

    public void setMstart(LocalTime mstart) {
        this.mstart = mstart;
    }

    public LocalTime getMend() {
        return mend;
    }

    public void setMend(LocalTime mend) {
        this.mend = mend;
    }

    public int getmTotalNumber() {
        return mTotalNumber;
    }

    public void setmTotalNumber(int mTotalNumber) {
        this.mTotalNumber = mTotalNumber;
    }

    public int getmAppointNumber() {
        return mAppointNumber;
    }

    public void setmAppointNumber(int mAppointNumber) {
        this.mAppointNumber = mAppointNumber;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public LocalTime getAstart() {
        return astart;
    }

    public void setAstart(LocalTime astart) {
        this.astart = astart;
    }

    public LocalTime getAend() {
        return aend;
    }

    public void setAend(LocalTime aend) {
        this.aend = aend;
    }

    public int getaTotalNumber() {
        return aTotalNumber;
    }

    public void setaTotalNumber(int aTotalNumber) {
        this.aTotalNumber = aTotalNumber;
    }

    public int getaAppointNumber() {
        return aAppointNumber;
    }

    public void setaAppointNumber(int aAppointNumber) {
        this.aAppointNumber = aAppointNumber;
    }
}
