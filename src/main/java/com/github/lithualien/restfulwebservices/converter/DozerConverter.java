package com.github.lithualien.restfulwebservices.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DozerConverter {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D>  Set<D> parseSet(Set<O> origin, Class<D> destination) {
        Set<D> destinationObject = new HashSet<>();
        origin
                .forEach(e -> destinationObject.add(mapper.map(e, destination)));
        return destinationObject;
    }
}
