package com.shashank.day6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashank.day6.adapter.StudentAdapter
import com.shashank.day6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), StudentAdapter.OnItemClickListener {
    private var mainBinding: ActivityMainBinding? = null
    private var mAdapter  : StudentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)
//        mainBinding?.button?.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:+1245")
//            startActivity(intent)
//        }
        // For List VIew
//        val adapter  = ArrayAdapter(this, R.layout.simple_list_item_1, getDummyList())
//        mainBinding?.listview?.adapter = adapter


        // For RecyclerView
        mAdapter = StudentAdapter(getDummyStudentData(),this@MainActivity)
        mainBinding?.listview?.layoutManager = LinearLayoutManager(this)
        mainBinding?.listview?.adapter = mAdapter

    }

    override fun onItemClick(student: Student, position: Int) {
        Toast.makeText(this, "${student.name}", Toast.LENGTH_SHORT).show()
    }
}


fun getDummyStudentData(): List<Student> {
    val students = mutableListOf<Student>()
    for (i in 1..20) {
        students.add(
            Student(
                name = "Student $i",
                email = "student$i@example.com"
            )
        )
    }
    return students
}

data class Student(
    val name:String? = null,
    val email:String? = null
)