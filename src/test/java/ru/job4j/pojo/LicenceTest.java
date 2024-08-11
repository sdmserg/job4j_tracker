package ru.job4j.pojo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LicenceTest {

    @Test
    public void eqName() {
        Licence first = new Licence();
        first.setCode("audio");
        Licence second = new Licence();
        second.setCode("audio");
        assertThat(first).isEqualTo(second);
    }
}