package fizzbuzzspring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;


import fizzbuzzspring.demo.model.FizzBuzz;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzBuzzControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testIfInputForWrongInputResturnsError(){
        String output = "Input not correct";

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/fizzBuzz/tsts"),
                HttpMethod.PUT, entity, String.class);
        assertEquals(output, response.getBody());
    }

    @Test
    public void testIfInputFor20IsCorrect(){
        String output = computeExpectedResult("20");

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/fizzBuzz/20"),
                HttpMethod.PUT, entity, String.class);
        assertEquals(output, response.getBody());
    }

    private String computeExpectedResult(String id) {
        FizzBuzz object = new FizzBuzz();
        object.setInputNumber(Integer.parseInt(id));
        object.computeFizzBuzzAlfredo();
        object.createReport();
        return "Input number: " + id + "</br>" + object.getOutput()+"</br>"+object.getReport();
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }


}