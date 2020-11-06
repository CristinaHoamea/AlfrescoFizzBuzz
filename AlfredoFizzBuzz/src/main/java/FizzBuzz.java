import java.util.*;

public class FizzBuzz {

    public static void main(String [] args){
        int number = readInput();
        System.out.println("Number: "+number);
        List<String> result = processInput(number);
        displayResult(result);
        List<String> output = createReport(result);
        displayResult(output);
    }

    private static int readInput() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter number: ");
        return console.nextInt();
    }

    private static List<String> processInput(int number) {
        List<String> result = new ArrayList<String>();
        for(int currentNumber=1; currentNumber<=number; currentNumber++){
            if(contains3(currentNumber)) result.add("alfresco");
            else if(isDivisibleWith3(currentNumber) && isDivisibleWith5(currentNumber))
                result.add("fizzbuzz");
            else if(isDivisibleWith3(currentNumber)) result.add("fizz");
            else if(isDivisibleWith5(currentNumber)) result.add("buzz");
            else result.add(Integer.toString(currentNumber));
        }
        return result;
    }

    private static void displayResult(List<String> result) {
        for(String nbr : result)
            System.out.print(nbr + " ");
        System.out.println();
    }

    private static ArrayList<String> createReport(List<String> result) {
        List<String> output = new ArrayList<String>();
        int fizzNbr = Collections.frequency(result, "fizz");
        int buzzNbr = Collections.frequency(result, "buzz");
        int fizzbuzzNbr = Collections.frequency(result, "fizzbuzz");
        int alfrescoNbr = Collections.frequency(result, "alfresco");
        int intNbr = result.size() - (fizzNbr + buzzNbr + fizzbuzzNbr + alfrescoNbr);

        return new ArrayList<String>() {
            {
                add("fizz: "+fizzNbr);
                add("buzz: "+buzzNbr);
                add("fizzBuzz: "+fizzbuzzNbr);
                add("alfrescoNbr: "+alfrescoNbr);
                add("integer: "+intNbr);
            }
        };
    }

    private static boolean contains3(int number){
        return Integer.toString(number).contains("3");
    }

    private static boolean isDivisibleWith3(int number) {
        return number%3 == 0;
    }

    private static boolean isDivisibleWith5(int number) {
        return number%5 == 0;
    }

}
