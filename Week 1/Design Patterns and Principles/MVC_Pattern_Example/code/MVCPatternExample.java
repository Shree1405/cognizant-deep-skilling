package MVC_Pattern_Example.code;
class Student {

    private String name;
    private int id;
    private String grade;

    public Student(
            String name,
            int id,
            String grade) {

        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id) {

        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(
            String grade) {

        this.grade = grade;
    }
}

class StudentView {

    public void displayStudentDetails(
            String name,
            int id,
            String grade) {

        System.out.println("Student Name : "
                + name);

        System.out.println("Student ID : "
                + id);

        System.out.println("Student Grade : "
                + grade);
    }
}

class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(
            Student model,
            StudentView view) {

        this.model = model;
        this.view = view;
    }

    public void setStudentName(
            String name) {

        model.setName(name);
    }

    public String getStudentName() {

        return model.getName();
    }

    public void updateView() {

        view.displayStudentDetails(
                model.getName(),
                model.getId(),
                model.getGrade());
    }
}

public class MVCPatternExample {

    public static void main(String[] args) {

        Student model =
                new Student(
                        "Shubaashree",
                        101,
                        "A");

        StudentView view =
                new StudentView();

        StudentController controller =
                new StudentController(
                        model,
                        view);

        controller.updateView();

        System.out.println();

        controller.setStudentName(
                "Shree");

        controller.updateView();
    }
}
