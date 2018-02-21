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
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/scala1.PNG)
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
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/local.PNG)

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
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/scala%20hdfs1.PNG)

#### step-2
1. go to the scala terminal
2. use the following code to read
```
val myfilerddhdfs = sc.textFile("hdfs://localhost:54310/user/hduser/movie/movie.mp4")
myfilerddhdfs.getNumPartitions

```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/scala%20hdfs%202.PNG)
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/hdfs%203.PNG)

## Transformations 
#### Example 1
incNUM is mapping to the myrdd 
```
val myNum=List(1,2,3,4,5)
val myrdd = sc.makeRDD(mynum)
val incNum = myrdd.map(v=>(v+1))
incNum.collect()
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/transf1.PNG)

#### Example 2
```
val myNum=List(1,2,3,4,5)
val myrdd = sc.makeRDD(mynum)
val incNum = myrdd.map(v=>(v,1))
incNum.collect()
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/transf1.PNG)

### Parell 2 in eclipse

```
package bigdata.spark_applications

import org.apache.spark.SparkConf

import org.apache.spark.SparkContext

import org.apache.spark.SparkContext._

object Mymapdemo {

  def myinc(a:Int):Int={

    var b=a+1

    return b

  }

def main(args:Array[String]) = {
//We are creating a spark context object and also naming it

val conf = new SparkConf().setAppName("my map demo").setMaster("local")

val sc = new SparkContext(conf)
val myrdd=sc.parallelize(List(1,2,3,4,5,6,7,8,9),2)

val inc_rdd = myrdd.map(myinc)

inc_rdd.foreach(println)

System.in.read()

sc.stop()

  }
}
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/parell1.PNG)

#### Program for the string reverse 

```
package bigdata.spark_applications
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._


object Mymapdemo {
 
 def myrev(a:String):String={
   var   String = (for(i <- a.length - 1 to 0 by -1) yield a(i)).mkString

   return String
 }
 
def main(args:Array[String]) = {

//We are creating a spark context object and also naming it
val conf = new SparkConf().setAppName("my map demo").setMaster("local")
val sc = new SparkContext(conf)

val myrdd=sc.parallelize(List("hello","world"),2)
val inc_rdd = myrdd.map(myrev)
inc_rdd.foreach(println)
System.in.read()
sc.stop()

 }

}

```

### Understanding flatMap
#### Slpitting the words using space
```
val sent = List("This is Bangalore city")
val myrdd = sc.makeRDD(sent)
val mywords = myrdd.flatMap(_.split(" "))
mywords.collect()
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/split1.PNG)

#### Seprating the elements that are dividible by 2
```
val mynum=List(1,2,3,4,5)
val myrdd = sc.makeRDD(mynum)
val filtered_rdd = myrdd.filter(v=>(v%2 == 0))
filtered_rdd.collect
```

### Understanding map partitions

1. This is an API which is used to perform an operation on an individual partition as a whole API's like map.
2. Map used to perfom transformation basically row-by-row
3. whereas the mapPartitions API will allow us to iterate over all the elements of a parition at will.

#### What kind of operations nedds mapParitions ?
1. Some kind of special reducer logic 
2. What if we want to do an operation on the data set which is a sequential operation 
3. Finding the min or max within a partition (on a dataset which contains numbers

#### Program 4
1. In a spark program, if we pass a function to map partitions as an argument, that function must return an iterator ! 
2. only it returns an iterator, but also takes an iterator as an argument ! 
```
def myfunc(nums:Iterator[Int]): Iterator[Int]= {

    var sum = 0

  
    while(nums.hasNext) {sum=sum+nums.next}
 
    val myit = Iterator(sum)
    return myit
}

val myrdd = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10))
val myx = myrdd.mapPartitions(myfunc)
myx.collect
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/iterator.PNG)

#### using list
I am returning an iterator which containts a list (partition number, and the sum of numbers in that partition)
```
def myfunc(mycount:Int,nums:Iterator[Int]): Iterator[List[Int]] = { 



    var sum = 0

  
    while(nums.hasNext) {sum=sum+nums.next}
  
    val myit = Iterator(List(mycount,sum))
    return(myit)
}

val myrdd = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10))
val myx = myrdd.mapPartitionsWithIndex(myfunc)
myx.collect
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/index%20ex.PNG)

### Program to print the front 10 words and back 10 words 

```
def funcpartitionstring(numbers : Iterator[String]) : Iterator[scala.collection.mutable.ListBuffer[String]] =
{
val pattern = """(?:[a-zA-Z'-]+[^a-zA-Z'-]+){0,10}\b(blood)\b(?:[^a-zA-Z'-]+[a-zA-Z'-]+){0,10}""".r
val pattern1 = """(?:[a-zA-Z'-]+[^a-zA-Z'-]+){0,10}\b(kill)\b(?:[^a-zA-Z'-]+[a-zA-Z'-]+){0,10}""".r
val pattern1 = """(?:[a-zA-Z'-]+[^a-zA-Z'-]+){0,10}\b(dead)\b(?:[^a-zA-Z'-]+[a-zA-Z'-]+){0,10}""".r

var li= numbers.mkString
var initial=0
var si=li.size
import scala.collection.mutable.ListBuffer
val res = new ListBuffer[String]()

res +=(pattern findAllIn li).mkString("\n")
res +=(pattern1 findAllIn li).mkString("\n")

val res2 = Iterator(res)
return res2
}
 
val myfilerddhdfsmovie = sc.textFile("hdfs://localhost:54310/user/hduser/books/born_on_crime.txt")
var d = myfilerddhdfsmovie.mapPartitions(funcpartitionstring)
d.foreach(println)
```

### Unioun Operation 
```
val myrdd1 = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10))
val myrdd2 = sc.parallelize(List(50,60,70))
val u = myrdd1.union(myrdd2)
u.collect
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/unioun.PNG)
### Intersections
```
val myrdd1 = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10))
val myrdd2 = sc.parallelize(List(50,60,70,10))
val u = myrdd1.intersection(myrdd2)
u.collect
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/intersaction.PNG)
### distinct Opeartion
```
val myrdd = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10,10))
val uniq = myrdd.distinct()
uniq.collect
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/distinct.PNG)
### Understanding groupBykey and reduceByke

#### Getting the list of the words
```
val sent = sc.makeRDD(List("Hello hi how are you hi I am hello"))
val mywords = sent.flatMap(_.split(" ")) 
mywords.collect
```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/mywords.PNG)
#### Group By
```
val sent = sc.makeRDD(List("Hello hi how are you hi I am hello"))
val mywords = sent.flatMap(_.split(" "))  

val mykv = mywords.map(words => (words,1)) 

val mywc = mykv.groupByKey() 
val myfinalsc = mywc.map(a=>(a._1,a._2.sum))
myfinalsc.collect

```
![alt text](https://github.com/udayallu/Scala/blob/master/Scala%20Images/group_by.PNG)
#### Reduce By
