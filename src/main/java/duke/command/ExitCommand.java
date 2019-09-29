package duke.command;

import duke.task.TaskList;
import duke.util.Ui;

/**
 * Exits the application.
 */
public class ExitCommand implements Command {

    /**
     * Exits the application.
     * @param tasks List of tasks.
     * @param ui UI to display to the user.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        // do nothing
    }

    /**
     * Returns boolean indicating if command entered was "exit", true in this case.
     * @return boolean indicating if command entered was "exit".
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
