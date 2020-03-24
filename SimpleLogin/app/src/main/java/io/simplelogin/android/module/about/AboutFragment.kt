package io.simplelogin.android.module.about

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.simplelogin.android.databinding.FragmentAboutBinding
import io.simplelogin.android.module.home.HomeActivity
import io.simplelogin.android.utils.baseclass.BaseFragment
import io.simplelogin.android.utils.extension.getVersionName

class AboutFragment : BaseFragment(), HomeActivity.OnBackPressed {
    private lateinit var binding: FragmentAboutBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater)
        binding.toolbar.setNavigationOnClickListener { showLeftMenu() }

        binding.appVersionTextView.text = "SimpleLogin v${context?.getVersionName()}"
        binding.howTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToHowItWorksFragment()
            )
        }

        binding.contactTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hi@simplelogin.io"))
            activity?.startActivity(intent)
        }

        val base_url = "https://simplelogin.io"
        binding.faqTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToFaqFragment()
            )
        }
        binding.teamTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/about")
            )
        }

        binding.pricingTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/pricing")
            )
        }

        binding.blogTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/blog")
            )
        }

        binding.termsTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/terms")
            )
        }

        binding.privacyTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/privacy")
            )
        }

        return binding.root
    }

    // HomeActivity.OnBackPressed
    override fun onBackPressed() = showLeftMenu()
}