package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice  office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicatePassportThanFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen duplicateCitizen = new Citizen("2f44a", "Ivanov Ivan");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean result = office.add(duplicateCitizen);
        assertThat(result).isFalse();
    }
}