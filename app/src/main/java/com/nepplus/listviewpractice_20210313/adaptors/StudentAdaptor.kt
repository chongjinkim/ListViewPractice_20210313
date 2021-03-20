package com.nepplus.listviewpractice_20210313.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.nepplus.listviewpractice_20210313.datas.Student


class StudentAdaptor(
      val mContext : Context,//어떤 화면에서 쓸것인가
      val resId : Int,
      val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList){

//xml -> 코틀린 변수로 꺼내오도록 도와주는 클래스(LayoutFlater)
        val inflater = LayoutInflater.from(mContext)


}