package ru.job4j.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @NonNull
    @Getter
    @EqualsAndHashCode.Include
    private int id;

    @Getter
    @Setter
    private String name;
}