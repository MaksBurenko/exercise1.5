import java.util.*;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) {

        long l = 0;
        long r = 0;
        Queue <Long> numbers = new ArrayDeque<>();
        Set <Long> identicalNumbers = new HashSet<>();

        try {
            //       Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner("""
                    10  100
                    """);

            l = scanner.nextLong();
            r = scanner.nextLong();

            scanner.close();

        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            e.printStackTrace(System.out);
        }

        for(long i=l; i<=r; i++){
            numbers.add(i);
        }

        for (long number : numbers) {
            if(number<10){
                identicalNumbers.add(number);
            }else{
                int index = scanNumbers(number);
                int delNumber = delimeter(index);
                if(number % delNumber == 0){
                    identicalNumbers.add(number);
                }
            }
        }
        System.out.println(identicalNumbers.size());
    }

    public static int scanNumbers (long number){
        return (int)Math.log10(number) + 1;
    }

    public static int delimeter (int index){
        StringBuilder delStr = new StringBuilder("1");
        for(int i=1; i<index; i++){
            delStr.append(1);
        }
        return parseInt(delStr.toString());
    }
}