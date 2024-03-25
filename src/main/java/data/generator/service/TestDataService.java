package data.generator.service;

import data.generator.model.test.DataTestOptions;
import org.springframework.stereotype.Component;

@Component
public interface TestDataService {

    void sendMassages(DataTestOptions massage);
}
