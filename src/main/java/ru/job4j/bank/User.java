package ru.job4j.bank;

import java.util.Objects;

/**
 * Данный класс является пользователем класса BankService.
 *
 * @author Ilya
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
     * Метод создания пользователя с инициализацией его данных.
     *
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает паспорт пользователя.
     *
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для обновления паспорта.
     *
     * @param passport новый паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения имени пользователя
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для обновления имени пользователя
     *
     * @param username новое имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}