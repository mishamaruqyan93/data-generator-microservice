package data.generator.web.mapper;

import data.generator.model.Data;
import data.generator.web.dto.DataDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<DataDto, Data> {

}
