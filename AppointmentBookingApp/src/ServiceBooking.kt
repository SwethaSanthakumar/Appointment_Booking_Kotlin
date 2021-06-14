import java.io.File
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ServiceBooking {
    val lineList = mutableListOf<String>()
    lateinit var customerSelected: String
    lateinit var customerName: String
    lateinit var customerMobile: String
    lateinit var customerEmail: String
    lateinit var serviceSelected: String
    lateinit var serviceName: String
    lateinit var serviceCost: String
    lateinit var providerSelected: String
    lateinit var providerName: String
    lateinit var providerMobile: String
    lateinit var providerEmail: String
    lateinit var timeSlot: String
    lateinit var date: String
    fun selectCustomer() {
        var i=1
        println("------------------------------------------")
        println("               SELECT CUSTOMER            ")
        println("------------------------------------------")
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/customerdata.txt"
        val bufferedReader1 = File(filePath).bufferedReader()
        val lineList = mutableListOf<String>()
        bufferedReader1.useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            println("$i  : " + parts[0])
            i++
        }
        var choice1: Int? = 0
        println("Enter your choice to select the customer")
        var sc = Scanner(System.`in`)
        choice1 = sc.nextInt()
        customerSelected = lineList.elementAt(--choice1)
        var delimiter = ","
        val parts = customerSelected.split(delimiter)
        customerName=parts[0]
        customerEmail=parts[1]
        customerMobile=parts[2]
    }
    fun selectService() {
        var i=1
        println("------------------------------------------")
        println("               SELECT SERVICE            ")
        println("------------------------------------------")
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicedata.txt"
        val bufferedReader1 = File(filePath).bufferedReader()
        val lineList = mutableListOf<String>()
        bufferedReader1.useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            println("$i  : " + parts[0])
            i++
        }
        var choice1: Int? = 0
        println("Enter your choice to select the service")
        var sc = Scanner(System.`in`)
        choice1 = sc.nextInt()
        serviceSelected = lineList.elementAt(--choice1)
        var delimiter = ","
        val parts = serviceSelected.split(delimiter)
        serviceName=parts[0]
        serviceCost=parts[1]
    }
    fun selectProvider() {
        var i=1
        println("------------------------------------------")
        println("               SELECT PROVIDER            ")
        println("------------------------------------------")
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/staffdata.txt"
        val bufferedReader1 = File(filePath).bufferedReader()
        val lineList = mutableListOf<String>()
        bufferedReader1.useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            println("$i  : " + parts[0])
            i++
        }
        var choice1: Int? = 0
        println("Enter your choice to select the provider")
        var sc = Scanner(System.`in`)
        choice1 = sc.nextInt()
        providerSelected = lineList.elementAt(--choice1)
        var delimiter = ","
        val parts = providerSelected.split(delimiter)
        providerName=parts[0]
        providerEmail=parts[1]
        providerMobile=parts[2]
    }
    fun selectTimeSlot() {
        println("------------------------------------------")
        println("               SELECT TIME SLOT            ")
        println("------------------------------------------")
        val arr = ArrayList<String>()
        val calendar = Calendar.getInstance()
        val dateFormat: DateFormat = SimpleDateFormat("HH:mm:ss")
        val dateFormat1: DateFormat = SimpleDateFormat("hh:mm aa")
        val s = dateFormat.format(calendar.time)
        val format = SimpleDateFormat("HH:mm:ss")
        val stopTime = "18:00:00"
        var d1: Date? = null
        var d2: Date? = null
        try {
            d1 = format.parse(s)
            d2 = format.parse(stopTime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val calendar1 = Calendar.getInstance()
        val unroundedMinutes = calendar1[Calendar.MINUTE]
        val mod = unroundedMinutes % 15
        calendar1.add(Calendar.MINUTE, if (mod < 8) -mod else 15 - mod)
        var sc1 = dateFormat.format(calendar1.time)
        val diff = d2!!.time - d1!!.time
        val diffHours = diff / (60 * 60 * 1000)
        val df: DateFormat = SimpleDateFormat("dd/MM/yyyy")
        val data = df.format(Date())
        date = data
        var s2: String?=null
        for (i in 1..(diffHours*4) ){
            calendar1.add(Calendar.MINUTE, 15);
            s2 = dateFormat1.format(calendar1.time)
            arr.add(s2)
        }
        var i=1
        for (element in arr) {
            println("$i  : " + element)
            i++
        }
        var choice2: Int? = 0
        println("Enter your choice to select the time slot")
        var sc = Scanner(System.`in`)
        choice2 = sc.nextInt()
        timeSlot = arr.elementAt(--choice2)
    }
}