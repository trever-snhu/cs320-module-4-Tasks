package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

  private static TaskService taskService;

  @BeforeEach
  void setUp() {
    Vector<Task> tasks = new Vector<>();
    tasks.add(new Task("1234567890", "name", "description"));
    taskService = new TaskService(tasks);
  }

  @Test
  void testDefaultConstructor() {
    // Test valid input
    TaskService taskService = new TaskService();
    assertEquals(0, taskService.getTasks().size());
  }

  @Test
  void testParameterizedConstructor() {
    // Test valid input
    Vector<Task> tasks = new Vector<>();
    tasks.add(new Task("1234567890", "name", "description"));
    TaskService taskService = new TaskService(tasks);
    assertEquals(1, taskService.getTasks().size());

    // Test invalid input
    assertThrows(IllegalArgumentException.class, () -> new TaskService(null));
  }

  @Test
  void testAddTask() {
    // Test valid input
    taskService.addTask(new Task("1234567891", "name", "description"));

    // Test invalid input
    assertAll("taskService",
        () -> assertEquals(2, taskService.getTasks().size()),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.addTask(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.addTask(new Task("1234567890", "name", "description")))
    );
  }

  @Test
  void testRemoveTask() {
    // Test valid input
    taskService.removeTask("1234567890");
    assertEquals(0, taskService.getTasks().size());

    // Add task back to list
    taskService.addTask(new Task("1234567890", "name", "description"));
    assertEquals(1, taskService.getTasks().size());

    // Test invalid input
    assertAll("removeTask with invalid input",
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.removeTask(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.removeTask("1234567891"))
    );
  }

  @Test
  void testUpdateTaskName() {
    // Test valid input
    taskService.updateTaskName("1234567890", "new name");
    assertEquals("new name", taskService.getTasks().get(0).getName());

    // Test invalid input
    assertAll("updateTaskName with invalid input",
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName(null, "new name")),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("1234567890", null)),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("1234567890", "name12345678901234567890")),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("badid", "new name"))
    );
  }

  @Test
  void testUpdateTaskDescription() {
    // Test valid input
    taskService.updateTaskDescription("1234567890", "new description");
    assertEquals("new description", taskService.getTasks().get(0).getDescription());

    // Test invalid input
    assertAll("updateTaskDescription with invalid input",
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription(null, "new description")),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("1234567890", null)),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("1234567890", "descriptiondescriptiondescriptiondescriptiondescriptiondescri")),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("badid", "new description"))
    );
  }

  @Test
  void testGetTasks() {
    // Test valid input
    assertEquals(1, taskService.getTasks().size());

  }

  @Test
  void testGetTask() {
    // Test valid input
    assertEquals("name", taskService.getTask("1234567890").getName());

    // Test invalid input
    assertAll("getTask with invalid input",
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.getTask(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> taskService.getTask("badid"))
    );
  }
}