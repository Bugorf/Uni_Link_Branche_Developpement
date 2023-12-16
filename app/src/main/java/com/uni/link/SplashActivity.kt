package eu.mobeepass.nfcniceticket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uni.link.MainActivity
import java.util.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding1:   // Utilisation du nom correct pour le binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivitySplashBinding.inflate(layoutInflater) // Utilisation du inflate de la classe générée par le binding
        setContentView(binding1.root)

        val mTimer = Timer()
        val mTimeTask: TimerTask = object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        mTimer.schedule(mTimeTask, 1000)
    }
}
