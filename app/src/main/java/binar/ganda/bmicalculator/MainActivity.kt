package binar.ganda.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        parsingBMI()
    }

    private fun parsingBMI() {
        btn_count.setOnClickListener {
            val berat = et_bb.text.toString().toInt()
            val tinggi = et_tb.text.toString().toInt()
            val proceed = Intent(this, ViewActivity::class.java)
            val bmi = BMI (berat,tinggi)
            proceed.putExtra("data_bmi", bmi)
            startActivity(proceed)

        }

    }
}