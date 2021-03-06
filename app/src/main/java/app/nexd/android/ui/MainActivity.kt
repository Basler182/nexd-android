package app.nexd.android.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import app.nexd.android.R
import io.reactivex.plugins.RxJavaPlugins

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxJavaPlugins.setErrorHandler {
            Log.e(MainActivity::class.simpleName, "unhandled error", it)
        }

        hideKeyboardOnTouch()
    }

    /**
     * hides keyboard if no editText was touched
     */
    private fun hideKeyboardOnTouch() {
        hideKeyboardOnTouch(findViewById(R.id.nav_host_fragment))
    }

    /**
     * hides keyboard on given view if no editText was clicked
     * @param view listener on this view
     */
    private fun hideKeyboardOnTouch(view: View) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                hideKeyboard()
                view.performClick()
                false
            }
        }

        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                hideKeyboardOnTouch(innerView)
            }
        }
    }

    /**hides keyboard */
    private fun hideKeyboard() {
        if (currentFocus != null) {
            (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                currentFocus!!.windowToken,
                0
            )
            currentFocus!!.clearFocus()
        }
    }
}
