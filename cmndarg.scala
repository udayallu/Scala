object Myifelse {

def main(args:Array[String]) {
 var a = 10;
 var b = 20;

 
//Check the contents of the args for presence of command line arguments 
 if(args.length < 1 )
  {
     println("There are no command line arguments")

  }

  else 
    {
     println("There are command line agruments")
  
    }
 if(a>b)  {
            println("The value of a is greater")  
 
          } 
   else 
          {
             println("The value of b is greater")  
 
          }
                           }//end of main

   } //end of object
