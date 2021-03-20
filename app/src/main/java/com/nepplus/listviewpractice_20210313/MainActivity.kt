package com.nepplus.listviewpractice_20210313

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nepplus.listviewpractice_20210313.adaptors.StudentAdaptor
import com.nepplus.listviewpractice_20210313.datas.Student
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

//    학생 목록을 담아둘 ArrayList 변수 추가.
    val mStudentList = ArrayList<Student>()

//    xml + 데이터를 조합해서 뿌려주는 Adapter 변수 추가
//    변수는 미리 만들고 싶은데, 대입은 나중에 해야하는 상황
    lateinit var mAdaptor: StudentAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        학생 목록을 실제로 추가


        mStudentList.add(Student("에르난데스", 1988, "이탈리아 로마"))
        mStudentList.add(Student("파블로", 1995, "이탈리아 밀라노"))
        mStudentList.add(Student("안드리", 1990, "이탈리아 토리노"))
        mStudentList.add(Student("클라우디오", 1991, "이탈리아 피렌체"))
        mStudentList.add(Student("조르지오", 1993, "이탈리아 아탈란타"))

//      미뤄뒀던 mAdapter의 대입 진행

        mAdaptor = StudentAdaptor(this, R.layout.student_list_item, mStudentList)

//      완성된 어댑터 변수를 리스트 뷰와 연결

        studentListView.adapter = mAdaptor

//      학생 리스트뷰의 클릭 이벤트 구현

        studentListView.setOnItemClickListener { parent, view, position, id ->

//      position : 몇 번 줄이 눌렀는지 알려주는 역할

//        클릭 된 학생의 이름을 토스트로 출력

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

//        리스트뷰 아이템 길게 눌렀을 때 별도 처리

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "$(clickedStudent.name) 길게 눌림", Toast.LENGTH_SHORT).show()


            return@setOnItemLongClickListener true
        }
    }
}