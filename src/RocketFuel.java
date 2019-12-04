import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class RocketFuel {
    private int[] masses = new int[100];
    private int totalFuelNeedsP1 = 0;

    RocketFuel() {
        getFileContents();
        getFuelRequirement();
        System.out.println("Total fuel: " + totalFuelNeedsP1);
    }

    private void getFileContents() {
        try {
            File file = new File("rocketFuelInput.txt");
            Scanner scan = new Scanner(file);
            int count = 0;
            while (scan.hasNextLine()) {
                masses[count] = Integer.parseInt(scan.nextLine());
                count++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    private void getFuelRequirement() {
        int tempValue;
        for (int mass : masses) {
            tempValue = calculateIndividualFuelNeed(mass);
            while (tempValue >= 0) {
                totalFuelNeedsP1 += tempValue;
                tempValue = calculateIndividualFuelNeed(tempValue);
            }
        }
    }

    private int calculateIndividualFuelNeed(int _mass) {
        return (int)Math.floor(_mass / 3) - 2;
    }
}
