package Exception_JavaIO.Entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable {

    public static int AUTO_ID = 100;

    public static final String DAI_CUONG="Đại Cương";
    public static final String CO_SO_NGANH="Cơ sở ngành";
    public static final String CHUYEN_NGANH="Chuyên ngành";


    private int id;
    private String name;
    private int curriculumNumber;
    private String subjectType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurriculumNumber() {
        return curriculumNumber;
    }

    public void setCurriculumNumber(int curriculumNumber) {
        this.curriculumNumber = curriculumNumber;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public void inputInfo() {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
        System.out.print("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        intputCurriculumNumber();
        inputSubjectType();

    }

    public void intputCurriculumNumber(){
        System.out.print("Nhập số đơn vị học trình : ");
        int tempCurriculumNumber = -1;
        do {
            try {
                tempCurriculumNumber = new Scanner(System.in).nextInt();
                if (tempCurriculumNumber > 0) {
                    this.curriculumNumber = tempCurriculumNumber;
                    break;
                }
                System.out.print("Tổng số tiết phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Tổng số tiết phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
    }

    public void inputSubjectType(){
        System.out.println("Chọn loại môn: ");
        System.out.println(" 1. Đại Cương");
        System.out.println(" 2. Cơ sở ngành");
        System.out.println(" 3. Chuyên ngành");
        System.out.println("----------------------");
        System.out.print("Vui lòng chọn: ");
        do {
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 3) {
                    switch (choice) {
                        case 1:
                            this.subjectType = Subject.DAI_CUONG;
                            break;
                        case 2:
                            this.subjectType = Subject.CO_SO_NGANH;
                            break;
                        case 3:
                            this.subjectType = Subject.CHUYEN_NGANH;
                            break;
                    }
                    break;
                }
                System.out.print("Loại môn  là một số nguyên từ 1 tới 3, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Loại môn chọn phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", curriculumNumber=" + curriculumNumber +
                ", subjectType='" + subjectType + '\'' +
                '}';
    }
}
