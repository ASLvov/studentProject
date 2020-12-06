package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class StudentOrderDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test (expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        so.getHusband().setSurName(null);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test
    public void getStudentOrders() throws DaoException {
        List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();
    }

    public StudentOrder buildStudentOrder(long id) {
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
        husband.setStudentId("HH" + (100000 + id));
        husband.setUniversity(new University(2L, ""));
        //жена
        Adult wife = new Adult("Иванова", "Василиса", "Ивановна",
                LocalDate.of(2000, 6, 20), address);
        wife.setPassportSerial("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(po2);
        wife.setIssueDate(LocalDate.of(2018, 6, 25));
        wife.setStudentId("WW" + (200000 + id));
        wife.setUniversity(new University(1L, ""));
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