package Polymorphism_Abstraction.Entity.teaching;

import Polymorphism_Abstraction.Entity.Subject;
import Polymorphism_Abstraction.Entity.Teacher;
import Polymorphism_Abstraction.Util.DataUtil;

import java.io.Serializable;

public class Teaching implements Serializable {

    private Teacher teacher;
    private SubjectTeaching[] subjectTeachings;

    public Teaching() {
    }

    public Teaching(Teacher teacher, SubjectTeaching[] subjectTeachings) {
        this.teacher = teacher;
        this.subjectTeachings = subjectTeachings;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SubjectTeaching[] getSubjectTeachings() {
        return subjectTeachings;
    }

    public void setSubjectTeachings(SubjectTeaching[] subjectTeachings) {
        this.subjectTeachings = subjectTeachings;
    }

    public int getCurrentTotalLesson() {
        if (DataUtil.isNullOrEmptyArray(subjectTeachings)) {
            return 0;
        }
        int currentTotalLesson = 0;
        for (int i = 0; i < subjectTeachings.length; i++) {
            if(DataUtil.isNullOrEmpty(subjectTeachings[i]))
                break;
            Subject subject = subjectTeachings[i].getSubject();
            int classQuantity = subjectTeachings[i].getClassQuantity();
            currentTotalLesson += subject.getTotalLesson() * classQuantity;
        }
        return currentTotalLesson;
    }

    public float getSalary() {
        float sum = 0;
        for (SubjectTeaching subjectTeaching : subjectTeachings) {
            if (DataUtil.isNullOrEmpty(subjectTeaching))
                break;
            Subject subject =subjectTeaching.getSubject();
            sum += subject.getLessonCost()*(subject.getTheoryLesson()+(subject.getTotalLesson()-subject.getTheoryLesson())*0.7)*subjectTeaching.getClassQuantity();
        }
       return sum;
    }

    public String showArray(){
        String array="[";
        for (int i = 0; i < subjectTeachings.length; i++) {
            if(DataUtil.isNullOrEmpty(subjectTeachings[i]))
                break;
            array+=subjectTeachings[i].toString();
        }
        array+="]";
        return array;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "teacher=" + teacher +
                ", subjectTeachings=" + showArray() +
                '}';
    }
}
