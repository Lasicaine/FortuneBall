package fi.suomaafrontieroy.fortuneball

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.Random
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.support.v7.widget.Toolbar

import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo


class MainActivity : AppCompatActivity() {

    private lateinit var fortuneText: TextView
    private lateinit var fortuneBallImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fortuneList = resources.getStringArray(R.array.fortune_messages)

        fortuneText = findViewById<View>(R.id.fortuneText) as TextView
        fortuneBallImage = findViewById<View>(R.id.fortunateImage) as ImageView

        fortuneBallImage.setOnClickListener {

            val index = Random().nextInt(fortuneList.size)
            fortuneText.setText(fortuneList[index])

            YoYo.with(Techniques.Swing)
                    .duration(500)
                    .playOn(fortuneBallImage)

            YoYo.with(Techniques.FadeIn)
                    .duration(2500)
                    .playOn(fortuneText)
        }
    }
}