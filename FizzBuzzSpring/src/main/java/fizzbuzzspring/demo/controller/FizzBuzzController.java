package fizzbuzzspring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fizzbuzzspring.demo.model.FizzBuzz;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FizzBuzzController {

    @RequestMapping(value = "/fizzBuzz/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public ResponseEntity<Object> fizzBuzz(@PathVariable("id") String id) {
        String outputString = "";
        FizzBuzz object = new FizzBuzz();
        try{
            int parsedInput = Integer.parseInt(id);
            object.setInputNumber(parsedInput);
            object.computeFizzBuzzAlfredo();
            object.createReport();
            outputString = buildCorrectInputResponse(id, object);
        } catch (NumberFormatException exception){
            outputString = "Input not correct";
        }
        return new ResponseEntity<>(outputString, HttpStatus.OK);

    }

    private String buildCorrectInputResponse(String id, FizzBuzz object) {
        String outputString;
        outputString = "Input number: " + id + " <br /> " + object.getOutput()+" <br /> "+ object.getReport();
        return outputString;
    }
}
