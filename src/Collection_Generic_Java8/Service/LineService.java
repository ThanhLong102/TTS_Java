package Collection_Generic_Java8.Service;

import Collection_Generic_Java8.Entity.Line;
import Collection_Generic_Java8.Menu.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LineService {
    public static final String LINE_DATA_FILE = "src/Collection_Generic_Java8/Util/File/line.dat";

    public void showLine() {
        for (Line line : Menu.lineList) System.out.println(line);
    }

    public void addNewLine() {
        System.out.print("Nhập số tuyến muốn thêm mới: ");
        int lineNumber = -1;
        do {
            try {
                lineNumber = new Scanner(System.in).nextInt();
                if (lineNumber > 0) {
                    break;
                }
                System.out.print("Số tuyến muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số tuyến muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < lineNumber; i++) {
            Line line = new Line();
            line.inputInfo();
            Menu.lineList.add(line);
        }
        Menu.fileUtil.writeDataToFile(Menu.lineList, LINE_DATA_FILE);
    }

    public Line findLineById(int lineId) {
        for (Line line : Menu.lineList) {
            if (line.getId() == lineId)
                return line;
        }
        return null;
    }

    public void initializeLineData() {
        List<Line> lineList = Menu.fileUtil.readDataFromFile(LINE_DATA_FILE);
        if (lineList != null) {
            Line.AUTO_ID = lineList.get(lineList.size() - 1).getId() + 1;
            Menu.lineList = lineList;
        } else {
            Menu.lineList = new ArrayList<>();
        }
    }
}
