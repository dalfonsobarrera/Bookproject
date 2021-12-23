package com.example.dalfonso.bookproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dalfonso.bookproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        // val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)

        var numero : Int? = null

        numero = null

        with(mainBinding) {
            saveButton.setOnClickListener {

                if (nameBookEditText.text.isEmpty() ||
                    nameAuthorEditText.text.isEmpty() ||
                        pagesEditText.text?.isEmpty() == true
                ) {
                    Toast.makeText(
                        applicationContext,"Debe digitar nombre, autor y número de páginas",
                        Toast.LENGTH_LONG).show()
                }   else{

                val nameBook: String = nameBookEditText.text.toString()
                val author = nameAuthorEditText.text.toString()
                val pages = pagesEditText.text .toString().toInt()
                val abstract = abstractEditText.text.toString()

                infoTextView.text = getString(R.string.info,nameBook, author, pages, abstract)
                }
            }

        }
    }

}