package com.midhun.calculation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculationViewModel :ViewModel() {
    private val interSectionResult:MutableLiveData<String> = MutableLiveData()
    private val unionResult:MutableLiveData<String> =MutableLiveData()
    private val highestNumberResult:MutableLiveData<String> = MutableLiveData()

    fun calculateInterSection(input1:String,input2:String,input3:String):MutableLiveData<String>{
        val numbers1 = input1.split(",").map { it.trim().toInt() }
        val numbers2 = input2.split(",").map { it.trim().toInt() }
        val numbers3 = input3.split(",").map { it.trim().toInt() }

        val intersection = numbers1.intersect(numbers2.toSet()).intersect(numbers3.toSet())

        interSectionResult.postValue(intersection.toString())

        return interSectionResult
    }

    fun calculateUnion(input1:String,input2:String,input3:String):MutableLiveData<String> {
        val numbers1 = input1.split(",").map { it.trim().toInt() }
        val numbers2 = input2.split(",").map { it.trim().toInt() }
        val numbers3 = input3.split(",").map { it.trim().toInt() }

        val union = (numbers1 + numbers2 + numbers3).distinct().sorted()

        unionResult.postValue(union.toString())

        return unionResult
    }

    fun calculateHighestNumber(input1:String,input2:String,input3:String):MutableLiveData<String> {
        val numbers1 = input1.split(",").map { it.trim().toInt() }
        val numbers2 = input2.split(",").map { it.trim().toInt() }
        val numbers3 = input3.split(",").map { it.trim().toInt() }
        val highestNumber = listOf(numbers1.maxOrNull(), numbers2.maxOrNull(), numbers3.maxOrNull())


        highestNumberResult.postValue(findMaxNumber(highestNumber).toString())

        return highestNumberResult
    }

    private fun findMaxNumber(numbers: List<Int?>): Int? {
        if (numbers.isEmpty()) return null

        var maxNumber = numbers[0]
        for (number in numbers) {
            if (number != null) {
                if (number > maxNumber!!) {
                    maxNumber = number
                }
            }
        }
        return maxNumber
    }


}