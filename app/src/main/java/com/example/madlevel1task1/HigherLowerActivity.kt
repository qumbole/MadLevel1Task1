package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding;

    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root) // Sets the activity layout resource file.
        initViews()


        //when user clicks on the button the image change and number change


    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        updateUI()

        binding.BtnLower.setOnClickListener{
            onLowerClick()
        }
        binding.BtnEquall.setOnClickListener{
            onEqualClick()
        }
        binding.BtnHigher.setOnClickListener{
            onHigherClick()
        }
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        binding.tvLastThrow.text = getString(R.string.last_throw, lastThrow)
        binding.tvCurrentThrow.text = getString(R.string.current_throw, currentThrow)

        when(currentThrow){
            1-> dice_imageView.setImageResource(R.drawable.dice1);
            2-> dice_imageView.setImageResource(R.drawable.dice2);
            3-> dice_imageView.setImageResource(R.drawable.dice3);
            4-> dice_imageView.setImageResource(R.drawable.dice4);
            5-> dice_imageView.setImageResource(R.drawable.dice5);
            6-> dice_imageView.setImageResource(R.drawable.dice6);
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow;
        currentThrow = (1..6).random();
        updateUI();

    }

    private fun onHigherClick() {
        rollDice()
        when (currentThrow > lastThrow) {
            true -> onAnswerCorrect()
            else -> onAnswerIncorrect()
        }

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        when (currentThrow < lastThrow) {
            true -> onAnswerCorrect()
            else -> onAnswerIncorrect()
        }

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        when (currentThrow == lastThrow) {
            true -> onAnswerCorrect()
            else -> onAnswerIncorrect()
        }

    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }
}









