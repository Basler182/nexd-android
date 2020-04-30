package app.nexd.android.ui.auth.register

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import app.nexd.android.R
import app.nexd.android.databinding.FragmentRegisterBinding
import app.nexd.android.ui.auth.register.RegisterFragmentDirections.Companion.toRegisterDetailedFragment
import app.nexd.android.ui.auth.register.RegisterViewModel.Progress.*
import app.nexd.android.ui.common.Constants
import app.nexd.android.ui.common.DefaultSnackbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterFragment : Fragment() {

    private val vm: RegisterViewModel by viewModel()

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        register_toolbar.setupWithNavController(findNavController())

        editText_password_confirm.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                vm.register()
            }
            false
        }

        checkbox_data_protection.text = context?.getString(
            R.string.registration_label_privacy_policy_agreement_android,
            context?.getString(R.string.registration_term_privacy_policy)
        )

        button_register.setOnClickListener {
            vm.register()
        }

        vm.progress.observe(viewLifecycleOwner, Observer { progress ->
            progressBar.visibility = View.GONE

            when (progress) {
                is Idle -> { /* nothing to do here */
                }
                is Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Error -> {
                    progress.message?.let { message ->
                        DefaultSnackbar(view, message, Snackbar.LENGTH_SHORT)
                    }
                }
                is Finished -> {
                    findNavController().navigate(toRegisterDetailedFragment())
                }
            }
        })

        button_dataProtection.setOnClickListener {
            showPrivacyPolicy()
        }
    }

    private fun showPrivacyPolicy() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(Constants.PRIVACY_POLICY_URL)
            )
        )
    }

}
