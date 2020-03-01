package com.learnspringboot.learnSubject.spel.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Simple {
    public List<Boolean> booleanList = new ArrayList<>();
}

