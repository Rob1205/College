import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> taskList = new ArrayList<>();

    private Task searchForTask(String id) throws Exception {
        for (Task task : taskList) {
            if (id.equals(task.getTaskId())) {
                return task;
            }
        }
        throw new Exception("The Task does not exist!");
    }

    public boolean addTask(Task task) {
        String taskId = task.getTaskId();

        // Check if the ID already exists in the list
        for (Task existingTask : taskList) {
            if (taskId.equals(existingTask.getTaskId())) {
                // If the ID already exists, return false (task not added)
                return false;
            }
        }

        // If the ID is unique, add the task to the list and return true
        taskList.add(task);
        return true;
    }

    public void deleteTask(String id) throws Exception {
        taskList.remove(searchForTask(id));
    }

    public void updateName(String id, String name) throws Exception {
        searchForTask(id).setName(name);
    }

    public void updateDescription(String id, String description) throws Exception {
        searchForTask(id).setDescription(description);
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
