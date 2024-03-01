package springboot.kafkaJson.test2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springboot.kafkaJson.test2.model.Person;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics="person-topic", groupId = "myGroup")
    public void consume(Person p)
    {
        LOGGER.info(String.format("Json message received -> %s", p.toString()));
    }
}
