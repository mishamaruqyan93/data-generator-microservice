package data.generator.service;

import data.generator.model.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public interface KafkaDataService {

    void send(Data data);
}
