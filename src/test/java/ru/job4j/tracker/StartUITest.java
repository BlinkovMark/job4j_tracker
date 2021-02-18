package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ShutdownAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));

        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ShutdownAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ShutdownAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Find item1"));
        Item item2 = tracker.add(new Item("Find item2"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new ShowAction(out),
                new ShutdownAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show" + System.lineSeparator() +
                        "1. Shutdown" + System.lineSeparator() +
                        "== All items ==" + System.lineSeparator() +
                        item1 + System.lineSeparator() +
                        item2 + System.lineSeparator() +
                        System.lineSeparator() +
                        System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show" + System.lineSeparator() +
                        "1. Shutdown" + System.lineSeparator() +
                        "Bye" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "item", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ShutdownAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Name" + System.lineSeparator() +
                        "1. Shutdown" + System.lineSeparator() +
                        "== Find items by name ==" + System.lineSeparator() +
                        "Заявки с таким именем не найдены" + System.lineSeparator() +
                        System.lineSeparator() +
                        System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by Name" + System.lineSeparator() +
                        "1. Shutdown" + System.lineSeparator() +
                        "Bye" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ShutdownAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Shutdown" + System.lineSeparator() +
                        "== Find item by Id ==" + System.lineSeparator() +
                        "Заявка с таким id не найдена" + System.lineSeparator() +
                        System.lineSeparator() +
                        System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Shutdown" + System.lineSeparator() +
                        "Bye" + System.lineSeparator()
        ));
    }
}