class PasswordStrengthMeter {
    fun meter(s: String?): PasswordStrength {
        if(s.isNullOrBlank()) return PasswordStrength.INVALID

        val metCount = getMetCriterialCounts(s)

        if (metCount <= 1) return PasswordStrength.WEAK
        if (metCount == 2) return PasswordStrength.NOMAL
        return PasswordStrength.STRONG
    }

    private fun getMetCriterialCounts(s: String): Int {
        var metCount = 0
        if (s.length >= 8) metCount++
        if (meetsContainingNumberCriteria(s)) metCount++
        if (meetsContainingUppercaseCriteria(s)) metCount++
        return metCount
    }

    private fun meetsContainingNumberCriteria(s: String): Boolean {
        for (ch in s) {
            if (ch in '0'..'9') {
                return true
            }
        }
        return false
    }

    private fun meetsContainingUppercaseCriteria(s: String): Boolean {
        for (ch in s) {
            if (ch.isUpperCase()) {
                return true
            }
        }
        return false
    }
}
