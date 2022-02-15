import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.mylibrary.*
import com.mylibrary.databinding.FragmentLoginBinding

open class LoginFragment() : Fragment() {

    companion object {

        private val TAG = LoginFragment::class.java.simpleName

        lateinit var act: MainActivity

        lateinit var fragment: LoginFragment


        @JvmStatic
        fun newInstance(act: MainActivity): LoginFragment {

            fragment = LoginFragment()

            LoginFragment.act = act

            return fragment as LoginFragment

        }

    }

    var mSessionManager: SessionManager? = null

    var languageSessionManager: LanguageSessionManager? = null

    lateinit var binding: FragmentLoginBinding

    var loginId = ""
    var password = ""


    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("Entered Login !!!====<>>>>>")

        if (act == null) {

            act = requireActivity() as MainActivity

        }

        try {

            mSessionManager = SessionManager(act!!)

            languageSessionManager = LanguageSessionManager(act!!)

        } catch (e: Exception) {

            Log.e(
                TAG + " onCreateLine>>LineNumber: " +
                        Thread.currentThread().stackTrace[2].lineNumber, e.message.toString()
            )

        }
    }


    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        try {

            binding = FragmentLoginBinding.inflate(inflater, container, false)

            initViews()

        } catch (e: Exception) {

            Log.e(
                TAG + " onCreateLine>>LineNumber: " +
                        Thread.currentThread().stackTrace[2].lineNumber, e.message.toString()
            )

        }

        return binding.root
    }


    open fun initViews() {

        MainActivity.setTextFonts(binding.root)

    }


    override fun onStart() {
        super.onStart()

        if (packageId==1) {
            binding.tvWelcome.text = "Welcome Mr Customer"
        } else{
            binding.tvWelcome.text = "Welcome Mr Vendor"
        }
        binding.tvLogin.setOnClickListener { println("Login Id entered = ${binding.etMobile.text} ===>> Password entered = ${binding.etPassword.text}")
        }

        binding.tvRegister.setOnClickListener { loginId = binding.etMobile.text.toString()

            password = binding.etPassword.text.toString()

            println("Login Id entered = $loginId ===>> Password entered = $password") }
    }

}