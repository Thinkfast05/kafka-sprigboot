package springboot.kafkaJson.test2.kafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import springboot.kafkaJson.test2.model.Person;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, Person> kafkaTemplate;
    public JsonKafkaProducer(KafkaTemplate<String, Person> KT){
        this.kafkaTemplate=KT;
    }
    public void sendMessage(Person p){

        LOGGER.info(String.format("Message sent -> %s", p.toString()));
            Message<Person> message = MessageBuilder
                    .withPayload(p)
                    .setHeader(KafkaHeaders.TOPIC, "person-topic")
                    .build();

            kafkaTemplate.send(message);
    }
}
