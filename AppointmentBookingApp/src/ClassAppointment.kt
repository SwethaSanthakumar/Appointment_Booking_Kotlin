import java.io.File

class ClassAppointment {
    fun displayClassAppointmentData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classbooked.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("-----------------------------------------------------------------------------------------------------------------------------------------------------")
        System.out.printf("%20s %15s %25s %15s %15s %15s %20s %15s", "CUSTOMER NAME", "MOBILE", "CLASS NAME","PROVIDER NAME","DATE","TIME SLOT","DURATION(in mins)","COST(in Rs.)")
        println()
        println("-----------------------------------------------------------------------------------------------------------------------------------------------------")
        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            val s = ClassAppointmentDataClass()
            s.customerName = parts[0]
            s.customerMobile = parts[1].toLong()
            s.className = parts[2]
            s.providerName=parts[3]
            s.date=parts[4]
            s.timeSlot=parts[5]
            s.duration=parts[6].toInt()
            s.classCost=parts[7].toInt()
            System.out.format("%20s %15d %25s %15s %15s %15s %20d %15d",s.customerName,s.customerMobile,s.className,s.providerName,
                s.date,s.timeSlot,s.duration,s.classCost)
            println()
        }
        println("----------------------------------------------------------------------------------------------------------------------------------------------------")
        println("Class Appointment has been viewed successfully!!")
    }
}