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

## Direclty reading from a text file in local file system (will be the most used one)
### local system
```
val myfilerdd = sc.textFile("/home/hduser/movie.mp4")
myfilerdd.collect()
```
[logo]: https://github.com/udayallu/Scala/blob/master/Scala%20Images/local.PNG "Logo Title Text 2"
### hdfd system
#### step-1
1.First copy the movie into the hdfs
2. start the hadoop services
3. copy the file to the unix
```
start-all.sh
// creating the movie folder
hadoop fs -mkdir movie
// moving the file into the movie folder created inthe hdfs
hadoop fs -put movie.mp4 movie
```
#### step-2
1. go to the scala terminal
2. use the following code to read
```
val myfilerddhdfs = sc.textFile("hdfs://localhost:54310/user/hduser/movie/movie.mp4")
myfilerddhdfs.getNumPartitions

```
