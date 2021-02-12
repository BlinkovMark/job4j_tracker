package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ====");
        int id = input.askInt("Enter id: ");
        Item showById = tracker.findById(id);
        if (showById != null) {
            out.println(showById);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        out.println(System.lineSeparator());
        return true;
    }
}
