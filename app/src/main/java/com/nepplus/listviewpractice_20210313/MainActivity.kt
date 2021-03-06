package com.nepplus.listviewpractice_20210313

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
//            우선 경고(확인) 창 띄워보자 => 확인이 눌렀을 때 삭제 진행
            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제")
            alert.setMessage("정말 학생을 삭제하시겠습니까")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
//                     확인 버튼이 눌렀을 때 실행 해줄 일
//                학생 삭제는 이 때 진행
                mStudentList.removeAt(position)

                mAdaptor.notifyDataSetChanged()

            })

            alert.setNegativeButton("취소", null)

            alert.show()

// 롱클릭된 학생 목록에서 삭제

            mStudentList.removeAt(position)

//            어댑터가 이름 확인(새로고침) 하도록

            mAdaptor.notifyDataSetChanged()

            return@setOnItemLongClickListener true
        }
    }
}