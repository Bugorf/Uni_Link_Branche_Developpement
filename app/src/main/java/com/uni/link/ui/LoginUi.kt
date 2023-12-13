import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uni.link.R
import com.uni.link.ui.ForgotPasswordActivity

class LoginActivity : AppCompatActivity() {

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button
    lateinit var forgotPasswordTextView: TextView
    lateinit var rememberMeCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView)
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Faire une requête à votre serveur pour vérifier les identifiants
            // Si les identifiants sont corrects, naviguer vers l'activité principale
        }

        forgotPasswordTextView.setOnClickListener {
            // Lancer l'activité de récupération de mot de passe
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
}