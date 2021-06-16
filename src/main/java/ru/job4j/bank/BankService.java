package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковской системы,
 * которая позволяет создавать пользователя,
 * создавать счет, находить пользователя по паспорту,
 * находить счет по реквизитам, переводить деньги с счета на счет
 * @author Mark Blinkov
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение пользователей и списка счетов осуществляется в коллекции HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя и добавляет его в систему,
     * проверяет существует ли такой пользователь, если да добавлять не нужно.
     * По умолчанию добавляет пустой счет.
     * @param user пользователь которого нужно добавить в систему
     */
    public void addUser(User user) {
        List<Account> temp = new ArrayList<>();
            users.putIfAbsent(user, temp);
    }

    /**
     * Метод принимает паспорт и счет
     * находит пользователя по паспорту
     * проверяет что пользователь найденный по паспорту не равен null.
     * Получает список счетов пользователя,
     * если добавляемого счета нет, добавляет
     * @param passport паспорт по которому находят пользователя
     * @param account счет который нужно проверить и добавить
     */
    public void addAccount(String passport, Account account) {
        Optional<User> temp = findByPassport(passport);
        if (temp.isPresent()) {
            List<Account> val = users.get(temp.get());
            if (!val.contains(account)) {
                val.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт
     * возвращает первый элемент отфильтрованного stream по условию,
     * если паспорт пользователя равен принимаемому паспорту, stream ключей users
     * @param passport паспорт который надо сравнить с паспортом пользователей
     * @return возвращает найденного пользователя или null если пользователь не найден
     */

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает паспорт и реквизиты,
     * ищет пользователя по паспорту,
     * проверяет что пользователь найденный по паспорту не равен null.
     * возвращает первый элемент отфильтрованного stream по условию,
     * если реквизиты пользователя равены принимаемым реквизитам, stream реквизитов users
     * @param passport паспорт по которому находят пользователя
     * @param requisite реквизиты которые надо сравнить с реквизитами счетов пользователя
     * @return возвращает счет пользователя или null если счет не найден
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }
    /**
     * Метод принимает паспорт, реквизиты переводящего, паспорт,
     * реквизиты получателя и сумму перевода
     * находит счет переводящего по паспорту и реквизитам, используя метод findByRequisite
     * находит счет получателя по паспорту и реквизитам, используя метод findByRequisite
     * проверяет, что счет переводящего и получателя найден(то есть не равен null)
     * и что баланс счета переводящего больше или равен сумме перевода
     * вычитает из баланса счета переводящего сумму перевода
     * добавляет балансу счета получающего сумму перевода
     * @param srcPassport паспорт по которому находят переводящего
     * @param srcRequisite реквизиты по которым находят счет переводящего
     * @param destPassport паспорт по которому находят получателя
     * @param destRequisite реквизиты по которым находят счет получателя
     * @param amount сумма перевода
     * @return возвращает true или false если перевод выполнен
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}