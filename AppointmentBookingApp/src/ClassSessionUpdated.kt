class ClassSessionUpdated {
    var providerName: String?=null
    var providerMobile: String?=null
    var providerEmail: String?=null
    var date: String?=null
    var time: String?=null
    var dur: String?=null
    var seats: String?=null
    var cost: String?=null

    constructor() {}
    constructor( providerName: String?,
                 providerMobile: String?,providerEmail: String?,
                 date: String?,time: String?,dur: String?,
                 seats: String?,cost: String?) {
        this.providerName = providerName
        this.providerMobile=providerMobile
        this.providerEmail=providerEmail
        this.date=date
        this.time=time
        this.dur=dur
        this.seats=seats
        this.cost=cost
    }

    override fun toString(): String {
        return StringBuffer("").append(providerName).append(",").append(providerMobile)
            .append(",").append(providerEmail).append(",").append(date).append(",").append(time).append(",").append(dur).append(",").append(seats).append(",").append(cost)
            .toString()
    }
}