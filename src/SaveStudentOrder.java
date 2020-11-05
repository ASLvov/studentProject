import edu.javacourse.studentorder.dao.DictionaryDaoImpl;
import edu.javacourse.studentorder.dao.StudentOrderDao;
import edu.javacourse.studentorder.dao.StudentOrderDaoImpl;
import edu.javacourse.studentorder.domain.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
//        List<Street> d = new DictionaryDaoImpl().findStreets("ул");
//        for (Street s : d) {
//            System.out.println(s.getStreetName());
//        }
//        System.out.println("_________________________");
//        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
//        for (PassportOffice p : po) {
//            System.out.println(p.getOfficeName());
//        }
//        System.out.println("_________________________");
//        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//        for (RegisterOffice r : ro) {
//            System.out.println(r.getOfficeName());
//        }
//        System.out.println("_________________________");
//        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
//        for (CountryArea c : ca1) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
//        System.out.println("_________________________");
//        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
//        for (CountryArea c : ca2) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
//        System.out.println("_________________________");
//        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
//        for (CountryArea c : ca3) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
//        System.out.println("_________________________");
//        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
//        for (CountryArea c : ca4) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
        StudentOrder s = buildStudentOrder(10);
        StudentOrderDao dao = new StudentOrderDaoImpl();
        Long id = dao.saveStudentOrder(s);
        System.out.println(id);
    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        System.out.println("Order from " + studentOrder.getHusband().getSurName() + "'s family saved!");
    }

    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));

        RegisterOffice ro1 = new RegisterOffice(1L, "", "");
        so.setMarriageOffice(ro1);

        Street street = new Street(1L, "First street");
        Address address = new Address("460000", street, "д. 3", "", "кв. 100");

        //муж
        Adult husband = new Adult("Иванов", "Иван", "Иванович",
                LocalDate.of(2000, 1, 1), address);
        husband.setPassportSerial("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setIssueDate(LocalDate.of(2018, 1, 10));
        husband.setStudentID("" + (100000 + id));
        husband.setUniversity("ОГУ");
        //жена
        Adult wife = new Adult("Иванова", "Василиса", "Ивановна",
                LocalDate.of(2000, 6, 20), address);
        wife.setPassportSerial("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(po2);
        wife.setIssueDate(LocalDate.of(2018, 6, 25));
        wife.setStudentID("" + (200000 + id));
        wife.setUniversity("ОГУ");
        //ребенок1
        Child child1 = new Child("Иванов", "Савелий", "Иванович",
                LocalDate.of(2020, 12, 11), address);
        child1.setCertificateNumber("" + (300000 + id));
        RegisterOffice ro2 = new RegisterOffice(2L, "", "");
        child1.setIssueDepartment(ro2);
        child1.setIssueDate(LocalDate.of(2020, 12, 30));
        //ребенок2
        Child child2 = new Child("Иванов", "Петр", "Иванович",
                LocalDate.of(2019, 2, 14), address);
        child2.setCertificateNumber("" + (400000 + id));
        RegisterOffice ro3 = new RegisterOffice(3L, "", "");
        child2.setIssueDepartment(ro3);
        child2.setIssueDate(LocalDate.of(2019, 2, 25));
        so.setStudentOrderId(id);
        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;
    }
}
