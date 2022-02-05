package Collection_Generic_Java8.Entity.Point;

import Collection_Generic_Java8.Entity.Driver;

import java.io.Serializable;
import java.util.List;

public class AssignmentTable implements Serializable {
    private Driver driver;

    private List<Assignment> assignmentList;

    public AssignmentTable(Driver driver, List<Assignment> assignmentList) {
        this.driver = driver;
        this.assignmentList = assignmentList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public String toString() {
        return "AssignmentTable{" +
                "driver=" + driver +
                ", assignmentList=" + assignmentList +
                '}';
    }
}
