# Scala
Scala is a modern multi-paradigm programming language designed to express common programming patterns in a concise, elegant, and type-safe way. Scala has been created by Martin Odersky and he released the first version in 2003. Scala smoothly integrates the features of object-oriented and functional languages.

## Arrays

### Program 1
```
object Myarray{

 def main(args:Array[String])
 {
   val mynum = Array(1,2,3,4,5) 
   val mynames = Array("Ram","Sham","Somu")    
   println(mynum)
   println(mynames)
 }  
}
```
### Program 2
```
object Myarray{

 def main(args:Array[String])
 {
   val mynum = Array(1,2,3,4,5) 
   val mynames = Array("Ram","Sham","Somu")     
   println(mynum.mkString(" "))
   println(mynames.mkString(" "))
 }  
}
```
### Program 3
```
object Myarray{

 def main(args:Array[String])
 {
   val mynum = Array(1,2,3,4,5) 
   val mynames = Array("Ram","Sham","Somu")    
   for(n<-mynum)
       {
         println(mynum(n-1))
       }
 }  
}
```
### Creating and initializing the elemensts into array
```
var myarr = new Array[Strings](3)
myarr(0) = "Ram"
myarr(1) = "Laxman"
myarr(2) = "Sita"

```
## Scala collections
-----------------------------------------------------------------------------
Collections , as the name suggests, it contains a group of elements 

1. List  : contains a list of similar elements 
2. Tuples : can contain elements of different type unlike lists
3. Maps : collection of key-value pairs 
4. Sets : collections of pairwise elements of same type 
