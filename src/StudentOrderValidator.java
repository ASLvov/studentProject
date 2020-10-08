import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) throws CityRegisterException {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public void checkAll() throws CityRegisterException {
        List<StudentOrder> soList = readStudentOrders();
        /*for (int i=0; i<soList.length; i++) {
            System.out.println("Заявка № " + soList[i].getStudentOrderId());
            checkOneOrder(soList[i]);
            System.out.println();
        }*/
        for (StudentOrder so : soList) {
            System.out.println("Заявка № " + so.getStudentOrderId());
            checkOneOrder(so);
            System.out.println();
        }
    }

    public void checkOneOrder(StudentOrder so) throws CityRegisterException {
        AnswerCityRegister cityRegisterAns = checkCityRegister(so);
        AnswerWedding weddingAns = checkWedding(so);
        AnswerChildren childrenAns = checkChildren(so);
        AnswerStudent studentAns = checkStudent(so);
        sendMail(so);
    }
    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for (int i=0; i<soList.size(); i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }
        return soList;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) throws CityRegisterException {
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
