package com.example.registerform

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateSelect: Button = findViewById(R.id.dateSelect)
        dateSelect.setOnClickListener { showDateSelect() }

        val registerButton: Button = findViewById(R.id.register)
        registerButton.setOnClickListener { checkRegister() }
    }

    private fun showDateSelect() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            val birthday: EditText = findViewById(R.id.editBirthday)
            birthday.setText(selectedDate)
        }, year, month, day)
        datePickerDialog.show()
    }

    private fun checkRegister() {
        val firstName: EditText = findViewById(R.id.firstName)
        val lastName: EditText = findViewById(R.id.lastName)
        val birthday: EditText = findViewById(R.id.editBirthday)
        val address: EditText = findViewById(R.id.editAddress)
        val email: EditText = findViewById(R.id.editEmail)
        val agree: CheckBox = findViewById(R.id.agree)
        val gender: RadioGroup = findViewById(R.id.gender)

        if (firstName.text.toString() == "" ||
            lastName.text.toString() == "" ||
            gender.checkedRadioButtonId == -1 ||
            birthday.text.toString() == "" ||
            address.text.toString() == "" ||
            email.text.toString() == "" ||
            !agree.isChecked) {
            val toast = Toast.makeText(this, "Required information has not been filled in", Toast.LENGTH_SHORT)
            toast.show()
        }
        else {
            val toast = Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}