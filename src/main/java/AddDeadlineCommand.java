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
            tasks.addToList(TaskList.TaskType.DEADLINE, getDescription(), getDeadline());
        } catch (NoSuchElementException e) {
            // user input after task type is blank
            System.out.println("Oops! You did not enter a description or deadline!");
        }
    }
}