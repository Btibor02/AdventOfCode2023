import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThree {
    private final Scanner scanner;

    public DayThree(String filename) throws FileNotFoundException {
        File file = new File(filename);
        scanner = new Scanner(file);

    }

    public void PartOne() {
        String line0 = "";
        String line1;
        String line2;
        boolean firstLine = true;
        line1 = scanner.nextLine();
        line2 = scanner.nextLine();
        while (scanner.hasNextLine()) {
            if (!firstLine) {
                line0 = line1;
                line1 = line2;
                line2 = scanner.nextLine();
            }

            for (int i = 0; i < line1.length(); i++) {
                char c1 = line1.charAt(i);
                StringBuilder numberP1 = new StringBuilder();
                if (Character.isDigit(c1)) {
                    int number = 0;
                    while (Character.isDigit(line1.charAt(i))) {
                        numberP1.append(line1.charAt(i));
                        if (!numberP1.isEmpty()) {
                            number = Integer.parseInt(String.valueOf(numberP1));
                        }
                        i++;
                    }
                    if (number != 0) {
                        int startIndex = line1.indexOf(String.valueOf(number));
                        int endIndex = startIndex + String.valueOf(number).length() - 1;

                        if (startIndex != 0 && (line1.charAt(startIndex - 1) != '.' || line2.charAt(startIndex - 1) != '.'
                                || line1.charAt(endIndex + 1) != '.' || line2.charAt(endIndex + 1) != '.')) {
                            System.out.println(number);
                        } else {
                            while (startIndex != (endIndex + 2)) {
                                if (startIndex + 1 > line1.length()) {
                                    break;
                                }
                                if (line2.charAt(startIndex) != '.') {
                                    System.out.println(number);
                                    break;
                                }
                                if (!firstLine) {
                                    if (line0.charAt(startIndex) != '.') {
                                        System.out.println(number);
                                        break;
                                    }
                                }
                                startIndex++;
                            }
                        }
                    }
                }
            }
            firstLine = false;
        }
    }
}
