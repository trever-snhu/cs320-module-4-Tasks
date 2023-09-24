package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

  // Test constructor
  @Test
  void testConstructor() {
    // Test valid input
    Task task = new Task("1234567890", "name", "description");
    assertEquals("1234567890", task.getId());
    assertEquals("name", task.getName());
    assertEquals("description", task.getDescription());

    // Test invalid input
    assertThrows(IllegalArgumentException.class, () -> new Task(null, "name", "description"));
    assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "name", "description"));
    assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", null, "description"));
    assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "name12345678901234567890", "description"));
    assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "name", null));
    assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "name", "descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptionde"));
  }

  // Test setting name
  @Test
  void testSetName() {
    // Test valid input
    Task task = new Task("1234567890", "name", "description");
    task.setName("new name");
    assertEquals("new name", task.getName());

    // Test invalid input
    assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    assertThrows(IllegalArgumentException.class, () -> task.setName("name12345678901234567890"));
  }

  // Test setting description
  @Test
  void testSetDescription() {
    // Test valid input
    Task task = new Task("1234567890", "name", "description");
    task.setDescription("new description");
    assertEquals("new description", task.getDescription());

    // Test invalid input
    assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    assertThrows(IllegalArgumentException.class, () -> task.setDescription("descriptiondescriptiondescriptiondescriptiondescriptiondescri"));
  }
}