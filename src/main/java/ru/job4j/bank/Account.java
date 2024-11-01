package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модль банковского счета пользователя,
 * содержит информацию о реквизитах счета и балансе.
 */
public class Account {
    /**
     * Реквизиты счета пользователя
     */
    private String requisite;

    /**
     * Текущий баланс на счете
     */
    private double balance;

    /**
     * Конструктор для создания счета с указанными параметрами
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет установить новые рквизиыт счета
     * @param requisite новые реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить текущий баланс на счете
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет установить новое значение баланса на счете
     * @param balance новый баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод переопределяет метод equals для сравнения текущего объекта
     * с другим объектом класса Account для проверки их равенства по реквизиту счета.
     * @param o бъект, с которым будет проверяться рвенство
     * @return возвращает true если объекты равны, false если объекты не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null | getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хэш-код для текущего объекта
     * @return возвращает хэш-код от реквизитов счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
