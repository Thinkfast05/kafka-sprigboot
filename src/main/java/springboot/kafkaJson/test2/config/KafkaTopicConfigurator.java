package springboot.kafkaJson.test2.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfigurator {
    @Bean
    public NewTopic personTopic(){
        return TopicBuilder.name("person-topic").build();
    }
}
