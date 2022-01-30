package Exception_JavaIO.Entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {

    public static int AUTO_ID = 10000;

    private int id;

    private String studentClass;

    public int getId() {
        return id;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public void inputInfo() {
        this.id = Student.AUTO_ID++;
        super.inputInfo();
        System.out.print("Nhập lớp:");
        this.studentClass=new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}
