package Asignacion;

public class AsignacionAula {
    private String teacherName;
    private String Course;
    private String Classroom;
    private String Time;
    private int Capacity;
    private String Comments;

    public AsignacionAula(String teacherName, String course, String classroom, String time, int capacity, String comments) {
        this.teacherName = teacherName;
        Course = course;
        Classroom = classroom;
        Time = time;
        Capacity = capacity;
        Comments = comments;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getCourse() {
        return Course;
    }

    public String getClassroom() {
        return Classroom;
    }

    public String getTime() {
        return Time;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getComments() {
        return Comments;
    }
}
