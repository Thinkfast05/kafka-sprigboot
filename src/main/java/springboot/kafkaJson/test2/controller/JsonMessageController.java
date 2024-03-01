package springboot.kafkaJson.test2.controller;

import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import springboot.kafkaJson.test2.config.CustomException;
import springboot.kafkaJson.test2.kafka.JsonKafkaProducer;
import springboot.kafkaJson.test2.model.Person;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@Valid @RequestBody Person p) {
        try {
            jsonKafkaProducer.sendMessage(p);
        } catch (CustomException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "JSON is not valid", exc);

        }
        return ResponseEntity.ok("Json sent to person-topic");
    }
}
