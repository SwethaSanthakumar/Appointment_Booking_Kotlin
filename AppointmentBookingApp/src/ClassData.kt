import java.io.*
import java.util.*
class ClassData {
    lateinit var className: String
    lateinit var classCost: String
    lateinit var classDur: String
    lateinit var classSlots: String
    fun createClass() : ClassDataClass {
        var sc = Scanner(System.`in`)
        val s= ClassDataClass()
        println("------------------------------------------")
        println("            CREATING NEW CLASS            ")
        println("------------------------------------------")
        println("Enter the Class name")
        s.className = sc.nextLine()
        println("Enter the Class cost")
        s.classCost = sc.nextInt()
        println("Enter the Class duration(in minutes)")
        s.classDuration = sc.nextInt()
        println("Enter the Number of seats in class")
        s.classSeats = sc.nextInt()
        return s
    }
    fun displayClassData() {
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classdata.txt"
        val list = mutableListOf<String>()
        val bufferedReader = File(filePath).bufferedReader()
        println("-----------------------------------------------------------------------------------")
        System.out.printf("%25s %20s %20s %15s", "CLASS NAME", "COST(in Rs.)", "DURATION(in mins)", "SLOTS")
        println()
        println("-----------------------------------------------------------------------------------")
        bufferedReader.useLines { lines -> lines.forEach { list.add(it) } }
        list.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            val s = ClassDataClass()
            s.className = parts[0]
            s.classCost = parts[1].toInt()
            s.classDuration = parts[2].toInt()
            s.classSeats=parts[3].toInt()
            System.out.format("%25s %20d %20d %15d",s.className,s.classCost,s.classDuration,s.classSeats)
            println()
        }
        println("-----------------------------------------------------------------------------------")
        println("Class has been viewed successfully!!")
    }
    fun updateClassCost(cName:String,newCost:Int){
        val lineList1 = mutableListOf<String>()
        lateinit var content:String
        var classMap : HashMap<String,ClassUpdate>
                = HashMap<String,ClassUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            className=parts[0]
            classCost=parts[1]
            classDur=parts[2]
            classSlots=parts[3]
            if(cName == className)
            {
                classCost=newCost.toString()
                val cs = ClassUpdate(classCost.toInt(),classDur.toInt(),classSlots.toInt())
                classMap.put(className,cs)
            }
            else{
                val cs = ClassUpdate(classCost.toInt(),classDur.toInt(),classSlots.toInt())
                classMap.put(className,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in classMap.keys){
                    pw1.println("$key,${classMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
    fun updateClassDur(cName:String,newDur:Int){
        val lineList1 = mutableListOf<String>()
        lateinit var content:String
        var classMap : HashMap<String,ClassUpdate>
                = HashMap<String,ClassUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            className=parts[0]
            classCost=parts[1]
            classDur=parts[2]
            classSlots=parts[3]
            if(cName == className)
            {
                classDur=newDur.toString()
                val cs = ClassUpdate(classCost.toInt(),classDur.toInt(),classSlots.toInt())
                classMap.put(className,cs)
            }
            else{
                val cs = ClassUpdate(classCost.toInt(),classDur.toInt(),classSlots.toInt())
                classMap.put(className,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in classMap.keys){
                    pw1.println("$key,${classMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
    fun updateClassSlots(cName:String,newSlots:Int){
        val lineList1 = mutableListOf<String>()
        lateinit var content:String
        var classMap : HashMap<String,ClassUpdate>
                = HashMap<String,ClassUpdate> ()
        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classdata.txt"
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList1.add(it) } }
        lineList1.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            className=parts[0]
            classCost=parts[1]
            classDur=parts[2]
            classSlots=parts[3]
            if(cName == className)
            {
                classSlots=newSlots.toString()
                val cs = ClassUpdate(classCost.toInt(),classDur.toInt(),classSlots.toInt())
                classMap.put(className,cs)
            }
            else{
                val cs = ClassUpdate(classCost.toInt(),classDur.toInt(),classSlots.toInt())
                classMap.put(className,cs)
            }
            val pw = PrintWriter(filePath)
            pw.print("")
            pw.close()
            try {
                val fw = FileWriter(filePath, true)
                val bw = BufferedWriter(fw)
                val pw1 = PrintWriter(bw)
                for(key in classMap.keys){
                    pw1.println("$key,${classMap[key]}")
                }
                pw1.close()
            } catch (e1: IOException) {
                System.err.println(e1)
            }
        }
    }
}