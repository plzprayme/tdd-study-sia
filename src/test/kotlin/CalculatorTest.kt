import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest: FunSpec({
    val calculator = Calculator()

    test("1 + 2는 3이다") {
        val result = calculator.plus(1, 2)
        result shouldBe 3
    }

    test("1 + 4는 5이다") {
        val result = calculator.plus(1, 2)
        result shouldBe 3
    }

})