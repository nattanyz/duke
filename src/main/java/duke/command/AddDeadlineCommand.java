package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.util.Storage;
import duke.util.Ui;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddDeadlineCommand extends AddTaskCommand {
    Scanner s = new Scanner(restOfCommand);

    public AddDeadlineCommand(String restOfCommand) {
        super(restOfCommand);
        s.useDelimiter("/by");
    }

    @Override
    public String getDescription() {
        return this.s.next().strip();
    }

    @Override
    public String getDeadline() {
        return this.s.next().strip();
    }

    @Override
    public Task createTask() {
        return null;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task newTask = tasks.newTask(TaskList.TaskType.DEADLINE, getDescription(), getDeadline());
            tasks.add(newTask);
        } catch (NoSuchElementException e) {
            // user input after task type is blank
            ui.showError("Oops! You did not enter a description or deadline!");
        }
    }
}
