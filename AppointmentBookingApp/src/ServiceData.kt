import java.io.*
import java.util.*

class ServiceData {
    lateinit var serviceName: String
    lateinit var serviceCost: String
    fun createService() : ServiceDataClass {
        var sc = Scanner(System.`in`)
        val s= ServiceDataClass()
        println("------------------------------------------")
        println("            CREATING NEW SERVICE          ")
        println("------------------------------------------")
        println("Enter the Service name")
        s.serviceName = sc.nextLine()
        println("Enter the Service cost")
        s.serviceCost = sc.nextInt()
        return s
    }
    fun displayServiceData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicedata.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("----------------------------------------------------")
        System.out.printf("%25s %15s", "SERVICE NAME", "COST(in Rs.)")
        println()
        println("----------------------------------------------------")
        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            val s = ServiceDataClass()
            s.serviceName = parts[0]
            s.serviceCost = parts[1].toInt()
            System.out.format("%25s %15s",s.serviceName,s.serviceCost)
            println()
        }
        println("----------------------------------------------------")
        println("Service has been viewed successfully!!")
    }



    fun updateServiceCost(serName:String,newCost:Int){
        val lineList1 = mutableListOf<String>()
        var seats:Int?=0
        lateinit var content:String
        var serviceMap : HashMap<String,Int>
                = HashMap<String,Int> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicedata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            serviceName=parts[0]
            serviceCost=parts[1]

            if(serName == serviceName)
            {
                serviceCost=newCost.toString()
                serviceMap.put(serviceName,serviceCost.toInt())
            }
            else{
                serviceMap.put(serviceName,serviceCost.toInt())
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in serviceMap.keys){
                    pw1.println("$key,${serviceMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
}