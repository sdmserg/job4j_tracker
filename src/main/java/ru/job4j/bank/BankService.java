package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса.
 * Обеспечивает операции по добавлению и удалению пользователей,
 * добавлению новых банкоавских счетов, поиску пользоваталей и ссчетов,
 * а также переводы между пользователями
 */
public class BankService {
    /**
     * Map хранит данные о всех пользоателях банка и их счетах
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет создать пользователя в банковской системе
     * @param user новый пользователь банка
     */
    public void addUser(User user) {
        if (user != null) {
            users.putIfAbsent(user, new ArrayList<>());
        }
    }

    /**
     * Метод позволяет удалить пользовтаеля из банковской системы
     * @param passport паспорт пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить новый банковский счет для пользовтаеля
     * по его паспорту
     * @param passport паспорт пользователя
     * @param account новый аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользовтаеля в системе по его паспорту.
     * @param passport паспорт пользователя
     * @return возвращает пользовтеля или null если пользователь с таким паспортом не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет найти счет пользователя по его паспорту и реквизитам счета
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета
     * @return возвращает аккант пользователя или null если аккаунт не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет переводить деньги с одного банковского счета на другой счет
     * @param sourcePassport паспорт отправитля платежа
     * @param sourceRequisite реквизиты счета отправитлея платежа
     * @param destinationPassport паспорт полчателя платежа
     * @param destinationRequisite реквизиты сета получателя платежа
     * @param amount сумма перевода
     * @return возвращает true если перевод выполнен, false если перевод выполнить не удалось
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || destinationAccount == null
                || sourceAccount.getBalance() < amount) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    }

    /**
     * Метод возвращает все счета пользователя в банке
     * @param user пользователь банка
     * @return возвращает список всех счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
