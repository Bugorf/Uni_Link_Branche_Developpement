package eu.mobeepass.nfcniceticket

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uni.link.MainActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_content)
        val mTimer = Timer()
        val mTimeTask: TimerTask = object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        mTimer.schedule(mTimeTask, 1500)
    }
}