package com.furkan.sqlitekotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE, null)

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age Int(2))")

            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Kirk',60)")

            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Lars',55)")

            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Rob',70)")

            //myDatabase.execSQL("UPDATE musicians SET age = 55 WHERE name = 'Lars'")


            //myDatabase.execSQL("DELETE FROM musicians  WHERE name = 'Lars'")


            val cursor = myDatabase.rawQuery("SELECT * FROM musicians",null)

            val nameIndex = cursor.getColumnIndex("name")
            val ageIndex = cursor.getColumnIndex("age")

            cursor.moveToFirst()

            while (cursor != null) {
                println("Name: "+cursor.getString(nameIndex))
                println("Age: "+cursor.getInt(ageIndex))

                cursor.moveToNext()
            }
            if (cursor != null){
                cursor!!.close()
            }




        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
