package data.generator.model.test;

import data.generator.model.MeasurementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class DataTestOptions {

    private int delayInSeconds;
    private MeasurementType[] measurementTypes;

}
