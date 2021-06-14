class StaffUpdate  {
    var staffMobile: String?=null
    var staffEmail: String?=null
    var staffAccess:String?=null

    constructor() {}
    constructor(
        staffEmail: String?,staffMobile: String?,staffAccess:String?) {
        this.staffEmail=staffEmail
        this.staffMobile=staffMobile
        this.staffAccess=staffAccess
    }

    override fun toString(): String {
        return StringBuffer("").append(staffEmail).append(",").append(staffMobile).append(",").append(staffAccess)
            .toString()
    }
}