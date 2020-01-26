package com.example.demo.util;

import java.util.List;

public interface ObjectMapper {

    /**
     * Map the provided {@param source} object to {@param target} object.
     *
     * @param source list of objects to be mapped.
     * @return the mapped entities.
     */
    <D, E> List<D> map(List<E> source, Class<D> target);

    /**
     * Map a {@param source} object to {@param target} object.
     *
     * @param source object to be mapped.
     * @return the mapped entity.
     */
    <D, E> D map(E source, Class<D> target);
}
