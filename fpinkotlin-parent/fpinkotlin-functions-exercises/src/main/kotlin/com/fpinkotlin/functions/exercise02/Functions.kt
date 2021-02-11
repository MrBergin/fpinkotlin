package com.fpinkotlin.functions.exercise02


fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

// Define a generic compose. The exercise dos not consist in writing the implementation, but the signature.
fun <Input, Middle, Output> compose(f: (Middle) -> Output, g: (Input) -> Middle): (Input) -> Output = {
    f(g(it))
}