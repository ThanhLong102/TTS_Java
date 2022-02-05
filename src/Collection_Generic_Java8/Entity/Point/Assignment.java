package Collection_Generic_Java8.Entity.Point;

import Collection_Generic_Java8.Entity.Line;

import java.io.Serializable;

public class Assignment implements Serializable {
    private Line line;

    private int turnNumber;

    public Assignment(Line line, int turnNumber) {
        this.line=line;
        this.turnNumber=turnNumber;
    }

    public Line getLine() {
        return line;
    }

    public float getDistance(){
        //1 lượt gồm lượt đi lượt về
        return line.getDistance()*turnNumber*2;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "line=" + line +
                ", turnNumber=" + turnNumber +
                '}';
    }
}
