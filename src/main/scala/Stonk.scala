import java.util.ArrayList
import scala.collection.mutable.ArrayBuffer
class Stonk(tickerIn:String) {



   val ticker = tickerIn

  //private val Header = new util.ArrayList[Double]()
  var Header = ArrayBuffer[String]()
  var date = ArrayBuffer[String]()
  var high = ArrayBuffer[Double]()
  var low = ArrayBuffer[Double]()
  var open = ArrayBuffer[Double]()
  var close = ArrayBuffer[Double]()
   var volume =ArrayBuffer[Double]()
   var adjclose = ArrayBuffer[Double]()

  //Reading the file of sticker symbol
   // println("Month, Income, Expenses, Profit")
    val stockFile= "/home/hugo/Documents/stocks/"+ ticker +".csv"
    val bufferedSource = io.Source.fromFile(stockFile)
    var count = 0 ;
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      if(count ==0){
        this.Header += cols(0)
        this.Header += cols(1)
        this.Header += cols(2)
        this.Header += cols(3)
        this.Header += cols(4)
        this.Header += cols(5)
        this.Header += cols(6)
        count = 1+ count
      }

      else {
        this.date += cols(0)
        this.high += cols(1).toDouble
        this.low  += cols(2).toDouble
        this.open += cols(4).toDouble
        this.close += cols(3).toDouble
        this.volume += cols(5).toDouble
        this.adjclose += cols(6).toDouble
        count = 1+ count
      }
     // println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    bufferedSource.close





  }







