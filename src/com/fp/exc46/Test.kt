package com.fp.exc46

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na napisaniu programu umozliwiajacego dodawanie klas do szkoly oraz uczniow do samych klas
class Test{

    @Test
    fun schoolGradeBasicsTest(){
        Assertions.assertEquals("Currently school has no grades",GradeSchool.showAllGrades())
        Assertions.assertEquals("Currently schools students are:\n" +
                " No students",GradeSchool.showAllStudents(null))
        Assertions.assertEquals("Currently in grade 1 are students: There are no students",GradeSchool.showAllStudents(1))
        GradeSchool.addGrade(2,null)
        GradeSchool.addGrade(1, listOf("Jan","Barbara"))
        Assertions.assertEquals("Currently school has 2 grades",GradeSchool.showAllGrades())
        Assertions.assertEquals("Currently schools students are:\n" +
                " No students in grade 2\n" +
                "Barbara, Jan in grade 1",GradeSchool.showAllStudents(null))
        Assertions.assertEquals("Currently in grade 1 are students: Barbara, Jan",GradeSchool.showAllStudents(1))
        Assertions.assertEquals("Currently in grade 2 are students: ",GradeSchool.showAllStudents(2))
        GradeSchool.addGrade(3,null)
        GradeSchool.addStudent(3,"Jan")
        GradeSchool.addStudent(3,"Barbara")
        Assertions.assertEquals("Currently in grade 3 are students: Barbara, Jan",GradeSchool.showAllStudents(3))
    }
}