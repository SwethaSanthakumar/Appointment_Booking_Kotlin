import java.io.*
import java.util.*

class CustomerData {
    lateinit var customerName: String
    lateinit var customerMobile: String
    lateinit var customerEmail: String
    fun createCustomer(): CustomerDataClass {
        var sc = Scanner(System.`in`)
        val s = CustomerDataClass()
        println("------------------------------------------")
        println("           CREATING NEW CUSTOMER          ")
        println("------------------------------------------")
        println("Enter the Customer name")
        s.customerName = sc.nextLine()
        println("Enter the Customer's Email ID")
        s.customerEmail = sc.nextLine()
        println("Enter the Customer's mobile number")
        s.customerMobile = sc.nextLong()
        return s
    }

    fun displayCustomerData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/customerdata.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("------------------------------------------------------------")
        System.out.printf("%10s %25s %20s", "CUSTOMER NAME", "EMAIL-ID", "MOBILE NUMBER")
        println()
        println("------------------------------------------------------------")
        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            val s = CustomerDataClass()
            s.customerName = parts[0]
            s.customerEmail = parts[1]
            s.customerMobile = parts[2].toLong()
            System.out.format("%10s %25s %20d",s.customerName,s.customerEmail,s.customerMobile)
            println()
        }
        println("------------------------------------------------------------")
        println("Customer has been viewed successfully!!")
    }

    fun updateCustomerEmail(cusName:String,newEmail:String){
        val lineList1 = mutableListOf<String>()
        var seats:Int?=0
        lateinit var content:String
        var customerMap : HashMap<String,CustomerUpdate>
                = HashMap<String,CustomerUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/customerdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            customerName=parts[0]
            customerEmail=parts[1]
            customerMobile=parts[2]
                if(cusName == customerName)
            {
                customerEmail=newEmail
                val cs = CustomerUpdate(customerEmail,customerMobile)
                customerMap.put(customerName,cs)
            }
            else{
                val cs = CustomerUpdate(customerEmail,customerMobile)
                    customerMap.put(customerName,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in customerMap.keys){
                    pw1.println("$key,${customerMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }

    fun updateCustomerMobile(cusName:String,newMobile:Long){
        val lineList1 = mutableListOf<String>()
        var seats:Int?=0
        lateinit var content:String
        var customerMap : HashMap<String,CustomerUpdate>
                = HashMap<String,CustomerUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/customerdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            customerName=parts[0]
            customerEmail=parts[1]
            customerMobile=parts[2]
            if(cusName == customerName)
            {
                customerMobile=newMobile.toString()
                val cs = CustomerUpdate(customerEmail,customerMobile)
                customerMap.put(customerName,cs)
            }
            else{
                val cs = CustomerUpdate(customerEmail,customerMobile)
                customerMap.put(customerName,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in customerMap.keys){
                    pw1.println("$key,${customerMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
}