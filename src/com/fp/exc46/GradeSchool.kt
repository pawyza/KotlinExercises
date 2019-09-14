package com.fp.exc46

import java.lang.StringBuilder

object GradeSchool {

    private val gradeList = mutableMapOf<Int, MutableList<String>>()

    fun showAllGrades(): String = "Currently school has ${if(gradeList.size == 0) "no" else gradeList.size.toString()} grades"

    fun showAllStudents(grade: Int?): String {
        return if (grade == null) "Currently schools students are:\n ${if(!gradeList.isEmpty()) gradeList.map {if(!it.value.isEmpty()) it.value.sortedBy{it}.map {it}.joinToString(", ").plus(" in grade ${it.key}") else "No students in grade ${it.key}"}.joinToString("\n") else "No students"}"
        else "Currently in grade $grade are students: ${if(gradeList[grade] != null) gradeList[grade]!!.sortedBy{it}.map {it}.joinToString(", ") else "There are no students"}"
    }

    fun addGrade(grade: Int, students: List<String>?) {
        if (students != null) {
            gradeList.put(grade, students as MutableList<String>)
        } else gradeList.put(grade, mutableListOf<String>())
    }

    fun addStudent(grade: Int, student: String) {
        gradeList[grade]!!.add(student)
    }
}