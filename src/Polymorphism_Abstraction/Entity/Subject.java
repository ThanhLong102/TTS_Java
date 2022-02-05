package Polymorphism_Abstraction.Entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable {
    public static int AUTO_ID = 100;

    private int id;
    private String name;
    private int totalLesson;
    private int theoryLesson;
    private float lessonCost;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public float getLessonCost() {
        return lessonCost;
    }

    public void setLessonCost(float lessonCost) {
        this.lessonCost = lessonCost;
    }

    public void inputInfo() {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
        System.out.print("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();

        System.out.print("Nhập tổng số tiết: ");
        int tempTotalLesson = -1;
        do {
            try {
                tempTotalLesson = new Scanner(System.in).nextInt();
                if (tempTotalLesson > 0) {
                    this.totalLesson = tempTotalLesson;
                    break;
                }
                System.out.print("Tổng số tiết phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Tổng số tiết phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);

        inputTheoryLesson();
        inputLessonCost();
    }

    private void inputLessonCost() {
        System.out.print("Nhập mức kinh phí: ");
        float tempLessonCost = -1;
        do {
            try {
                tempLessonCost = new Scanner(System.in).nextFloat();
                if (tempLessonCost > 0) {
                    this.lessonCost = tempLessonCost;
                    break;
                }
                System.out.print("Mức phi phải là số thực, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Mức phi phải là số thực, vui lòng nhập lại: ");
            }
        } while (true);
    }

    private void inputTheoryLesson() {
        System.out.print("Nhập số tiết lý thuyết: ");
        int tempTheoryLesson = -1;
        do {
            try {
                tempTheoryLesson = new Scanner(System.in).nextInt();
                if (tempTheoryLesson > 0) {
                    this.theoryLesson = tempTheoryLesson;
                    break;
                }
                System.out.print("Tổng số tiết lý thuyết phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Tổng số tiết lý thuyết phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name='" + name + '\'' + ", totalLesson=" + totalLesson + ", theoryLesson=" + theoryLesson + ", lessonCost=" + lessonCost + '}';
    }
}
