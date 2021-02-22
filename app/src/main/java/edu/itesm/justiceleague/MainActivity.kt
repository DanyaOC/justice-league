package edu.itesm.justiceleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val justiceleague = mutableListOf<Superhero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                button.text = p0.toString()
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }

    fun save(view: View){
        var superhero = Superhero(editTextTextPersonName.text.toString())
        superhero.phone = editTextPhone.text.toString()
        superhero.email = editTextTextEmailAddress.text.toString()
        superhero.age = editTextNumberSigned.text.toString().toInt()

        justiceleague.add(superhero)
        Log.i("edu.itesm.justiceleague", justiceleague.toString())
        Log.i("edu.itesm.justiceleague", justiceleague.sumBy { it.age }.toString())

    }
}