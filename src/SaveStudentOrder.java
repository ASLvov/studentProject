import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();


        saveStudentOrder(so);
    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        System.out.println("Order from " + "'s family saved!");
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Harry");
        so.setHusband(husband);

        return so;
    }
}
