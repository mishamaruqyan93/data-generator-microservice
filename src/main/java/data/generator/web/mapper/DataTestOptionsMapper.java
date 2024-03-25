package data.generator.web.mapper;

import data.generator.model.test.DataTestOptions;
import data.generator.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptionsDto, DataTestOptions> {

}
