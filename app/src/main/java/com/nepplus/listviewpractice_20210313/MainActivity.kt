package com.nepplus.listviewpractice_20210313

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.listviewpractice_20210313.datas.Student
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

//    학생 목록을 담아둘 ArrayList 변수 추가.
    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        학생 목록을 실제로 추가

        mStudentList.add(Student("에르난데스", 1988))
        mStudentList.add(Student("파블로", 1995))
        mStudentList.add(Student("안드리", 1990))
        mStudentList.add(Student("클라우디오", 1991))
        mStudentList.add(Student("조르지오", 1993))
    }
}