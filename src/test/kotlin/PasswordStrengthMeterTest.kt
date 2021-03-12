import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


// 대문자 포함
// 8글자 이상
// 0부터 9사이의 숫자 포함

// 3 - 강함 2 - 보통 1 - 약함
class PasswordStrengthMeterTest : FunSpec ({

    val meter = PasswordStrengthMeter()

    test("3가지 조건을 만족하면 비밀번호의 강도는 STRING이다.") {


        val result = meter.meter("ab12!@AB")
        result shouldBe PasswordStrength.STRONG

        val result1 = meter.meter("abc12!@Add")
        result1 shouldBe PasswordStrength.STRONG
    }

    test("길이만 9글자 미만이고 나머지 조건을 충족하면 NOMAL 이다.") {

        val result = meter.meter("ab12!@A")
        result shouldBe PasswordStrength.NOMAL
    }

    test("숫자를 포함하지 않고 나머지 조건을 충족하면 NOMAL이다.") {
        val result = meter.meter("abc!@AAqwe")
        result shouldBe PasswordStrength.NOMAL
    }

    test("값이 NULL이면 INVALID다.") {
        val result = meter.meter(null)
        result shouldBe PasswordStrength.INVALID
    }

    test("대문자를 포함하지 않고 나머지 경우를 충족하면 NOMAL이다.") {
        val result = meter.meter("ab12!@df")
        result shouldBe PasswordStrength.NOMAL
    }

    test("길이가 8글자 이상인 조건만 충족하면 WEAK다.") {
        val result = meter.meter("abcdefghi")
        result shouldBe PasswordStrength.WEAK
    }

    test("숫자 포함 조건만 충족하면 WEAK다.") {
        val result = meter.meter("1234")
        result shouldBe PasswordStrength.WEAK
    }

    test("대문자 포함 조건만 충족하면 WEAK다.") {
        val result = meter.meter("ABZEF")
        result shouldBe PasswordStrength.WEAK
    }

    test("아무 조건도 충족하지 않으면 WEAK 다.") {
        val result = meter.meter(" abc")
        result shouldBe PasswordStrength.WEAK
    }

})