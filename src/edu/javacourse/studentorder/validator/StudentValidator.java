package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {
    public AnswerStudent checkStudent(StudentOrder so) {
        AnswerStudent ans = new AnswerStudent();
        ans.success = true;
        return ans;
    }
}
