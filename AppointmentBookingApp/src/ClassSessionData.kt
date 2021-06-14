import java.io.*
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ClassSessionData {
    val lineList = mutableListOf<String>()
    lateinit var classSelected: String
    lateinit var className: String
    lateinit var providerSelected: String
    lateinit var providerName: String
    lateinit var providerMobile: String
    lateinit var providerEmail: String
    lateinit var timeSlot: String
    lateinit var timeDur: String
    lateinit var classSeats: String
    lateinit var classCost: String
    lateinit var date: String
    fun selectClass() {
        var i=1
        println("------------------------------------------")
        println("                 SELECT CLASS             ")
        println("------------------------------------------")
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach {
            var delimiter = ","

            val parts = it.split(delimiter)

            println("$i  : " + parts[0])
            classCost=parts[1]
            timeDur=parts[2]
            classSeats=parts[3]
            i++
        }
        var choice: Int? = 0
        println("Enter your choice to select the class")
        var sc = Scanner(System.`in`)
        choice = sc.nextInt()
        classSelected = lineList.elementAt(--choice)
        var delimiter = ","
        val parts = classSelected.split(delimiter)
        className=parts[0]
        classCost=parts[1]
        timeDur=parts[2]
        classSeats=parts[3]
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
    fun createClassSession(){
        println("------------------------------------------")
        println("           CREATING CLASS SESSION         ")
        println("------------------------------------------")
        println("Class Name : $className")
        println("Provider Name : " + providerName)
        println("Provider Mobile : " + providerMobile)
        println("Provider Email : " + providerEmail)
        println("Date : " +date)
        println("Time : " +timeSlot)
        println("Duration : " +timeDur)
        println("Number of Slots : " +classSeats)
        println("Cost : " +classCost)
        println("Do you want to create this class session? (Yes/No)")
        var choice: String? = null
        var sc = Scanner(System.`in`)
        choice = sc.nextLine()
        if(choice.equals("Yes", ignoreCase = true)){
            val p1 = ClassSessionDataClass(className = className,providerName=providerName,
                providerMobile=providerMobile,providerEmail=providerEmail,date=date,time = timeSlot,
                dur = timeDur,seats = classSeats,cost =classCost)
            val filePath = "C:/Users/Admin/Desktop/Intern/Data/classsession.txt"
            val content = "${p1.className},${p1.providerName},${p1.providerMobile},${p1.providerEmail},${p1.date},${p1.time},${p1.dur},${p1.seats},${p1.cost}"
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                pw1.println(content)
                pw1.close()
                println("Class Session is created successfully!!")
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }else if(choice.equals("No", ignoreCase = true))
        {
            println("Class Session is not created!!")
        }
        else{
            println("Oops!..$choice is an invalid choice")
        }
    }
    fun displayClassSessionData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classsession.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("-----------------------------------------------------------------------------------------------------------------------------------------")
        System.out.printf("%25s %15s %15s %25s %10s %10s %10s %10s %10s","CLASS NAME", "PROVIDER NAME", "MOBILE","EMAIL","DATE","TIME","DURATION","SLOTS","COST")
        println()
        println("-----------------------------------------------------------------------------------------------------------------------------------------")

        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            System.out.format("%25s %15s %15s %25s %10s %10s %10s %10s %10s",parts[0], parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8])
            println()
        }
        println("------------------------------------------------------------------------------------------------------------------------------------------")
        println("Class Session has been viewed successfully!!")
    }
}