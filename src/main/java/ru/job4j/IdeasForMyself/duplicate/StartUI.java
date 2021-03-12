package ru.job4j.IdeasForMyself.duplicate;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void initMenu(Input input, Tracker tracker, UserAction[][] menu) {
        boolean run = true;
        while (run) {
            this.MainMenu(menu);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= menu.length) {
                out.println("Wrong input, you can select: 0 .. " + (menu.length - 1));
                continue;
            }
            UserAction main = menu[select][select];
            run = main.execute(input, tracker);
        }
    }

    public void initActions(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.ActionsMenu(actions);
            int select = input.askInt("Select");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public void initSettings(Input input, Tracker tracker, UserAction[] settings) {
        boolean run = true;
        while (run) {
            this.SettingsMenu(settings);
            int select = input.askInt("Select");
            if (select < 0 || select >= settings.length) {
                out.println("Wrong input, you can select: 0 .. " + (settings.length - 1));
                continue;
            }
            UserAction setting = settings[select];
            run = setting.execute(input, tracker);
        }
    }

    private void MainMenu(UserAction[][] menu) {
        out.println("Menu.");
        for (int index = 0; index < menu.length; index++) {
            out.println(index + ". " + menu[index][index].name());
        }
    }

    private void ActionsMenu(UserAction[] actions) {
        out.println("Actions.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    private void SettingsMenu (UserAction[] settings) {
        out.println("Settings.");
        for (int index = 0; index < settings.length; index++) {
            out.println(index + ". " + settings[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] shutdown = { new ShutdownAction(output)};
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new BackAction(output),
        };
        UserAction[] settings = {
                new DevelopAction(output),
                new BackAction(output),
        };
        UserAction[][] menu = {
                actions,
                settings,
                shutdown
        };
        new StartUI(output).initMenu(input, tracker, menu);
        new StartUI(output).initActions(input, tracker, actions);
        new StartUI(output).initSettings(input, tracker, settings);
        }
}