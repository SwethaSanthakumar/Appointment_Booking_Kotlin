class CustomerUpdate {
    var customerMobile: String?=null
    var customerEmail: String?=null

    constructor() {}
    constructor(
                 customerEmail: String?,customerMobile: String?) {
        this.customerEmail=customerEmail
        this.customerMobile=customerMobile
    }

    override fun toString(): String {
        return StringBuffer("").append(customerEmail).append(",").append(customerMobile)
            .toString()
    }
}