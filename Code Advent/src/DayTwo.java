import javax.swing.text.Style;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Scanner;

public class DayTwo {
    private final Scanner scanner;
    private final Scanner scanner1;
    private Integer gameID;
    private String[] round;
    private String[] draws;
    private Integer amount;
    private String color;
    public Integer blue;
    public Integer green;
    public Integer red;

    public DayTwo(String filename) throws FileNotFoundException {
        File file = new File(filename);
        scanner = new Scanner(file);
        scanner1 = new Scanner(file);
    }

    public void partOne() {
        int gameIDSum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            boolean possible = false;
            gameID = Integer.parseInt(line.split(" ")[1].split(":")[0]);
            round = line.split(":")[1].split(";");
            for (String s : round){
                draws = s.split(",");
                blue = 0;
                red = 0;
                green = 0;
                for (String draw : draws) {
                    amount = Integer.parseInt(draw.split(" ")[1]);
                    color = draw.split(" ")[2];
                    switch (color) {
                        case "blue" -> blue += amount;
                        case "green" -> green += amount;
                        case "red" -> red += amount;
                    }
                }
                if (blue <= 14 && green <= 13 && red <= 12) {
                    possible = true;
                } else {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                gameIDSum += gameID;
            }
        }
        scanner.close();
        System.out.println("Day 2 - Part 1: " + gameIDSum);
    }

    public void partTwo() {
        int powerOfSets = 0;
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            blue = 0;
            green = 0;
            red = 0;
            line = line.replace(";", ",");
            draws = line.split(":")[1].split(",");
            for (String draw : draws) {
                amount = Integer.parseInt(draw.split(" ")[1]);
                color = draw.split(" ")[2];
                switch (color) {
                    case "blue": {
                        if (amount >= blue) {
                            blue = amount;
                        }
                        amount = 0;
                    }
                    case "green": {
                        if (amount >= green) {
                            green = amount;
                        }
                        amount = 0;
                    }
                    case "red": {
                        if (amount >= red) {
                            red = amount;
                        }
                        amount = 0;
                    }
                }
            }
            powerOfSets += (blue * green * red);
        }
        System.out.println("Day 2 - Part 2 : " + powerOfSets);
    }
}
