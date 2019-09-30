package duke.command;

import static duke.task.TaskPriority.getTaskPriority;

import duke.task.Task;
import duke.task.TaskList;
import duke.task.TaskPriority;
import duke.util.Ui;
import duke.util.exception.DukeException;
import duke.util.exception.ExceptionType;
import java.util.NoSuchElementException;

/**
 * Represents a command to add a priority to a task.
 */
public class PriorityCommand extends ModifyTaskCommand {
    public PriorityCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Adds a priority to the task, based on command issued by the user.
     * @param tasks List of tasks.
     * @param ui UI to display to the user.
     * @throws DukeException Application-specific exception thrown during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        Task task = getTaskById(tasks);

        // then, try to get priority
        try {
            String priorityString = s.next().strip();
            TaskPriority priority = getTaskPriority(priorityString);

            // if ok, add priority to task
            task.addPriority(priority);
        } catch (NoSuchElementException e) {
            // user input after taskId is blank
            throw new DukeException(ExceptionType.TAG_BLANK);
        }
    }
}