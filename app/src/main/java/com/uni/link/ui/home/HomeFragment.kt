package com.uni.link.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uni.link.MainActivity
import com.uni.link.databinding.FragmentHomeBinding
import com.uni.link.ui.dashboard.AppFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // TODO
        binding.cardIssues.setOnClickListener {
//            DynamicToast.makeWarning(context!!, "Developing").show()
            val intent = Intent(context, MainActivity::class.java)
//            intent.putExtra(AppConfig.LOGIN, sharedPreferences.getString(LOGIN, "User"))
            intent.putExtra("PAGE", "Issues")
            startActivity(intent)
        }

        // TODO
        binding.cardPullRequest.setOnClickListener {
//            DynamicToast.makeWarning(context!!, "Developing").show()
            val intent = Intent(context, MainActivity::class.java)
//            intent.putExtra(AppConfig.LOGIN, sharedPreferences.getString(LOGIN, "User"))
            intent.putExtra("PAGE", "Pull Requests")
            startActivity(intent)
        }

        binding.cardRepo.setOnClickListener {

//            DynamicToast.makeWarning(context!!, "Developing").show()
            val intent = Intent(context, MainActivity::class.java)
//            intent.putExtra(AppConfig.LOGIN, sharedPreferences.getString(LOGIN, "User"))
//            intent.putExtra("USER_TYPE", "me")
            startActivity(intent)

        }

        binding.cardOrganizations.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
//            DynamicToast.makeWarning(context!!, "Developing").show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}