package duke.command;

import duke.task.DukeException;
import duke.task.Task;

import java.util.ArrayList;

public class FindTask extends Command {
    
    public FindTask(ArrayList<Task> tasks) {
        super(tasks);
    }

    public String findTask(String [] arr) {
        String filterWord;
        try {
            filterWord = parser.getFilterWord(arr);
            ArrayList<Task> shallowCopy = new ArrayList<>(tasks);
            shallowCopy.removeIf(task ->
                    !(task.containsWord(filterWord))
            );
            return layout.printTaskList(true, shallowCopy);
        } catch (DukeException e) {
            return layout.print(e.getMessage());
        }
    }
    
}
