import edu.javacourse.studentorder.domain.Address;
import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.StudentOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jc_student",
                "postgres","112233");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM jc_street");
        while (rs.next()) {
            System.out.println(rs.getLong(1) + " : " + rs.getString(2));
        }

    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        System.out.println("Order from " + studentOrder.getHusband().getSurName() + "'s family saved!");
    }

    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        Address address = new Address("460000", "ул. Ленина", "д. 3", "", "кв. 100");
        //муж
        Adult husband = new Adult("Иванов", "Иван", "Иванович",
                LocalDate.of(2000, 1, 1), address);
        husband.setPassportSerial("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDepartment("Ленинским РОВД");
        husband.setIssueDate(LocalDate.of(2018, 1, 10));
        husband.setStudentID("" + (100000 + id));
        husband.setUniversity("ОГУ");
        //жена
        Adult wife = new Adult("Иванова", "Василиса", "Ивановна",
                LocalDate.of(2000, 6, 20), address);
        wife.setPassportSerial("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDepartment("Ленинским РОВД");
        wife.setIssueDate(LocalDate.of(2018, 6, 25));
        wife.setStudentID("" + (200000 + id));
        wife.setUniversity("ОГУ");
        //ребенок1
        Child child1 = new Child("Иванов", "Савелий", "Иванович",
                LocalDate.of(2020, 12, 11), address);
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDepartment("ЗАГС");
        child1.setIssueDate(LocalDate.of(2020, 12, 30));
        //ребенок2
        Child child2 = new Child("Иванов", "Петр", "Иванович",
                LocalDate.of(2019, 2, 14), address);
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDepartment("ЗАГС");
        child2.setIssueDate(LocalDate.of(2019, 2, 25));
        so.setStudentOrderId(id);
        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;
    }
}
