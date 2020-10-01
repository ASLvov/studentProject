import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
        while (true) {
            StudentOrder so = readStudentOrder();
            if (so == null) {
                break;
            }

            AnswerCityRegister cityRegisterAns = checkCityRegister(so);
            if (!cityRegisterAns.success) {
                continue;
            }

            AnswerWedding weddingAns = checkWedding(so);
            AnswerChildren childrenAns = checkChildren(so);
            AnswerStudent studentAns = checkStudent(so);

            sendMail(so);
        }
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator srv1 = new CityRegisterValidator();
        srv1.hostName = "Host1";
        srv1.password = "Password1";
        AnswerCityRegister ans1 = srv1.checkCityRegister(studentOrder);
        return ans1;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder) {
        System.out.println("Wedding is running");
        WeddingValidator wd = new WeddingValidator();
        AnswerWedding ans = wd.checkWedding(studentOrder);
        return ans;
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        System.out.println("Children is running");
        ChildrenValidator cd = new ChildrenValidator();
        AnswerChildren ans = cd.checkChildren(studentOrder);
        return ans;
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        System.out.println("Student is running");
        StudentValidator st = new StudentValidator();
        AnswerStudent ans = st.checkStudent(studentOrder);
        return ans;
    }

    static void sendMail(StudentOrder studentOrder) {
        new MailSender().sendMail(studentOrder);
    }
}
