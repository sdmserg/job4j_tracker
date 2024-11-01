package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя,
 * содержит информацию о паспорте и имени пользователя.
 * @author sdmserg2021@gmail.com
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя
     */
    private String passport;
    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Конструктор для создания пользовтеля
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить  паспортные данные пользователя
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет установить паспортные данные пользователю
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользовтеля
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет установить новое имя для пользователя
     * @param username новое имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод переопределяет метод equals для сравнения текущего объекта
     * с другим объектом класса User для проверки их равенства по паспорту.
     * @param o объект, с которым будет проверяться рвенство
     * @return возвращает true если объекты равны, false если объекты не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.getPassport());
    }

    /**
     * Метод возвращает хэш-код для текущего объекта
     * @return возвращает хэш-код от паспорта пользователя
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
