import java.io.*
import java.util.*

class ClassBooking {
    val lineList = mutableListOf<String>()
    lateinit var customerSelected: String
    lateinit var customerName: String
    lateinit var customerMobile: String
    lateinit var customerEmail: String
    lateinit var sessionSelected: String
    lateinit var className: String
    lateinit var providerName: String
    lateinit var providerMobile: String
    lateinit var providerEmail: String
    lateinit var timeSlot: String
    lateinit var timeDur: String
    lateinit var classSeats: String
    lateinit var classCost: String
    lateinit var date: String
    fun selectClassSession() {
        var i=1
        println("SELECT CLASS  SESSION")
        println("--------------------------------------------------------------------------------------------------------------------------------------------------------------")
        System.out.printf("%10s %25s %15s %15s %25s %10s %10s %10s %10s %10s","CHOICE", "CLASS NAME", "PROVIDER NAME", "MOBILE","EMAIL","DATE","TIME","DURATION","SLOTS","COST")
        println()
        println("--------------------------------------------------------------------------------------------------------------------------------------------------------------")

        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classsession.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            System.out.format("%10d %25s %15s %15s %25s %10s %10s %10s %10s %10s", i, parts[0], parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8])
            println()
            i++
        }
        println("--------------------------------------------------------------------------------------------------------------------------------------------------------------")
        var choice: Int? = 0
        println()
        println("Enter your choice to select the class session")
        var sc = Scanner(System.`in`)
        choice = sc.nextInt()
        sessionSelected = lineList.elementAt(--choice)
        var delimiter = ","
        val parts = sessionSelected.split(delimiter)
        className=parts[0]
        providerName=parts[1]
        providerMobile=parts[2]
        providerEmail=parts[3]
        date=parts[4]
        timeSlot=parts[5]
        timeDur=parts[6]
        classSeats=parts[7]
        classCost=parts[8]

    }
    fun updateSlots(classSesssion:String){
        val lineList1 = mutableListOf<String>()
        var seats:Int?=0
        lateinit var content:String
        var sessionMap : HashMap<String,ClassSessionUpdated>
                = HashMap<String,ClassSessionUpdated> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classsession.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            className=parts[0]
            providerName=parts[1]
            providerMobile=parts[2]
            providerEmail=parts[3]
            date=parts[4]
            timeSlot=parts[5]
            timeDur=parts[6]
            classSeats=parts[7]
            classCost=parts[8]

            if(classSesssion == className)
            {
                seats = classSeats.toInt()-1
               // println(seats)
                classSeats=seats.toString()
                val cs = ClassSessionUpdated(providerName,providerMobile,providerEmail,date,timeSlot,timeDur,classSeats,classCost)
                sessionMap.put(className,cs)
            }
            else{
                val cs = ClassSessionUpdated(providerName,providerMobile,providerEmail,date,timeSlot,timeDur,classSeats,classCost)
                sessionMap.put(className,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in sessionMap.keys){
                    pw1.println("$key,${sessionMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
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
}