import kotlin.math.abs

fun main() {
    val f1 = Fraction(5,3)
    val f2 = Fraction(21,15)
    println(f1+f2)
    println(f1-f2)
    println(f1/f2)
    println(f1*f2)
    println(f1>f2)
    println(f1<f2)
    println(f1==f2)
}

data class Fraction(var numerator: Int, var denominator: Int) {
    init {
        val divisor = gcd(numerator, denominator)
        numerator /= divisor
        denominator /= divisor
    }

    operator fun plus(other: Fraction): Fraction {
        return Fraction(
            this.numerator * other.denominator + other.numerator * this.denominator,this.denominator * other.denominator
        )
    }

    operator fun minus(other: Fraction): Fraction {
        return Fraction(
            this.numerator * other.denominator - other.numerator * this.denominator,this.denominator * other.denominator
        )
    }

    operator fun times(other: Fraction): Fraction {
        return Fraction(this.numerator * other.numerator, this.denominator * other.denominator)
    }

    operator fun div(other: Fraction): Fraction {
        return Fraction(this.numerator * other.denominator, this.denominator * other.numerator)
    }

    operator fun compareTo(other: Fraction): Int {
        val dif = this.minus(other)
        return Math.signum(dif.numerator.toDouble() / dif.denominator.toDouble()).toInt()
    }

    override operator fun equals(other: Any?): Boolean {
        return other is Fraction && other.denominator == this.denominator && other.numerator == this.numerator
    }

}

fun gcd(n1: Int, n2: Int): Int{
    for(i in minOf(abs(n1),abs(n2))downTo 0){
        if(n1%i == 0 && n2%i == 0) return i
    }
    return 1
}