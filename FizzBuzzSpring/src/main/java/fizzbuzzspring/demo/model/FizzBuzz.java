package fizzbuzzspring.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FizzBuzz {

    private int inputNumber;
    private List<String> output = new ArrayList<String>();
    private List<String> report = new ArrayList<String>();

    public FizzBuzz(){
        output = new ArrayList<String>();
        report = new ArrayList<String>();
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getOutput() {
        String result = "";
        for(String s : output)
            result += s + " ";
        return result;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public String getReport() {
        String result = "";
        for(String s : report)
            result += s + " ";
        return result;
    }

    public void setReport(List<String> report) {
        this.report = report;
    }

    public void computeFizzBuzzAlfredo() {
        for(int currentNumber=1; currentNumber<=this.inputNumber; currentNumber++){
            if(contains3(currentNumber)) this.output.add("alfresco");
            else if(isDivisibleWith3(currentNumber) && isDivisibleWith5(currentNumber))
                this.output.add("fizzbuzz");
            else if(isDivisibleWith3(currentNumber)) this.output.add("fizz");
            else if(isDivisibleWith5(currentNumber)) this.output.add("buzz");
            else this.output.add(Integer.toString(currentNumber));
        }
    }

    public void createReport() {
        int fizzNbr = Collections.frequency(this.output, "fizz");
        int buzzNbr = Collections.frequency(this.output, "buzz");
        int fizzbuzzNbr = Collections.frequency(this.output, "fizzbuzz");
        int alfrescoNbr = Collections.frequency(this.output, "alfresco");
        int intNbr = this.output.size() - (fizzNbr + buzzNbr + fizzbuzzNbr + alfrescoNbr);

        this.report.add("fizz: "+fizzNbr+" ");
        this.report.add("buzz: "+buzzNbr+" ");
        this.report.add("fizzbuzz: "+ fizzbuzzNbr+" ");
        this.report.add("alfresco: "+ alfrescoNbr+" ");
        this.report.add("Integer: "+ intNbr +" ");
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
