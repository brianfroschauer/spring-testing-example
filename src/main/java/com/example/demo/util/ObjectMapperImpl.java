package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    private final ModelMapper modelMapper;

    public ObjectMapperImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public <D, E> List<D> map(List<E> source, Class<D> target) {
        return source
                .stream()
                .map(entity -> modelMapper.map(entity, target))
                .collect(Collectors.toList());
    }

    @Override
    public <D, E> D map(E source, Class<D> target) {
        return modelMapper.map(source, target);
    }
}
