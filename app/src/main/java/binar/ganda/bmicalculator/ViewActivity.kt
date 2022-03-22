package binar.ganda.bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val dataBMI = intent.getParcelableExtra("data_bmi") as BMI?
        val berat = dataBMI?.bb
        val tinggi = dataBMI?.tb

        val tinggikuadrat = tinggi?.times(tinggi)?.toDouble()?.div(10000)
        val result = tinggikuadrat?.let { berat?.div(it) }

        val category =
            if (result == null) {
                "Failed"
            } else {
                when {
                    result >= 27 -> { "Obesitas" }
                    result in 25.1..27.0 -> { "Gemuk" }
                    result in 18.5..25.0 -> { "Normal/Ideal"}
                    result in 17.0..18.4 -> { "Kurus" }
                    else -> { "Terlalu Kurus" }
                }


        }

        bb_tv.text = "BB    : $berat kg"
        tb_tv.text = "TB    : $tinggi cm"
        category_tv.text = "Category    : $category "





    }
}