package ru.job4j.collection;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("123", "Mark Blinkov", "eDer3432f"),
                new Account("142", "Mark Blinkov", "000001"));
        HashSet<Account> expect = new HashSet<>(
                Set.of(
                       new Account("123", "Mark Blinkov", "eDer3432f"),
                       new Account("142", "Mark Blinkov", "000001")));
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void removeDuplicate() {
        List<Account> accounts = List.of(
                new Account("123", "Mark Blinkov", "eDer3432f"),
                new Account("123", "Mark Blinkov", "eDer3432f"));
        HashSet<Account> expect = new HashSet<>(
                Set.of(
                        new Account("123", "Mark Blinkov", "eDer3432f")));
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}