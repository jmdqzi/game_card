package hospital;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class HospitalManager {
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addDepartment() {
        OUT:
        while (true) {
            System.out.println("输入科室名称");
            String name = sc.next();
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getName().equals(name)) {
                    System.out.println("名称重复");
                    continue OUT;
                }
            }
            Department department = new Department();
            department.setName(name);
            departments.add(department);
            break;
        }
    }

    public void addDoctor() {
        if (departments.size() == 0) {
            System.out.println("当前没有科室，不可录入");
            return;
        }
        Doctor doctor = new Doctor();
        while (true) {
            System.out.println("选择科室");
            for (int i = 0; i < departments.size(); i++) {
                System.out.println(i + 1 + "," + departments.get(i).getName());
            }
            System.out.println("输入科室编号");
            int command = sc.nextInt();
            Department department = departments.get(command - 1);
            doctor.setDepartmentName(department.getName());

            doctor.setDoctorID(UUID.randomUUID().toString());
            System.out.println("输入姓名");
            String name = sc.next();
            doctor.setName(name);
            System.out.println("输入专业");
            String specialty = sc.next();
            doctor.setSpecialty(specialty);
//            System.out.println("输入时间 yyyy-MM-dd");
//            String joinDateString = sc.next();
//            LocalDate joinDate = LocalDate.parse(joinDateString);
//            doctor.setJoinDate(joinDate);
            //难点
            //要把doctor类传入形参为（ArrayList<Doctor> doctors）的方法
            department.getDoctors().add(doctor);
            break;
        }
    }

    public void prin() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getDoctors().toString());
        }
    }

    public void upDateSchedules(ArrayList<Schedule> schedules) {
        //初始化，给每个schedule增加日期
        if (schedules.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Schedule schedule = new Schedule();
                schedule.setToday(LocalDate.now().plusDays(i));
                schedules.add(schedule);
            }
            return;
        }
        //去除过期时间
        int size = schedules.size();
        for (int i = 0; i < size; i++) {
            LocalDate now = LocalDate.now();
            Schedule schedule = schedules.get(i);
            if (schedule.getToday().isBefore(now)) {
                schedules.remove(schedule);
                i--;//别忘了这
            }
        }
        //补全当前和未来一天
        int day = schedules.size();
        LocalDate last = schedules.get(day - 1).getToday();
        for (int i = 0; i < 3 - day; i++) {
            Schedule schedule = new Schedule();
//            schedule.setToday(LocalDate.now().plusDays(i+1));//错误的
            schedule.setToday(last.plusDays(i + 1));
            schedules.add(schedule);
        }
    }

    public Department choiceDepartmentByUser(ArrayList<Department> departments) {
        if (departments.size() == 0) {
            System.out.println("当前没有科室，不可录入");
            return null;
        }
        Doctor doctor = new Doctor();
        while (true) {
            System.out.println("选择科室");
            for (int i = 0; i < departments.size(); i++) {
                System.out.println(i + 1 + "," + departments.get(i).getName());
            }
            System.out.println("输入科室编号");
            int command = sc.nextInt();
            Department department = departments.get(command - 1);
            return department;
        }
    }

    public void setDoctorJob() {
        System.out.println("设置坐诊时间");
        Department department = choiceDepartmentByUser(departments);
        //选择医生
        ArrayList<Doctor> doctors = department.getDoctors();
        if (doctors.size() == 0) {
            System.out.println("当前科室无医生");
            return;
        }
        while (true) {
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println(i+1+","+doctors.get(i).getName());
            }
            System.out.println("输入要选的人");
            int command = sc.nextInt();
            Doctor doctor = doctors.get(command-1);//要减一
            ArrayList<Schedule> schedules = doctor.getSchedules();
            //更新
            upDateSchedules(schedules);
            //修改
            int size = schedules.size();
            for (int i = 0; i < size; i++) {
                Schedule schedule = schedules.get(i);
                updateDoctorSchedule(schedule);
            }
            break;
        }
    }
    public void updateDoctorSchedule(Schedule schedule){
        LocalDate today = schedule.getToday();
        System.out.println(today+",安排如下");
        if(!schedule.isUpdate()){
            System.out.println("未排班");
        }else {
            System.out.println("\t上午\t");
            if(schedule.isMorning()){
                System.out.println("坐诊 时间为： "+schedule.getMstart()+"--"
                +schedule.getMend()+"总人数/预约人数"+schedule.getmTotalNumber()+"/"+schedule.getmAppointNumber());
            }else {
                System.out.println("休息");
            }
        }
        System.out.println("是否需要修改");
        String re = sc.next();
        if("y".equals(re)){
            schedule.setUpdate(true);
            System.out.println("早上是否上班 y/n");
            String re2 = sc.next();
            if("y".equals(re2)){
                schedule.setMorning(true);
                System.out.println("开始和结束时间");
                String start = sc.next();
                String end = sc.next();
                System.out.println("可预约人数");
                int number = sc.nextInt();
                schedule.setMstart(LocalTime.parse(start));
                schedule.setMend(LocalTime.parse(end));
                schedule.setmTotalNumber(number);
            }else {
                schedule.setMorning(false);
            }
        }
    }
    public void showAllDoctorInfos(){
        System.out.println("========查看科室==========");
        Department department = choiceDepartmentByUser(departments);
        ArrayList<Doctor> doctors = department.getDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println(doctor.getName()+"信息");
            ArrayList<Schedule> schedules = doctor.getSchedules();
            upDateSchedules(schedules);//更新一哈
            for (int i1 = 0; i1 < schedules.size(); i1++) {
                Schedule schedule = schedules.get(i1);
                if(!schedule.isUpdate()){
                    System.out.println("未排班");
                    continue;
                }else {
                    if(schedule.isMorning()){
                        System.out.println("上午"+schedule.getMstart()+"-"+schedule.getMend());
                        System.out.println("总人数/预约人数"+schedule.getmTotalNumber()+"/"+schedule.getmAppointNumber());
                    }
                }
            }
        }
    }
}

class APP {
    public static void main(String[] args) {
        HospitalManager hospitalManager = new HospitalManager();
        hospitalManager.addDepartment();
//        hospitalManager.addDoctor();
        hospitalManager.addDoctor();
        hospitalManager.setDoctorJob();
        hospitalManager.showAllDoctorInfos();



    }

}