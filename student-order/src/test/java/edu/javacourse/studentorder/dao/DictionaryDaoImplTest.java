package edu.javacourse.studentorder.dao;


import edu.javacourse.studentorder.domain.CountryArea;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.RegisterOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DictionaryDaoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void testFindStreets() throws DaoException {
        logger.info("TEST");
        List<Street> streets = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(streets.size() == 2);
    }

    @Test
    public void testFindPassportOffices() throws DaoException {
        List<PassportOffice> passportOffices = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(passportOffices.size() == 2);
    }

    @Test
    public void testFindRegisterOffices() throws DaoException {
        List<RegisterOffice> registerOffices = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        Assert.assertTrue(registerOffices.size() == 2);
    }

    @Test
    public void testFindAreas() throws DaoException {
        List<CountryArea> countryAreas1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(countryAreas1.size() == 2);
        List<CountryArea> countryAreas2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(countryAreas1.size() == 2);
    }

    @Test
    public void testExample1() {
        System.out.println("Test 1");
    }

    @Test
    public void testExample2() {
        System.out.println("Test 2");
    }

    @Test
    public void testExample3() {
        System.out.println("Test 3");
    }
}