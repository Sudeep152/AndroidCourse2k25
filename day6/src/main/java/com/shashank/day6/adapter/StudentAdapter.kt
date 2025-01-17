package com.shashank.day6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.shashank.day6.Student
import com.shashank.day6.databinding.ItemStudentBinding

class StudentAdapter(private val studentList : List<Student>,private val listener: OnItemClickListener): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList)
    }

    inner class StudentViewHolder(binding: ItemStudentBinding) : ViewHolder(binding.root) {
        private val mBinding = binding
       fun bind(studentList: List<Student>){
           mBinding.apply {
               tvName.text = studentList[adapterPosition].name
               tvEmail.text = studentList[adapterPosition].email
               llMain.setOnClickListener {
                   listener.onItemClick(studentList[adapterPosition],adapterPosition)
               }
           }
       }
    }

    interface  OnItemClickListener{
        fun onItemClick(student: Student,position: Int)
    }
}