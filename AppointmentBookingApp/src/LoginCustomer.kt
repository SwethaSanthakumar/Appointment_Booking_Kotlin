import java.io.File
import java.util.*
import kotlin.collections.ArrayList
class LoginCustomer {
    lateinit var name: String
    lateinit var num: String
    var result = false
    fun validateCustomerDetails() {
        val customerFilePath = "C:/Users/Admin/Desktop/Intern/Data/customerdata.txt"
        val arr1 = ArrayList<String?>()
        val arr2 = ArrayList<String?>()
        val lineList = mutableListOf<String>()
        val sc = Scanner(System.`in`)
        println("Enter Username")
        name = sc.nextLine()
        println("Enter Password")
        num = sc.nextLine()
        val bufferedReader = File(customerFilePath).bufferedReader()
        bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach {
            var delimiter = ","
            val parts = it.split(delimiter)
            arr1.add(parts[0])
            arr2.add(parts[2])
        }
        if (arr1.contains(name) && arr2.contains(num)) {
            result = true
            println("Login Successful!!")
        } else {
            println("Invalid Username and Password!!")
        }
    }
}