package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банк сервиса. Имеет структуру данных в виде ключ-значение.
 *
 * @author Ilya
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации осуществляется с помощью HashMap.
     * Пользователь является ключом а его аккаунты это значение.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя, если такой пользователь
     * отсутствует то его добавляют хранилище.
     *
     * @param user пользователь который добавляется в хранилище.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт и добавляемый аккаунт.
     * Если пользователь найден по паспорту и входящий аккаунт
     * у пользователя отсутствует то добавляем аккаунт.
     *
     * @param passport используется для поиска пользователя
     * @param account  добавляется к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(accounts)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт и ищет пользователя.
     *
     * @param passport паспорт пользователя
     * @return возвращает найденного пользователя
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает на вход паспорт пользователя и реквизиты аккаунта.
     * По паспорту ищем пользователя, если находим то
     * ищем у него аккаунт с нужными реквизитами.
     *
     * @param passport  паспорт пользователя
     * @param requisite реквизиты аккаунта
     * @return возвращает найденный аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорта, реквизиты и сумму перевода.
     * Осуществляет перевод денег между аккаунтами пользователя или между пользователями.
     *
     * @param srcPassport   пользователь который переводит деньги
     * @param srcRequisite  реквизиты аккаунта откуда будет делать перевод
     * @param destPassport  пользователь который принимает деньги
     * @param destRequisite реквизиты аккаунта куда будет делать перевод
     * @param amount        сумма перевода
     * @return если операция прошла успешно то возвращается true
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
