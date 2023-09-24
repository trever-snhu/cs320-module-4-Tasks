package tasks;

import java.util.Vector;

public class TaskService {

  private final Vector<Task> tasks;

  // Constructor
  public TaskService() {
    this.tasks = new Vector<>();
  }

  // Parameterized Constructor
  public TaskService(Vector<Task> tasks) throws IllegalArgumentException {
    if (tasks == null) {
      throw new IllegalArgumentException("Tasks cannot be null");
    }
    this.tasks = tasks;
  }

  /**
   * Add a task to the list of tasks with a unique ID
   *
   * @param task cannot be null and must have a unique ID
   * @throws IllegalArgumentException if task is null or task ID is not unique
   */
  public void addTask(Task task) throws IllegalArgumentException {
    // Check if task is null
    if (task == null) {
      throw new IllegalArgumentException("Task cannot be null");
    }

    // Check if task ID is unique
    for (Task t : this.tasks) {
      if (t.getId().equals(task.getId())) {
        throw new IllegalArgumentException("Task ID must be unique");
      }
    }

    // Add task to list of tasks
    this.tasks.add(task);
  }

  /**
   * Remove a task from the list of tasks given a taskId
   *
   * @param taskId cannot be null
   * @throws IllegalArgumentException if taskId is null or the task is not found
   */
  public void removeTask(String taskId) throws IllegalArgumentException {
    // Check if taskId is null
    if (taskId == null) {
      throw new IllegalArgumentException("Task ID cannot be null");
    }

    // Remove task from list of tasks
    for (Task t : this.tasks) {
      if (t.getId().equals(taskId)) {
        this.tasks.remove(t);
        return;
      }
    }

    // Throw exception if task not found
    throw new IllegalArgumentException("Task ID not found");
  }

  /**
   * Updates the name of a task given a taskId and new name
   *
   * @param taskId  cannot be null
   * @param newName cannot be null or greater than 20 characters
   * @throws IllegalArgumentException if taskId is null, newName is null, or newName is greater than 20 characters
   */
  public void updateTaskName(String taskId, String newName) throws IllegalArgumentException {
    // Check if taskId is null
    if (taskId == null) {
      throw new IllegalArgumentException("Task ID cannot be null");
    }

    // Check if newName is null or greater than 20 characters
    if (newName == null || newName.length() > 20) {
      throw new IllegalArgumentException("Task name cannot be null or greater than 20 characters");
    }

    // Update task name
    for (Task t : this.tasks) {
      if (t.getId().equals(taskId)) {
        t.setName(newName);
        return;
      }
    }

    // Throw exception if task not found
    throw new IllegalArgumentException("Task ID not found");
  }

  /**
   * Updates the description of a task given a taskId and new description
   *
   * @param taskId         cannot be null
   * @param newDescription cannot be null or greater than 50 characters
   * @throws IllegalArgumentException if taskId is null, newDescription is null, or newDescription is greater than 50 characters
   */
  public void updateTaskDescription(String taskId, String newDescription) throws IllegalArgumentException {
    // Check if taskId is null
    if (taskId == null) {
      throw new IllegalArgumentException("Task ID cannot be null");
    }

    // Check if newDescription is null or greater than 50 characters
    if (newDescription == null || newDescription.length() > 50) {
      throw new IllegalArgumentException("Task description cannot be null or greater than 50 characters");
    }

    // Update task description
    for (Task t : this.tasks) {
      if (t.getId().equals(taskId)) {
        t.setDescription(newDescription);
        return;
      }
    }

    // Throw exception if task not found
    throw new IllegalArgumentException("Task ID not found");
  }

  /**
   * Returns a list of all tasks
   *
   * @return list of all tasks
   */
  public Vector<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Returns a task given a taskId
   *
   * @param taskId cannot be null
   * @return task with the given taskId
   * @throws IllegalArgumentException if taskId is null or task is not found
   */
  public Task getTask(String taskId) throws IllegalArgumentException {
    // Check if taskId is null
    if (taskId == null) {
      throw new IllegalArgumentException("Task ID cannot be null");
    }

    // Return task with given taskId
    for (Task t : this.tasks) {
      if (t.getId().equals(taskId)) {
        return t;
      }
    }

    // Throw exception if task not found
    throw new IllegalArgumentException("Task ID not found");
  }

}
