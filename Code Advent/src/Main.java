import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DayOne dayOne = new DayOne("dayone.txt");
        dayOne.dayOnePartOne();
        dayOne.dayOnePartTwo();

        DayTwo dayTwo = new DayTwo("daytwo.txt");
        dayTwo.partOne();
        dayTwo.partTwo();
    }
}


