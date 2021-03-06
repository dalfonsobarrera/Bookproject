package com.example.dalfonso.bookproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dalfonso.bookproject.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding
    private var cal = Calendar.getInstance()
    private var publicationDate= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        // val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_YEAR, dayOfMonth)

            val format = "MM/dd/yyyy"
            val simpleDateFormat = SimpleDateFormat(format, Locale.US)
            publicationDate = simpleDateFormat.format(cal.time).toString()
            mainBinding.publicationDateButton.text = publicationDate


        }

        with(mainBinding) {

            publicationDateButton.setOnClickListener {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

            saveButton.setOnClickListener {

                if (nameBookEditText.text.isEmpty()  ||
                    nameAuthorEditText.text.isEmpty()  ||
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

                    var genre = ""

                    if (suspenseCheckBox.isChecked) genre = " Suspenso "
                    if (terrorCheckBox.isChecked) genre += " Terror "
                    if (infantileCheckBox.isChecked) genre += " Infantil "
                    if (fictionCheckBox.isChecked) genre += " Ficción "

                    val score= when {
                        oneRadioButton.isChecked -> 1
                        twoRadioButton.isChecked -> 2
                        threeRadioButton.isChecked -> 3
                        fourRadioButton.isChecked -> 4
                        else -> 5
                    }





                    infoTextView.text = getString(R.string.info,nameBook, author, pages, abstract, genre, score, publicationDate)
                }
            }

        }
    }

}