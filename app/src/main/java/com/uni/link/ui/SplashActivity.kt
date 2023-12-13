import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.activity_splash.*
import com.uni.link.R

class SplashActivity : AppCompatActivity() {

    private val logos = listOf(
        R.drawable.book1,
        R.drawable.book2,
        R.drawable.football,
        R.drawable.basketball,
        R.drawable.tennisball
    )

    private var currentLogoIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Load the first logo and apply a transition effect
        Glide.with(this)
            .load(logos[currentLogoIndex])
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(splash_image)

        // Start a handler to update the logo every second
        Handler().postDelayed({
            updateLogo()
        }, 1000)
    }

    private fun updateLogo() {
        currentLogoIndex = (currentLogoIndex + 1) % logos.size
        Glide.with(this)
            .load(logos[currentLogoIndex])
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(splash_image)

        // Update the logo every second
        Handler().postDelayed({
            updateLogo()
        }, 1000)
    }
}