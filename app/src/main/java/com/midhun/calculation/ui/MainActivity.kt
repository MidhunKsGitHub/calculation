package com.midhun.calculation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.midhun.calculation.R
import com.midhun.calculation.databinding.ActivityMainBinding
import com.midhun.calculation.viewModel.CalculationViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var calculationViewModel: CalculationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculationViewModel = ViewModelProvider(this)[CalculationViewModel::class.java]
        binding.result.visibility=View.GONE

        binding.calculateButton.setOnClickListener {
            val input1 = binding.editText1.text.toString()
            val input2 = binding.editText2.text.toString()
            val input3 = binding.editText3.text.toString()
            getIntersection(input1, input2, input3)
            getUnion(input1, input2, input3)
            getHighest(input1, input2, input3)
            binding.result.visibility=View.VISIBLE

        }
    }

    private fun getIntersection(input1: String, input2: String, input3: String) {

        calculationViewModel.calculateInterSection(input1, input2, input3).observe(
            this
        ) { intersectionValue ->
            val intersection=getString(R.string.intersection)+intersectionValue
            binding.intersection.text = intersection
        }
    }

    private fun getUnion(input1: String, input2: String, input3: String) {

        calculationViewModel.calculateUnion(input1, input2, input3).observe(
            this
        ) { unionValue ->
            val union=getString(R.string.union)+unionValue
            binding.union.text = union

        }
    }

    private fun getHighest(input1: String, input2: String, input3: String) {

        calculationViewModel.calculateHighestNumber(input1, input2, input3).observe(
            this
        ) { highestValue ->
            val highest=getString(R.string.highest)+highestValue
            binding.highest.text = highest
        }
    }

}
