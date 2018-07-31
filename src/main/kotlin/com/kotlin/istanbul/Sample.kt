package com.kotlin.istanbul


fun printDividedNums() {
    val numbers = 1..100
    numbers.forEach {
        when (it) {
            it % 5 -> {
                println("Divided to 5")
                return@forEach
            }
            else -> {
                println("Cant divide to 5")
                return@forEach
            }
        }
    }
    print("Fnished")
}

fun main(args: Array<String>) {
    //   printDividedNums()
    println(factorial(0))
    println(factorialTR(0))

}


tailrec fun factorial(number: Int): Int {
    when (number) {
        1, 0 -> return 1
        else -> return number * factorial(number - 1)
    }
}

tailrec fun factorialTR(number: Int, accumulator: Int = 1): Int {
    when (number) {
        0 -> return accumulator
        else -> return factorialTR(number - 1, accumulator * number)
    }
}


fun count(arr: IntArray, value: Int = 0, counter: Int = 0): Int {
    var counter = counter
    if (arr[value] == -1)
        return ++counter
    else if (arr[value] > arr.size - 1 || arr[value] == value)
        return counter
    return count(arr, arr[value], ++counter)
}
