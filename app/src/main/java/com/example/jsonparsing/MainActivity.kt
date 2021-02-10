package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jsonparsing.Model.*
import com.google.gson.Gson
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    companion object{
        private val TAG = MainActivity.javaClass.name
    }

    private lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gson = Gson()

        //createSimpleEmployeeJson()
        //parseEmployeeJson()

        //createNestedObjectUSerJson()
        //parseNestedObjectUSerJson()

        //createJsonWithList()
        //parseJsonWithList()

        parseJsonArray()
    }

    private fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = assets.open("footballer.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    private fun createSimpleEmployeeJson(){
        val employee = Employee("Yadu","25","yadvendu7077@gmail.com")
        val employeeJson = gson.toJson(employee)
        Log.d(TAG,employeeJson)
    }

    /*
    parsing simple json
     */
    private fun parseEmployeeJson(){
        val employeeJsonString = readJSONFromAsset()
        val employee = gson.fromJson<Employee>(employeeJsonString,Employee::class.java)
        Log.d(TAG,employee.toString())
    }

    private fun createNestedObjectUSerJson(){
        val address = Address("Bangalore","India")
        val user = User("Yadu","25",address)
        val userJson = gson.toJson(user)
        Log.d(TAG,userJson)
    }

    /*
    parsing nested json
     */
    private fun parseNestedObjectUSerJson(){
        val userJsonString = readJSONFromAsset()
        val user = gson.fromJson<User>(userJsonString,User::class.java)
        Log.d(TAG,user.toString())
    }

    private fun createJsonWithList(){
        val address = Address("Bangalore","India")

        val productList = ArrayList<Products>()
        val productsOne = Products("1234","Lakme Face Wash")
        val productsTwo = Products("1334","Garnier Face Wash")
        productList.add(productsOne)
        productList.add(productsTwo)

        val userProductOrder = UserProductOrder("Yadu",address,productList)
        val userProductOrderJson = gson.toJson(userProductOrder)
        Log.d(TAG,userProductOrderJson)
    }

    /*
    parsing nested json with arrays
     */
    private fun parseJsonWithList(){
        val userJsonString = readJSONFromAsset()
        val userProductOrder = gson.fromJson<UserProductOrder>(userJsonString,UserProductOrder::class.java)
        Log.d(TAG,userProductOrder.toString())
    }

    /*
   parsing json array instead of json object
    */
    private fun parseJsonArray(){
        val footballerJsonString = readJSONFromAsset()
        //First method (Best Method) -> To create a class like Footballer and then parse as done below
        val footballer = gson.fromJson<Footballer>(footballerJsonString, Footballer::class.java)
        Log.d(TAG, footballer.toString())

        //Second method but always approach with first method
        //val footballerList = gson.fromJson(footballerJsonString,Array<FootballerItem>::class.java).toList()
        //Log.d(TAG,footballerList.toString())
    }
}
