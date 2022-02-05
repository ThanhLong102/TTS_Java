package Collection_Generic_Java8.Service;

import Collection_Generic_Java8.Entity.Driver;
import Collection_Generic_Java8.Menu.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static final String DRIVER_DATA_FILE = "src/Collection_Generic_Java8/Util/File/driver.dat";

    public void showDriver() {
        for (Driver driver : Menu.driverList) System.out.println(driver);
    }

    public void addNewDriver() {
        System.out.print("Nhập số lái xe muốn thêm mới: ");
        int driverNumber = -1;
        do {
            try {
                driverNumber = new Scanner(System.in).nextInt();
                if (driverNumber > 0) {
                    break;
                }
                System.out.print("Số lái xe muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lái xe muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < driverNumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            Menu.driverList.add(driver);
        }
        Menu.fileUtil.writeDataToFile(Menu.driverList, DRIVER_DATA_FILE);
    }

    public Driver findDriverById(int driverId) {
        for (Driver driver : Menu.driverList) {
            if (driver.getId() == driverId)
                return driver;
        }
        return null;
    }

    public void initializeDriverData() {
        List<Driver> driverList = Menu.fileUtil.readDataFromFile(DriverService.DRIVER_DATA_FILE);
        if (driverList != null) {
            Driver.AUTO_ID = driverList.get(driverList.size() - 1).getId() + 1;
            Menu.driverList = driverList;
            System.out.println(Menu.driverList.size());
        } else {
            Menu.driverList = new ArrayList<>();
        }

    }
}
