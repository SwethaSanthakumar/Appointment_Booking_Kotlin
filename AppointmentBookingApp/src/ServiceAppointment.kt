import java.io.File

class ServiceAppointment {
    fun displayServiceAppointmentData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicebooked.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("---------------------------------------------------------------------------------------------------------------------------------")
        System.out.printf("%20s %15s %25s %15s %15s %15s %15s", "CUSTOMER NAME", "MOBILE", "SERVICE NAME","PROVIDER NAME","DATE","TIME SLOT","COST(in Rs.)")
        println()
        println("---------------------------------------------------------------------------------------------------------------------------------")
        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            val s = ServiceAppointmentDataClass()
            s.customerName = parts[0]
            s.customerMobile = parts[1].toLong()
            s.serviceName = parts[2]
            s.providerName=parts[3]
            s.date=parts[4]
            s.timeSlot=parts[5]
            s.serviceCost=parts[6].toInt()
            System.out.format("%20s %15d %25s %15s %15s %15s %15d",s.customerName,s.customerMobile,s.serviceName,s.providerName,
            s.date,s.timeSlot,s.serviceCost)
            println()
        }
        println("---------------------------------------------------------------------------------------------------------------------------------")
        println("Service Appointment has been viewed successfully!!")
    }
}