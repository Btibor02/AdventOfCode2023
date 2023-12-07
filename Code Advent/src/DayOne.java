import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {
    private final Scanner scanner;
    private final Scanner scanner1;
    private int firstNumber;
    private int lastNumber;
    private int sumOfNumber = 0;

    public DayOne(String filename) throws FileNotFoundException {
        File file = new File(filename);
        scanner = new Scanner(file);
        scanner1 = new Scanner(file);
    }


    public void dayOnePartOne() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            firstNumber = 99;
            lastNumber = 99;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isDigit(c) && firstNumber == 99) {
                    firstNumber = Integer.parseInt(String.valueOf(c));
                } else if (Character.isDigit(c) && firstNumber != 99) {
                    lastNumber = Integer.parseInt(String.valueOf(c));
                }
            }
            if (lastNumber == 99 && firstNumber != 99) {
                lastNumber = firstNumber;
            }
            sumOfNumber += Integer.parseInt(firstNumber + String.valueOf(lastNumber));
        }
        System.out.println(sumOfNumber);
        scanner.close();
    }

    public void dayOnePartTwo() {
        sumOfNumber = 0;
        while (scanner1.hasNextLine()) {
            ArrayList<Integer> helperList = new ArrayList<>();
            String line = scanner1.nextLine();
            // Not happy with this solution :((
            for (int i = 0; i < line.toCharArray().length; i++) {
                char c1 = ' ', c2 = ' ', c3 = ' ', c4 = ' ';
                char c = line.charAt(i);
                if (line.toCharArray().length > i + 1) {
                    c1 = line.charAt(i + 1);
                }
                if (line.toCharArray().length > i + 2) {
                    c2 = line.charAt(i + 2);
                }
                if (line.toCharArray().length > i + 3) {
                    c3 = line.charAt(i + 3);
                }
                if (line.toCharArray().length > i + 4) {
                    c4 = line.charAt(i + 4);
                }
                if (c == 'o' && c1 == 'n' && c2 == 'e'|| c == '1'){
                    helperList.add(1);
                }
                if (c == 't' && c1 == 'w' && c2 == 'o'|| c == '2'){
                    helperList.add(2);
                }
                if (c == 't' && c1 == 'h' && c2 == 'r' && c3 == 'e' && c4 == 'e' || c == '3'){
                    helperList.add(3);
                }
                if (c == 'f' && c1 == 'o' && c2 == 'u' && c3 == 'r'|| c == '4'){
                    helperList.add(4);
                }
                if (c == 'f' && c1 == 'i' && c2 == 'v' && c3 == 'e'|| c == '5'){
                    helperList.add(5);
                }
                if (c == 's' && c1 == 'i' && c2 == 'x'|| c == '6'){
                    helperList.add(6);
                }
                if (c == 's' && c1 == 'e' && c2 == 'v' && c3 == 'e' && c4 == 'n'|| c == '7'){
                    helperList.add(7);
                }
                if (c == 'e' && c1 == 'i' && c2 == 'g' && c3 == 'h' && c4 == 't'|| c == '8'){
                    helperList.add(8);
                }
                if (c == 'n' && c1 == 'i' && c2 == 'n' && c3 == 'e'|| c == '9'){
                    helperList.add(9);
                }
            }
            firstNumber = helperList.get(0);
            lastNumber = helperList.get(helperList.size()-1);
            sumOfNumber += Integer.parseInt(firstNumber + String.valueOf(lastNumber));
        }
        scanner.close();
        System.out.println(sumOfNumber);
    }

}
