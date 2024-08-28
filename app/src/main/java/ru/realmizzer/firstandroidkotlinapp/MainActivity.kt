package ru.realmizzer.firstandroidkotlinapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import ru.realmizzer.firstandroidkotlinapp.databinding.ActivityLearnWordBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityLearnWordBinding

    private var _binding: ActivityLearnWordBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.layoutAnswer2.setOnClickListener {
            markAnswerCorrect()
        }

        binding.layoutAnswer1.setOnClickListener {
            markAnswerWrong()
        }

        binding.btnContinue.setOnClickListener {
            markAnswerNeutral()
        }

        // findViewById
//        val tvQuestionWord = findViewById<TextView>(R.id.tvQuestionWord)
//        tvQuestionWord.text = "42"
//        tvQuestionWord.setTextColor(Color.BLUE)
//        tvQuestionWord.setTextColor(Color.parseColor("#FDD600"))
//        tvQuestionWord.setTextColor(ContextCompat.getColor(this, R.color.textVariantsColor))

        // ViewBinding
//        binding.tvQuestionWord.text = "Cosmos"
//        binding.tvQuestionWord.setTextColor(Color.BLUE)

//        with(binding) {
//            tvQuestionWord.text = "Space"
//            tvQuestionWord.setTextColor(Color.BLUE)
//        }
    }

    private fun markAnswerNeutral() {

        with(binding) {

            for (layout in listOf(layoutAnswer1, layoutAnswer2)) {
                layout.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_containers
                )
            }

            for (textView in listOf(tvVariantValue1, tvVariantValue2)) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.textVariantsColor
                    )
                )
            }

            for (textView in listOf(tvVariantNumber1, tvVariantNumber2)) {
                textView.apply {
                    background = ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.shape_rounded_variants
                    )
                    setTextColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.textVariantsColor
                        )
                    )
                }
            }

            layoutResult.visibility = View.GONE
            btnSkip.visibility = View.VISIBLE

        }

    }

    private fun markAnswerWrong() {

        // correct button styles
        binding.layoutAnswer1.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape_rounded_containers_wrong
        )

        binding.tvVariantNumber1.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )

        // Property Access Syntax
        binding.tvVariantNumber1.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape_rounded_variants_wrong
        )

        binding.tvVariantValue1.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.wrongAnswerColor
            )
        )

        // skip button
        binding.btnSkip.visibility = View.GONE

        // correctness section
        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.wrongAnswerColor
            )
        )

        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_wrong
            )
        )

        binding.tvResultMessage.text = resources.getText(R.string.title_wrong)

        binding.layoutResult.visibility = View.VISIBLE

        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.wrongAnswerColor
            )
        )

    }

    private fun markAnswerCorrect() {

        // correct button styles
        binding.layoutAnswer2.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape_rounded_containers_correct
        )

        binding.tvVariantNumber2.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )

        // Property Access Syntax
        binding.tvVariantNumber2.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape_rounded_variants_correct
        )

        binding.tvVariantValue2.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.correctAnswerColor
            )
        )

        // skip button
        binding.btnSkip.visibility = View.GONE

        // correctness section
        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.correctAnswerColor
            )
        )

        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_correct
            )
        )

        binding.tvResultMessage.text = resources.getText(R.string.title_correct)

        binding.layoutResult.visibility = View.VISIBLE

        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.correctAnswerColor
            )
        )

    }
}