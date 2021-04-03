package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Mark Blinkov", "eDer3432f"),
                new Account("142", "Mark Blinkov", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Mark Blinkov", "eDer3432f"),
                        new Account("142", "Mark Blinkov", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void removeDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Mark Blinkov", "eDer3432f"),
                new Account("123", "Mark Blinkov", "eDer3432f")
        );
        HashSet<Account> expect = new HashSet<>(
                Collections.singletonList(
                        new Account("123", "Mark Blinkov", "eDer3432f")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}