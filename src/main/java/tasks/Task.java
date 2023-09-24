package tasks;

public class Task {

  private final String id;
  private String name;
  private String description;

  /**
   * @param id          cannot be null or greater than 10 characters
   * @param name        cannot be null or greater than 20 characters
   * @param description cannot be null or greater than 50 characters
   * @throws IllegalArgumentException if id is null or greater than 10 characters, name is null or greater than 20
   *                                  characters, or description is null or greater than 50 characters
   */
  public Task(String id, String name, String description) throws IllegalArgumentException {
    if (id == null || id.length() > 10) {
      throw new IllegalArgumentException("Task ID cannot be null or greater than 10 characters");
    }
    if (name == null || name.length() > 20) {
      throw new IllegalArgumentException("Task name cannot be null or greater than 20 characters");
    }
    if (description == null || description.length() > 50) {
      throw new IllegalArgumentException("Task description cannot be null or greater than 50 characters");
    }
    this.id = id;
    this.name = name;
    this.description = description;
  }

  // Getters and Setters

  /**
   * @return id of the task
   */
  public String getId() {
    return this.id;
  }

  /**
   * @return name of the task
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name cannot be null or greater than 20 characters
   * @throws IllegalArgumentException if name is null or greater than 20 characters
   */
  public void setName(String name) throws IllegalArgumentException {
    // name cannot be null or greater than 20 characters
    if (name == null || name.length() > 20) {
      throw new IllegalArgumentException("Task name cannot be null or greater than 20 characters");
    }
    this.name = name;
  }

  /**
   * @return description of the task
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * @param description cannot be null or greater than 50 characters
   * @throws IllegalArgumentException if description is null or greater than 50 characters
   */
  public void setDescription(String description) throws IllegalArgumentException {
    if (description == null || description.length() > 50) {
      throw new IllegalArgumentException("Task description cannot be null or greater than 50 characters");
    }
    this.description = description;
  }
}
