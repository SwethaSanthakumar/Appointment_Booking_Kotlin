import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.util.*

fun main(){
        var done1 = false
        do{
        println("------------WELCOME------------")
        println("1.Admin")
        println("2.Customer")
        println("3.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
        var done2 = false
        do{
        println("------------------------------")
        println("         WELCOME ADMIN        ")
        println("------------------------------")
        println("1.Customer")
        println("2.Staff")
        println("3.Services")
        println("4.Classes")
        println("5.Appointments")
        println("6.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
        var done3 = false
        do{
        println("------------------------------")
        println("           CUSTOMER           ")
        println("------------------------------")
        println("1.Create Customer")
        println("2.Update Customer")
        println("3.View Customer")
        println("4.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
                val c = CustomerData()
                val c1 = c.createCustomer()
                val filePath = "C:/Users/Admin/Desktop/Intern/Data/customerdata.txt"
                val email= ValidateEmail()
                val mobile = ValidateMobile()
                if (email.isValidEmail("${c1.customerEmail}") && mobile.isValidMobile("${c1.customerMobile}")) {
                        val content = "${c1.customerName},${c1.customerEmail},${c1.customerMobile}"
                        println("------------------------------------------")
                        println("      CONFIRMATION(Creating Customer)     ")
                        println("------------------------------------------")
                        println("Customer Name : " + c1.customerName)
                        println("Customer Email ID : " + c1.customerEmail)
                        println("Customer Mobile No : " + c1.customerMobile)
                        println("Do you confirm to create the customer? (Yes/No)")
                        var choice: String? = null
                        var sc = Scanner(System.`in`)
                        choice = sc.nextLine()
                        if(choice.equals("Yes", ignoreCase = true)) {
                                try {
                                        val fw = FileWriter(filePath, true)
                                        val bw = BufferedWriter(fw)
                                        val pw1 = PrintWriter(bw)
                                        pw1.println(content)
                                        pw1.close()
                                        println("Customer has been created successfully!!")
                                } catch (e1: IOException) {
                                        System.err.println(e1)
                                }
                        }else if(choice.equals("No", ignoreCase = true)){
                                println("Customer is not created!!")
                        }
                        else {
                                println("Oops!..$choice is an invalid choice")
                        }
                }else{
                        println("Customer is not created!! Invalid Customer Email Id or Password!!")
                }
        }
        "2" -> {
do{
                        var done=false
        println("------------------------------------------")
        println("                UPDATE CUSTOMER              ")
        println("------------------------------------------")
                        println("1.Update Email")
                        println("2.Update Mobile")
                        println("3.Exit")
                        println("Please enter your choice")
                        var choice = readLine()
                        var selected = when (choice) {
                                "1" -> {
                                        val v = CustomerData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Customer name")
                                        var customerName = sc.nextLine()
                                        println("Enter the New Customer Email")
                                        var customerEmail = sc.nextLine()
                                        v.updateCustomerEmail(customerName, customerEmail)
                                        println("Customer Email has been updated successfully!!")
                                }
                                "2" -> {
                                        val v = CustomerData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Customer name")
                                        var customerName = sc.nextLine()
                                        println("Enter the New Customer Mobile Number")
                                        var customerMobile = sc.nextLong()
                                        v.updateCustomerMobile(customerName, customerMobile)
                                        println("Customer Mobile No has been updated successfully!!")

                                }
                                "3"->{
                                        done=true
                                }
                                else -> {

                                        println("Oops!!..$choice is an invalid choice")
                                }
                        }                   }while(!done)
        }

        "3" -> {
                val c = CustomerData()
                c.displayCustomerData()
        }
        "4" -> {
        done3=true
        }
        else -> "$choice is an invalid choice"
        }
        }while(!done3)}
        "2" ->{
        var done4 = false
        do{
        println("------------------------------")
        println("             STAFF            ")
        println("------------------------------")
        println("1.Create Staff")
        println("2.Update Staff")
        println("3.View Staff")
        println("4.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" ->{
                        val c = StaffData()
                        val c1 = c.createStaff()
                        val filePath = "C:/Users/Admin/Desktop/Intern/Data/staffdata.txt"
                        val email= ValidateEmail()
                       val mobile = ValidateMobile()
                        if (email.isValidEmail("${c1.staffEmail}") && mobile.isValidMobile("${c1.staffMobile}")) {
                                val content = "${c1.staffName},${c1.staffEmail},${c1.staffMobile},${c1.staffAccess}"
                                println("------------------------------------------")
                                println("        CONFIRMATION(Creating Staff)      ")
                                println("------------------------------------------")
                                println("Staff Name : " + c1.staffName)
                                println("Staff Email ID : " + c1.staffEmail)
                                println("Staff Mobile No : " + c1.staffMobile)
                                println("Staff Access : " + c1.staffAccess)
                                println("Do you confirm to create the staff? (Yes/No)")
                                var choice: String? = null
                                var sc = Scanner(System.`in`)
                                choice = sc.nextLine()
                                if(choice.equals("Yes", ignoreCase = true)) {
                                        try {
                                                val fw = FileWriter(filePath, true)
                                                val bw = BufferedWriter(fw)
                                                val pw1 = PrintWriter(bw)
                                                pw1.println(content)
                                                pw1.close()
                                                println("Staff has been created successfully!!")
                                        } catch (e1: IOException) {
                                                System.err.println(e1)
                                        }
                                }else if(choice.equals("No", ignoreCase = true)){
                                        println("Staff is not created!!")
                                }
                                else {
                                        println("Oops!..$choice is an invalid choice")
                                }

                        }else{
                                println("Staff is not created!! Invalid staff Email Id or Password!!")
                        }
                }


        "2" ->{
                do{
                        var done=false
                        println("------------------------------------------")
                        println("                UPDATE STAFF              ")
                        println("------------------------------------------")
                        println("1.Update Email")
                        println("2.Update Mobile")
                        println("3.Access Control")
                        println("4.Exit")
                        println("Please enter your choice")
                        var choice = readLine()
                        var selected = when (choice) {
                                "1" -> {
                                        val v = StaffData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Staff name")
                                        var staffName = sc.nextLine()
                                        println("Enter the New Staff Email")
                                        var staffEmail = sc.nextLine()
                                        v.updateStaffEmail(staffName, staffEmail)
                                        println("Staff Email ID has been updated successfully!!")
                                }
                                "2" -> {
                                        val v = StaffData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Staff name")
                                        var staffName = sc.nextLine()
                                        println("Enter the Staff's New Mobile Number")
                                        var staffMobile = sc.nextLong()
                                        v.updateStaffMobile(staffName, staffMobile)
                                        println("Staff Mobile No has been updated successfully!!")

                                }
                                "3"->{
                                        val v = StaffData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Staff name")
                                        var staffName = sc.nextLine()
                                        println("Enter the Staff's New Access Role")
                                        var staffAccess= sc.nextLine()
                                        v.updateStaffAccess(staffName, staffAccess)
                                        println("Staff Access has been updated successfully!!")
                                }
                                "4"->{
                                        done=true
                                }
                                else -> {

                                        println("Oops!!..$choice is an invalid choice")
                                }
                        }                   }while(!done)

        }
        "3" ->{
                val c = StaffData()
                c.displayStaffData()

        }
        "4" ->{
        done4=true
        }
        else -> "$choice is an invalid choice"
        }
        }while(!done4)}
        "3" ->{
        var done5 = false
        do{
        println("------------------------------")
        println("            SERVICE           ")
        println("------------------------------")
        println("1.Create Service")
        println("2.Update Service")
        println("3.View Service")
        println("4.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
                        val c = ServiceData()
                        val c1 = c.createService()
                        val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicedata.txt"
                        val content = "${c1.serviceName},${c1.serviceCost}"
                                println("------------------------------------------")
                                println("        CONFIRMATION(Creating Service)      ")
                                println("------------------------------------------")
                                println("Staff Name : " + c1.serviceName)
                                println("Staff Email ID : " + c1.serviceCost)
                                println("Do you confirm to create the service? (Yes/No)")
                                var choice: String? = null
                                var sc = Scanner(System.`in`)
                                choice = sc.nextLine()
                                if(choice.equals("Yes", ignoreCase = true)) {
                                        try {
                                                val fw = FileWriter(filePath, true)
                                                val bw = BufferedWriter(fw)
                                                val pw1 = PrintWriter(bw)
                                                pw1.println(content)
                                                pw1.close()
                                                println("Service has been created successfully!!")
                                        } catch (e1: IOException) {
                                                System.err.println(e1)
                                        }
                                }else if(choice.equals("No", ignoreCase = true)){
                                        println("Service is not created!!")
                                }
                                else {
                                        println("Oops!..$choice is an invalid choice")
                                }

                        }


        "2" ->{
                val v = ServiceData()
                var sc = Scanner(System.`in`)
                println("------------------------------------------")
                println("                UPDATE SERVICE            ")
                println("------------------------------------------")
                println("Enter the Service name")
                var serviceName = sc.nextLine()
                println("Enter the New Service Cost")
                var serviceCost = sc.nextInt()
                v.updateServiceCost(serviceName, serviceCost)
                println("Service Cost has been updated successfully!!")
        }
        "3" ->{
                val c = ServiceData()
                c.displayServiceData()
        }
        "4" ->{
        done5 = true
        }
        else -> "$choice is an invalid choice"
        }
        }while(!done5)}
        "4" ->{
        var done6 = false
        do{
        println("------------------------------")
        println("            CLASSES           ")
        println("------------------------------")
        println("1.Create Class")
        println("2.Update Class")
        println("3.View Class")
        println("4.Create Class Session")
        println("5.View Class Session")
        println("6.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" ->{
                        val c = ClassData()
                        val c1 = c.createClass()
                        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classdata.txt"
                                val content = "${c1.className},${c1.classCost},${c1.classDuration},${c1.classSeats}"
                                println("------------------------------------------")
                                println("        CONFIRMATION(Creating Class)      ")
                                println("------------------------------------------")
                                println("Class Name : " + c1.className)
                                println("Class Cost : " + c1.classCost)
                                println("Class Duration : " + c1.classDuration)
                                println("Class Slots : " + c1.classSeats)
                                println("Do you confirm to create the class? (Yes/No)")
                                var choice: String? = null
                                var sc = Scanner(System.`in`)
                                choice = sc.nextLine()
                                if(choice.equals("Yes", ignoreCase = true)) {
                                        try {
                                                val fw = FileWriter(filePath, true)
                                                val bw = BufferedWriter(fw)
                                                val pw1 = PrintWriter(bw)
                                                pw1.println(content)
                                                pw1.close()
                                                println("Staff has been created successfully!!")
                                        } catch (e1: IOException) {
                                                System.err.println(e1)
                                        }
                                }else if(choice.equals("No", ignoreCase = true)){
                                        println("Staff is not created!!")
                                }
                                else {
                                        println("Oops!..$choice is an invalid choice")
                                }
        }
        "2" ->{

                do{
                        var done=false
                        println("------------------------------------------")
                        println("                UPDATE CLASS              ")
                        println("------------------------------------------")
                        println("1.Update Class Cost")
                        println("2.Update Class Duration")
                        println("3.Update Class Slots")
                        println("4.Exit")
                        println("Please enter your choice")
                        var choice = readLine()
                        var selected = when (choice) {
                                "1" -> {
                                        val v = ClassData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Class name")
                                        var className = sc.nextLine()
                                        println("Enter the New Class cost")
                                        var classCost = sc.nextInt()
                                        v.updateClassCost(className, classCost)
                                        println("Class cost has been updated successfully!!")
                                }
                                "2" -> {
                                        val v = ClassData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Class name")
                                        var className = sc.nextLine()
                                        println("Enter the new Duration(in mins)")
                                        var classDur = sc.nextInt()
                                        v.updateClassDur(className, classDur)
                                        println("Class Duration has been updated successfully!!")

                                }
                                "3"->{
                                        val v = ClassData()
                                        var sc = Scanner(System.`in`)
                                        println("Enter the Class name")
                                        var className = sc.nextLine()
                                        println("Enter the new Slots")
                                        var classSlots= sc.nextInt()
                                        v.updateClassSlots(className, classSlots)
                                        println("Class Slots has been updated successfully!!")
                                }
                                "4"->{
                                        done=true
                                }
                                else -> {

                                        println("Oops!!..$choice is an invalid choice")
                                }
                        }                   }while(!done)
        }
        "3" ->{
                val c = ClassData()
                c.displayClassData()

        }
        "4" ->{
                val s = ClassSessionData()
                s.selectClass()
                s.selectProvider()
                s.selectTimeSlot()
                s.createClassSession()
        }
        "5" ->{
                val c = ClassSessionData()
                c.displayClassSessionData()
        }
        "6" ->{
        done6 = true
        }
        else -> "$choice is an invalid choice"
        }
        }while(!done6)}
        "5" ->{
        var done7 = false
        do{
        println("---------------------------------")
        println("           APPOINTMENTS          ")
        println("---------------------------------")
        println("1.Service")
        println("2.Class")
        println("3.Exit")
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
        var done8 = false
        do {
        println("--------------------------------------------")
        println("           APPOINTMENTS(Services)           ")
        println("--------------------------------------------")
        println("1.Book Appointments");
        println("2.View All Appointments");
        println("3.Exit");
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
                val c1 = ServiceBooking()
                c1.selectCustomer()
                c1.selectService()
                c1.selectProvider()
                c1.selectTimeSlot()
                println("------------------------------------------")
                println("           CONFIRM SERVICE BOOKING         ")
                println("------------------------------------------")
                println("Customer Name : " + c1.customerName)
                println("Customer Mobile : " + c1.customerMobile)
                println("Service Name : " + c1.serviceName)
                println("Provider Name : " + c1.providerName)
                println("Provider Mobile : " + c1.providerMobile)
                println("Provider Email : " + c1.providerEmail)
                println("Date : " + c1.date)
                println("Time : " + c1.timeSlot)
                println("Cost : " + c1.serviceCost)
                println("Do you confirm to book this class session? (Yes/No)")
                var choice1: String? = null
                var sc1 = Scanner(System.`in`)
                choice1 = sc1.nextLine()
                if (choice1.equals("Yes", ignoreCase = true)) {
                        val p1 = ServiceBookingDataClass(
                                cusName = c1.customerName, cusMobile = c1.customerMobile,
                                serviceName = c1.serviceName, providerName = c1.providerName,
                                date = c1.date, time = c1.timeSlot,
                                cost = c1.serviceCost
                        )
                        val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicebooked.txt"
                        val content =
                                "${p1.cusName},${p1.cusMobile},${p1.serviceName},${p1.providerName},${p1.date},${p1.time},${p1.cost}"
                        try {
                                val fw = FileWriter(filePath, true)
                                val bw = BufferedWriter(fw)
                                val pw1 = PrintWriter(bw)
                                pw1.println(content)
                                pw1.close()
                                println("Service has been Booked successfully!!")
                        } catch (e1: IOException) {
                                System.err.println(e1)
                        }
                } else if (choice1.equals("No", ignoreCase = true)) {
                        println("Service is not booked!!")
                } else {
                        println("Oops!!...$choice1 is an invalid choice!")
                }
        }
        "2" -> {
                val s = ServiceAppointment()
                s.displayServiceAppointmentData()
        }

        "3" -> {
        done8 = true
        }
        else -> "$choice is an invalid choice"
        }
        } while (!done8)
        }
        "2" -> {
        var done9 = false
        do {
        println("--------------------------------------------")
        println("            APPOINTMENTS(Classes)           ")
        println("--------------------------------------------")
        println("1.Book Classes");
        println("2.View All Classes Booked");
        println("3.Exit");
        println("Please enter your choice")
        var choice = readLine()
        var selected = when (choice) {
        "1" -> {
                val c1 = ClassBooking()
                c1.selectCustomer()
                c1.selectClassSession()
                println("------------------------------------------")
                println("           CONFIRM CLASS BOOKING         ")
                println("------------------------------------------")
                println("Customer Name : " + c1.customerName)
                println("Customer Mobile : " + c1.customerMobile)
                println("Class Name : " + c1.className)
                println("Provider Name : " + c1.providerName)
                println("Provider Mobile : " + c1.providerMobile)
                println("Provider Email : " + c1.providerEmail)
                println("Date : " + c1.date)
                println("Time : " + c1.timeSlot)
                println("Duration : " + c1.timeDur)
                println("Cost : " + c1.classCost)
                println("Do you confirm to book this class? (Yes/No)")
                var choice1: String? = null
                var sc1 = Scanner(System.`in`)
                choice1 = sc1.nextLine()
                if (choice1.equals("Yes",ignoreCase = true)) {
                        c1.updateSlots(c1.className);
                        val p1 = ClassBookingDataClass(
                                cusName = c1.customerName, cusMobile = c1.customerMobile,
                                className = c1.className, providerName = c1.providerName,
                                date = c1.date, time = c1.timeSlot,
                                dur = c1.timeDur, cost = c1.classCost
                        )
                        val filePath = "C:/Users/Admin/Desktop/Intern/Data/classbooked.txt"
                        val content =
                                "${p1.cusName},${p1.cusMobile},${p1.className},${p1.providerName},${p1.date},${p1.time},${p1.dur},${p1.cost}"
                        try {
                                val fw = FileWriter(filePath, true)
                                val bw = BufferedWriter(fw)
                                val pw1 = PrintWriter(bw)
                                pw1.println(content)
                                pw1.close()
                                println("Class has been Booked successfully!!")
                        } catch (e1: IOException) {
                                System.err.println(e1)
                        }
                } else if(choice1.equals("No",ignoreCase = true)){
                        println("Class Session is not booked!!")
                }else{
                        println("Oops!!...$choice1 is an invalid choice!")
                }

        }
        "2" -> {
                val s = ClassAppointment()
                s.displayClassAppointmentData()

        }
        "3" -> {
        done9 = true
        }
        else -> "$choice is an invalid choice"
        }
        } while (!done9)
        }
        "3" ->
        {
        done7 = true
        }
        else -> "$choice is an invalid choice"}
        }while(!done7)}
        "6" -> {
        done2=true
        }

        else -> println("$choice is an invalid choice")}
        }while(!done2)}
        "2" -> {
        println("------------------------------")
        println("       WELCOME CUSTOMER       ")
        println("------------------------------")
                println("CUSTOMER LOGIN")
                val c =LoginCustomer()
                c.validateCustomerDetails()
                if(c.result) {
                        do{
                                var done2=false
                        println("1.Book Classes");
                        println("2.Book Services");
                        println("3.Exit");
                        println("Please enter your choice")
                        var choice = readLine()
                        var selected = when (choice) {
                                "1" -> {
                                        val c1 = ClassBooking()
                                        c1.selectClassSession()
                                        println("------------------------------------------")
                                        println("           CONFIRM CLASS BOOKING         ")
                                        println("------------------------------------------")
                                        println("Customer Name : " + c.name)
                                        println("Customer Mobile : " + c.num)
                                        println("Class Name : " + c1.className)
                                        println("Provider Name : " + c1.providerName)
                                        println("Provider Mobile : " + c1.providerMobile)
                                        println("Provider Email : " + c1.providerEmail)
                                        println("Date : " + c1.date)
                                        println("Time : " + c1.timeSlot)
                                        println("Duration : " + c1.timeDur)
                                        println("Cost : " + c1.classCost)
                                        println("Do you confirm to book this class session? (Yes/No)")
                                        var choice1: String? = null
                                        var sc1 = Scanner(System.`in`)
                                        choice1 = sc1.nextLine()
                                        if (choice1.equals("Yes", ignoreCase = true)) {
                                                c1.updateSlots(c1.className);
                                                val p1 = ClassBookingDataClass(
                                                        cusName = c.name, cusMobile = c.num,
                                                        className = c1.className, providerName = c1.providerName,
                                                        date = c1.date, time = c1.timeSlot,
                                                        dur = c1.timeDur, cost = c1.classCost
                                                )
                                                val filePath = "C:/Users/Admin/Desktop/Intern/Data/classbooked.txt"
                                                val content =
                                                        "${p1.cusName},${p1.cusMobile},${p1.className},${p1.providerName},${p1.date},${p1.time},${p1.dur},${p1.cost}"
                                                try {
                                                        val fw = FileWriter(filePath, true)
                                                        val bw = BufferedWriter(fw)
                                                        val pw1 = PrintWriter(bw)
                                                        pw1.println(content)
                                                        pw1.close()
                                                        println("Class Session has been Booked successfully!!")
                                                } catch (e1: IOException) {
                                                        System.err.println(e1)
                                                }
                                        } else if (choice1.equals("No", ignoreCase = true)) {
                                                println("Class Session is not booked!!")
                                        } else {
                                                println("Oops!!...$choice1 is an invalid choice!")
                                        }
                                }
                                "2" ->
                                {
                                        val c1 = ServiceBooking()
                                        c1.selectService()
                                        c1.selectProvider()
                                        c1.selectTimeSlot()
                                        println("------------------------------------------")
                                        println("           CONFIRM SERVICE BOOKING         ")
                                        println("------------------------------------------")
                                        println("Customer Name : " + c.name)
                                        println("Customer Mobile : " + c.num)
                                        println("Service Name : " + c1.serviceName)
                                        println("Provider Name : " + c1.providerName)
                                        println("Provider Mobile : " + c1.providerMobile)
                                        println("Provider Email : " + c1.providerEmail)
                                        println("Date : " + c1.date)
                                        println("Time : " + c1.timeSlot)
                                        println("Cost : " + c1.serviceCost)
                                        println("Do you confirm to book this class session? (Yes/No)")
                                        var choice1: String? = null
                                        var sc1 = Scanner(System.`in`)
                                        choice1 = sc1.nextLine()
                                        if (choice1.equals("Yes", ignoreCase = true)) {
                                                val p1 = ServiceBookingDataClass(
                                                        cusName = c.name, cusMobile = c.num,
                                                        serviceName = c1.serviceName, providerName = c1.providerName,
                                                        date = c1.date, time = c1.timeSlot,
                                                        cost = c1.serviceCost
                                                )
                                                val filePath = "C:/Users/Admin/Desktop/Intern/Data/servicebooked.txt"
                                                val content =
                                                        "${p1.cusName},${p1.cusMobile},${p1.serviceName},${p1.providerName},${p1.date},${p1.time},${p1.cost}"
                                                try {
                                                        val fw = FileWriter(filePath, true)
                                                        val bw = BufferedWriter(fw)
                                                        val pw1 = PrintWriter(bw)
                                                        pw1.println(content)
                                                        pw1.close()
                                                        println("Service has been Booked successfully!!")
                                                } catch (e1: IOException) {
                                                        System.err.println(e1)
                                                }
                                        } else if (choice1.equals("No", ignoreCase = true)) {
                                                println("Service is not booked!!")
                                        } else {
                                                println("Oops!!...$choice1 is an invalid choice!")
                                        }

                                }
                                "3" ->
                                {
                                        done2=true
                                }
                                else ->println("$choice is an invalid choice!")
                        }}while(!done2)}else{

                }
        }
        "3" -> {
        done1 = true;
        }
        else -> println("$choice is an invalid choice")

        }}while(!done1)
        }