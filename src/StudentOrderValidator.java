import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public void checkAll() {
        StudentOrder[] soArray = readStudentOrders();
        /*for (int i=0; i<soArray.length; i++) {
            System.out.println("Заявка № " + soArray[i].getStudentOrderId());
            checkOneOrder(soArray[i]);
            System.out.println();
        }*/
        for (StudentOrder so : soArray) {
            System.out.println("Заявка № " + so.getStudentOrderId());
            checkOneOrder(so);
            System.out.println();
        }
    }

    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityRegisterAns = checkCityRegister(so);
        AnswerWedding weddingAns = checkWedding(so);
        AnswerChildren childrenAns = checkChildren(so);
        AnswerStudent studentAns = checkStudent(so);
        sendMail(so);
    }
    public StudentOrder[] readStudentOrders() {
        StudentOrder[] studentOrdersArray = new StudentOrder[3];
        int id;
        for (int i=0; i<studentOrdersArray.length; i++) {
            id=i+1;
            studentOrdersArray[i] = SaveStudentOrder.buildStudentOrder(id);
        }
        return studentOrdersArray;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        return cityRegisterVal.checkCityRegister(studentOrder);
    }

    public AnswerWedding checkWedding(StudentOrder studentOrder) {
        return weddingVal.checkWedding(studentOrder);
    }

    public AnswerChildren checkChildren(StudentOrder studentOrder) {
        return childrenVal.checkChildren(studentOrder);
    }

    public AnswerStudent checkStudent(StudentOrder studentOrder) {
        return studentVal.checkStudent(studentOrder);
    }

    public void sendMail(StudentOrder studentOrder) {
        mailSender.sendMail(studentOrder);
    }
}
