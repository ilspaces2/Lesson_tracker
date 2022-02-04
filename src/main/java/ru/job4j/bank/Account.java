package ru.job4j.bank;

import java.util.Objects;

/**
 * Данный класс является аккаунтом пользователя
 * и хранит в себе информацию об аккаунте.
 *
 * @author Ilya
 * @version 1.0
 */

public class Account {
    /**
     * Реквизиты аккаунта.
     */
    private String requisite;
    /**
     * Баланс аккаунта.
     */
    private double balance;

    /**
     * Создание аккаунта с инициализацией полей.
     *
     * @param requisite реквизиты
     * @param balance   баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения реквизитов.
     *
     * @return возвращает реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для обновления реквизитов.
     *
     * @param requisite параметр для новых реквизитов
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения баланса.
     *
     * @return возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для обновления баланса.
     *
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
