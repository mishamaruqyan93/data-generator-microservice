package data.generator.web.mapper;

public interface Mappable<D, E> {

    E toEntity(D dto);

    D toDto(E entity);
}
