package data.generator.web.controller;

import data.generator.model.Data;
import data.generator.model.test.DataTestOptions;
import data.generator.service.KafkaDataService;
import data.generator.service.TestDataService;
import data.generator.web.dto.DataDto;
import data.generator.web.dto.DataTestOptionsDto;
import data.generator.web.mapper.DataMapper;
import data.generator.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

    private final DataTestOptionsMapper dataTestOptionsMapper;
    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;
    private final DataMapper dataMapper;


    @PostMapping("/send")
    public void send(@RequestBody DataDto dataDto) {
        Data data = dataMapper.toEntity(dataDto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto dataTestOptionsDto) {
        DataTestOptions entity = dataTestOptionsMapper.toEntity(dataTestOptionsDto);
        testDataService.sendMassages(entity);
    }

}
