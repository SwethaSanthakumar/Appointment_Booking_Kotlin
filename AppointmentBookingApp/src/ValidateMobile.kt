class ValidateMobile {
    fun isValidMobile(mobile: String): Boolean {
        val mobileRegex = "(0/91)?[7-9][0-9]{9}"
        return mobileRegex.toRegex().matches(mobile)
    }
}