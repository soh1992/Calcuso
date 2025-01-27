package com.example.Calcuso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val editable = Editable.Factory()

    var count = 0

    private var characterDisplay = ArrayList<String>()

    private val numOperator = ArrayList<String>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClean.setOnClickListener {

            characterDisplay.clear()
            val text = editable.newEditable("")
            binding.edtDisplay.text = text

        }

        binding.btnEqual.setOnClickListener {

            noAccessFirst("=")

        }

        binding.btn0.setOnClickListener { showCharList("0") }

        binding.btn1.setOnClickListener { showCharList("1") }

        binding.btn2.setOnClickListener { showCharList("2") }

        binding.btn3.setOnClickListener { showCharList("3") }

        binding.btn4.setOnClickListener { showCharList("4") }

        binding.btn5.setOnClickListener { showCharList("5") }

        binding.btn6.setOnClickListener { showCharList("6") }

        binding.btn7.setOnClickListener { showCharList("7") }

        binding.btn8.setOnClickListener { showCharList("8") }

        binding.btn9.setOnClickListener { showCharList("9") }

        binding.btnPlus.setOnClickListener {

            noAccessFirst("+")

        }

        binding.btnMines.setOnClickListener {

            noAccessFirst("-")
        }

        binding.btnCompose.setOnClickListener {

            noAccessFirst("*")
        }

        binding.btnDivide.setOnClickListener {

            noAccessFirst("/")
        }
    }

    private fun showCharList(s: String) {

        characterDisplay.add(s)

        var sequence = ""

        for (i in 0 until characterDisplay.size) {

            sequence += characterDisplay[i]

        }

        val text = editable.newEditable(sequence)
        binding.edtDisplay.text = text

    }

    private fun noRepeat(s: String) {

        if (characterDisplay[characterDisplay.lastIndex] == "+" ||
            characterDisplay[characterDisplay.lastIndex] == "-" ||
            characterDisplay[characterDisplay.lastIndex] == "*" ||
            characterDisplay[characterDisplay.lastIndex] == "/"
        ) {

            if (s == "+" || s == "-" || s == "*" || s == "/") {

                characterDisplay.removeLast()

                showCharList(s)

            }
        }

        else
            showCharList(s)

    }

    private fun noAccessFirst(s : String){

        if(characterDisplay.isEmpty()){

            binding.btnPlus.isEnabled == false

        }

        else
            noRepeat(s)

    }

    private fun finalCalculate(){



    }


}
