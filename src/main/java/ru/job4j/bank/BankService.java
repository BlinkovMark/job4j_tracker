package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User temp = findByPassport(passport);
        if (temp != null) {
            List<Account> val = users.get(temp);
            if (!val.contains(account)) {
                val.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт и используя цикл foreach
     * проходит по всем пользователям используя метод Map.keySet
     * если паспорт пользователя равен принимаемому паспорту,
     * записывает пользователя в возвращаемую переменную
     * прерывает цикл
     * @param passport паспорт который надо сравнить с паспортом пользователей
     * @return возвращает найденного пользователя или null если пользователь не найден
     */

    public User findByPassport(String passport) {
        User rsl = null;
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                rsl = temp;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод принимает паспорт и реквизиты,
     * ищет пользователя по паспорту,
     * проверяет что пользователь найденный по паспорту не равен null.
     * Получает список счетов пользователя,
     * проходит по счетам циклом foreach,
     * если реквизиты счета равены принимаемым реквизитам,
     * записывает счет в возвращаемую переменную
     * прерыает цикл
     * @param passport паспорт по которому находят пользователя
     * @param requisite реквизиты которые надо сравнить с реквизитами счетов пользователя
     * @return возвращает счет пользователя или null если счет не найден
     */

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User temp = findByPassport(passport);
        if (temp != null) {
        List<Account> val = users.get(temp);
        for (Account result : val) {
            if (result.getRequisite().equals(requisite)) {
                rsl = result;
                break;
            }
        }
        }
        return rsl;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}