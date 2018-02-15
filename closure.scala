object Myclojure {

def main(args:Array[String])
  {
    val dollar_convertor :Int = 67    

    val convert = (x:Double) => x * dollar_convertor

    println("The value of 10 dollars in INR is " + convert(10))    
  }
}
