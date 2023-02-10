package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sum: String = ""
    private var results = 0
    private var flag = ""
    private var exception_zero = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //digits
        binding.zero.setOnClickListener{
            sum += 0
            binding.wynik.text = sum.toString()
            exception_zero = "zero"
        }

        binding.one.setOnClickListener{
            sum += 1
            binding.wynik.text = sum.toString()
        }

        binding.two.setOnClickListener{
            sum += 2
            binding.wynik.text = sum.toString()
        }

        binding.three.setOnClickListener{
            sum += 3
            binding.wynik.text = sum.toString()
        }

        binding.four.setOnClickListener{
            sum += 4
            binding.wynik.text = sum.toString()
        }

        binding.five.setOnClickListener{
            sum += 5
            binding.wynik.text = sum.toString()
        }
        binding.six.setOnClickListener{
            sum += 6
            binding.wynik.text = sum.toString()
        }

        binding.seven.setOnClickListener{
            sum += 7
            binding.wynik.text = sum.toString()
        }

        binding.eight.setOnClickListener{
            sum += 8
            binding.wynik.text = sum.toString()
        }

        binding.nine.setOnClickListener{
            sum += 9
            binding.wynik.text = sum.toString()
        }

        //Addition
        binding.addition.setOnClickListener{
            if (sum != "")
            {
                results += sum.toInt()
                sum = ""
                flag = "add"
            } else {
                flag = "add"
            }
        }

        //Subtraction
        binding.minus.setOnClickListener{
            if (sum != "" && (results !=0 || exception_zero == "zero"))
            {
                results -= sum.toInt()
                binding.wynik.text = sum.toString()
                sum = ""
                flag = "minus"
            } else if (sum != "" && results ==0){
                results += sum.toInt()
                sum = ""
                flag = "minus"
            }
            else {
                flag = "minus"
            }
        }

        //Divide
        binding.divide.setOnClickListener{
            if (sum != "" && results != 0)
            {
                results /= sum.toInt()
                sum = ""
                flag = "divide"
            } else if (sum != "" && results == 0){
                results += sum.toInt()
                flag = "divide"
                sum = ""
            }
            else if (sum != "" && results !=0 && exception_zero == "zero"){
                results /= sum.toInt()
                sum = ""
                flag = "divide"
                exception_zero = ""
            }
            else {
                flag = "divide"
            }
        }

        //Multiplication
        binding.multiplication.setOnClickListener{
            if (sum != "" && results != 0)
            {
                results *= sum.toInt()
                sum = ""
                flag = "multiplication"
            }else if (sum != "" && results == 0){
                results += sum.toInt()
                sum = ""
                flag = "multiplication"
            }
            else if (sum != "" && results !=0 && exception_zero == "zero") {
                results /= sum.toInt()
                sum = ""
                flag = "multiplcation"
            } else {
                flag = "multiplication"
            }
        }

        //AC - auto clean
        binding.AC.setOnClickListener{
            sum = ""
            results = 0
            binding.wynik.text = results.toString()
        }

        //Equal button
        binding.equal.setOnClickListener{
            when (flag){
                "add" -> {
                    results += sum.toInt()
                    sum = ""
                }
                "minus" -> {
                    results -= sum.toInt()
                    sum = ""
                }
                "divide" -> {
                    results /= sum.toInt()
                    sum = ""
                }
                "multiplication" -> {
                    results *= sum.toInt()
                    sum = ""
                }
                "" -> {
                    results = sum.toInt()
                    sum = ""
                }
            }
            binding.wynik.text = results.toString()
        }
    }
}