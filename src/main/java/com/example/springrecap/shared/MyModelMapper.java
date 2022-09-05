package com.example.springrecap.shared;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyModelMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    /**
     * Model mapper property setting are specified in the following block.
     * Default property matching strategy is set to Strict see {@link MatchingStrategies}
     * Custom mappings are added using {@link ModelMapper#addMappings(PropertyMap)}
     */
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Hide from public usage.
     */
    private MyModelMapper() {
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param <D>      type of result object.
     * @param <T>      type of source object to map from.
     * @param entity   entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of <code>outClass</code> type.
     */
    public static <D, T> D myMap(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
     * @return list of mapped object with <code><D></code> type.
     */
    //Type listType = new TypeToken<List<GroupeResponse>>() {}.getType();
    //List<GroupeResponse> groupesResponse = modelMapper.map(groupesDto, listType);
    public static <D, T> List<D> myMapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> myMap(entity, outCLass))
                .collect(Collectors.toList());
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param source      object to map from
     * @param destination object to map to
     */
    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }

    /*
     * private static ModelMapper modelMapper;
     *
     * public static <D> D myMap(Object source, Class<D> destinationType) {
     * if(modelMapper == null) { modelMapper = new ModelMapper();
     * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
     * ; }
     *
     * return modelMapper.map(source, destinationType); }
     *
     * public static <D,T> List<D> myList(Collection<T> entityList, Class<D>
     * destinationType) { if(modelMapper == null) { modelMapper = new ModelMapper();
     * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
     * ; } TypeToken t = new TypeToken<List<D>>() {}; Type listType = t.getType();
     * //Type listType = MyModelMapper.<D>listType().getType(); return
     * modelMapper.map(entityList, listType); } static <T> TypeToken<List<T>>
     * listType() { return new TypeToken<List<T>>() {}; }
     */
    /*
     * PropertyMap<StagiaireRequest, StagiaireDto> stagiaireMap = new
     * PropertyMap<StagiaireRequest, StagiaireDto>() { protected void configure() {
     * //map().setNom(source.getNom()); map().setPrenom(source.getPrenom());
     * map().setGroupe(new GroupeDto(source.getGroupeStringId()));
     *
     * } };
     *
     * modelMapper.addMappings(stagiaireMap);
     */
}
