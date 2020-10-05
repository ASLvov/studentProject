import edu.javacourse.studentorder.domain.Address;
import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;

import java.util.Date;

public class SaveStudentOrder {
    public static void main(String[] args) {

    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        System.out.println("Order from " + studentOrder.getHusband().getSurName() + "'s family saved!");
    }

    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        return so;
    }
}
