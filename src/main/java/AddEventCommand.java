import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddEventCommand extends AddTaskCommand {
    Scanner s = new Scanner(restOfCommand);

    public AddEventCommand(String restOfCommand) {
        super(restOfCommand);
        s.useDelimiter("/at");
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
            tasks.addToList(TaskList.TaskType.EVENT, getDescription(), getDeadline());
        } catch (NoSuchElementException e) {
            // user imput after task type is blank
            System.out.println("Oops! You did not enter a description or deadline!");
        }
    }
}