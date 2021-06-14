class ClassUpdate  {
    var classCost: Int?=0
    var classDur: Int?=0
    var classSlots:Int?=0

    constructor() {}
    constructor(
        classCost: Int?,classDur: Int?,classSlots:Int?) {
        this.classCost=classCost
        this.classDur=classDur
        this.classSlots=classSlots
    }

    override fun toString(): String {
        return StringBuffer("").append(classCost).append(",").append(classDur).append(",").append(classSlots)
            .toString()
    }
}