package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> temp = new ArrayList<>();
            users.putIfAbsent(user, temp);
    }

    public void addAccount(String passport, Account account) {
        User temp = findByPassport(passport);
        if (temp != null) {
            List<Account> val = users.get(temp);
            if (!val.contains(account)) {
                val.add(account);
            }
        }
    }

    public User findByPassport(String passport){
        User rsl = null;
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                rsl = temp;
                break;
            }
        }
        return rsl;
    }


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