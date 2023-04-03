package com.capgemini.holecko.home_assignment.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<Integer, T> {

    private Integer id;

    private T entity;
}
