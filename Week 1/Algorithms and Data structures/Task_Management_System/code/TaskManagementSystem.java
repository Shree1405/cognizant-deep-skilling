package Task_Management_System.code;

public class TaskManagementSystem {

    private Task head;

    // Add Task
    public void addTask(Task task) {

        if (head == null) {

            head = task;
        }

        else {

            Task current = head;

            while (current.next != null) {

                current = current.next;
            }

            current.next = task;
        }

        System.out.println(
                "Task Added Successfully");
    }

    // Search Task
    public void searchTask(
            int taskId) {

        Task current = head;

        while (current != null) {

            if (current.taskId == taskId) {

                System.out.println(
                        current);

                return;
            }

            current = current.next;
        }

        System.out.println(
                "Task Not Found");
    }

    // Traverse Tasks
    public void traverseTasks() {

        Task current = head;

        while (current != null) {

            System.out.println(
                    current);

            System.out.println(
                    "---------------------");

            current = current.next;
        }
    }

    // Delete Task
    public void deleteTask(
            int taskId) {

        if (head == null) {

            System.out.println(
                    "Task List is Empty");

            return;
        }

        if (head.taskId == taskId) {

            head = head.next;

            System.out.println(
                    "Task Deleted Successfully");

            return;
        }

        Task current = head;

        while (current.next != null &&
               current.next.taskId != taskId) {

            current = current.next;
        }

        if (current.next == null) {

            System.out.println(
                    "Task Not Found");
        }

        else {

            current.next = current.next.next;

            System.out.println(
                    "Task Deleted Successfully");
        }
    }

    public static void main(
            String[] args) {

        TaskManagementSystem tasks =
                new TaskManagementSystem();

        tasks.addTask(
                new Task(
                        101,
                        "Design UI",
                        "Pending"));

        tasks.addTask(
                new Task(
                        102,
                        "Develop Backend",
                        "In Progress"));

        tasks.addTask(
                new Task(
                        103,
                        "Testing",
                        "Pending"));

        System.out.println(
                "\nTask List\n");

        tasks.traverseTasks();

        System.out.println(
                "\nSearch Task\n");

        tasks.searchTask(
                102);

        System.out.println(
                "\nDelete Task\n");

        tasks.deleteTask(
                102);

        System.out.println(
                "\nTask List After Deletion\n");

        tasks.traverseTasks();
    }
}