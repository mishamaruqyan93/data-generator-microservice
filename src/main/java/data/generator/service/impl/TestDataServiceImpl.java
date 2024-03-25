package data.generator.service.impl;

import data.generator.model.Data;
import data.generator.model.MeasurementType;
import data.generator.model.test.DataTestOptions;
import data.generator.service.KafkaDataService;
import data.generator.service.TestDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;


    @Override
    public void sendMassages(DataTestOptions dataTestOptions) {
        if (dataTestOptions.getMeasurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Data data = new Data();
                        data.setSensorId((long) getRandomNumber(1, 10));
                        data.setMeasurement(getRandomNumber(15, 100));
                        data.setMeasurementType(getRandomMeasurementType(dataTestOptions.getMeasurementTypes()));
                        data.setTimestamp(LocalDateTime.now());
                        kafkaDataService.send(data);
                    },
                    0,
                    dataTestOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS);
        }
    }

    private MeasurementType getRandomMeasurementType(MeasurementType[] measurementTypes) {
        int randomTypeId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomTypeId];
    }


    private double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

}
