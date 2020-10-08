package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;

import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator {
    public String hostName;
    public int port;
    public String login;
    public String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) throws CityRegisterException {
        try {
            CityRegisterCheckerResponse hAns = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wAns = personChecker.checkPerson(so.getWife());
            List<Child> children = so.getChildren();
            for (int i = 0; i < so.getChildren().size(); i++) {
                CityRegisterCheckerResponse cAns = personChecker.checkPerson(children.get(i));
            }

            for (Iterator<Child> it = children.iterator(); it.hasNext(); ) {
                Child child = it.next();
                CityRegisterCheckerResponse cAns = personChecker.checkPerson(child);
            }

            for (Child child : children) {
                CityRegisterCheckerResponse cAns = personChecker.checkPerson(child);
            }
        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
