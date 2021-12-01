package com.example.dalfonso.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)
        val nameAutorEditText : EditText = findViewById(R.id.name_autor_edit_text)
        val pagesEditText : EditText = findViewById(R.id.pages_edit_text)
        val abstractEditext : EditText = findViewById(R.id.abstract_edit_text)
        val saveButton : Button = findViewById(R.id.save_button)
        val infoTextView : TextView = findViewById(R.id.info_text_view)

        saveButton.setOnClickListener {
            val nameBook : String = nameBookEditText.text.toString()
            val nameAutor : String = nameAutorEditText.text.toString()
            val namePages : String = pagesEditText.text.toString()
            val nameAbstract : String = abstractEditext.text.toString()
            val respuesta = nameBook +", es una obra del autor: " + nameAutor + " con un numero de paginas de: " + namePages + " y se resumen asi: \n" + nameAbstract
            infoTextView.text = respuesta

        }
    }

}