package Exception_JavaIO.Entity.Point;

import Exception_JavaIO.Entity.Student;
import Exception_JavaIO.Util.DataUtil;

import java.io.Serializable;
import java.util.Arrays;

public class PointTable implements Serializable {
    private Student student;

    private SubjectPoint[] subjectPoints;

    public PointTable(Student student, SubjectPoint[] subjectPoints) {
        this.student = student;
        this.subjectPoints = subjectPoints;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectPoint[] getSubjectPoints() {
        return subjectPoints;
    }

    public void setSubjectPoints(SubjectPoint[] subjectPoints) {
        this.subjectPoints = subjectPoints;
    }

    public float getAvgPoint() {
        int count = 0;
        float sum = 0;
        for (SubjectPoint subjectPoint : subjectPoints) {
            if (DataUtil.isNullOrEmpty(subjectPoint))
                break;
            sum += subjectPoint.getPoint()*subjectPoint.getSubject().getCurriculumNumber();
            count+=subjectPoint.getSubject().getCurriculumNumber();
        }
        if (count == 0)
            return 0;
        else return sum / count;
    }

    @Override
    public String toString() {
        return "PointTable{" +
                "student=" + student +
                ", subjectPoints=" + Arrays.toString(subjectPoints) +
                '}';
    }
}
