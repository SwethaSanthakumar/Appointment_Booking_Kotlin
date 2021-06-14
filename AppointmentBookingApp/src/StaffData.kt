import java.io.*
import java.util.*

class StaffData {
    lateinit var staffName: String
    lateinit var staffMobile: String
    lateinit var staffEmail: String
    lateinit var staffAccess: String
    fun createStaff() : StaffDataClass {
        var sc = Scanner(System.`in`)
        val s= StaffDataClass()
        println("------------------------------------------")
        println("           CREATING NEW STAFF             ")
        println("------------------------------------------")
        println("Enter the Staff name")
        s.staffName = sc.nextLine()
        println("Enter the Staff's Email ID")
        s.staffEmail = sc.nextLine()
        println("Enter the Staff's mobile number")
        s.staffMobile = sc.nextLong()
        println("Enter the Staff's access role")
        var sc1 = Scanner(System.`in`)
        s.staffAccess = sc1.nextLine()
        return s
    }
    fun displayStaffData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/staffdata.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("---------------------------------------------------------------------------------------")
        System.out.printf("%10s %25s %20s %20s", "STAFF NAME", "EMAIL-ID", "MOBILE NUMBER", "ACCESS ROLE")
        println()
        println("---------------------------------------------------------------------------------------")
        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            val s = StaffDataClass()
            s.staffName = parts[0]
            s.staffEmail = parts[1]
            s.staffMobile = parts[2].toLong()
            s.staffAccess=parts[3]
            System.out.format("%10s %25s %20d %20s",s.staffName,s.staffEmail,s.staffMobile,s.staffAccess)
            println()
        }
        println("--------------------------------------------------------------------------------------")
        println("Staff has been viewed successfully!!")
    }
    fun updateStaffEmail(staName:String,newEmail:String){
        val lineList1 = mutableListOf<String>()
        lateinit var content:String
        var staffMap : HashMap<String,StaffUpdate>
                = HashMap<String,StaffUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/staffdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            staffName=parts[0]
            staffEmail=parts[1]
            staffMobile=parts[2]
            staffAccess=parts[3]
            if(staName == staffName)
            {
                staffEmail=newEmail
                val cs = StaffUpdate(staffEmail,staffMobile,staffAccess)
                staffMap.put(staffName,cs)
            }
            else{
                val cs = StaffUpdate(staffEmail,staffMobile,staffAccess)
                staffMap.put(staffName,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in staffMap.keys){
                    pw1.println("$key,${staffMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }

    fun updateStaffMobile(staName:String,newMobile:Long){
        val lineList1 = mutableListOf<String>()
        lateinit var content:String
        var staffMap : HashMap<String,StaffUpdate>
                = HashMap<String,StaffUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/staffdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            staffName=parts[0]
            staffEmail=parts[1]
            staffMobile=parts[2]
            staffAccess=parts[3]
            if(staName == staffName)
            {
                staffMobile=newMobile.toString()
                val cs = StaffUpdate(staffEmail,staffMobile,staffAccess)
                staffMap.put(staffName,cs)
            }
            else{
                val cs = StaffUpdate(staffEmail,staffMobile,staffAccess)
                staffMap.put(staffName,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in staffMap.keys){
                    pw1.println("$key,${staffMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }

    fun updateStaffAccess(staName:String,newAccess:String){
        val lineList1 = mutableListOf<String>()
        lateinit var content:String
        var staffMap : HashMap<String,StaffUpdate>
                = HashMap<String,StaffUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/staffdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            staffName=parts[0]
            staffEmail=parts[1]
            staffMobile=parts[2]
            staffAccess=parts[3]
            if(staName == staffName)
            {
                staffAccess=newAccess
                val cs = StaffUpdate(staffEmail,staffMobile,staffAccess)
                staffMap.put(staffName,cs)
            }
            else{
                val cs = StaffUpdate(staffEmail,staffMobile,staffAccess)
                staffMap.put(staffName,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in staffMap.keys){
                    pw1.println("$key,${staffMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
}