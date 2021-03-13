package com.nepplus.listviewpractice_20210313.adaptors

import android.content.Context
import android.widget.ArrayAdapter
import com.nepplus.listviewpractice_20210313.datas.Student


class StudentAdaptor(val mContext : Context,
                     val resId : Int,
                     val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList){
}