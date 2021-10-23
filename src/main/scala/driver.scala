import scala.annotation.tailrec

object driver extends App {

// val stk1 = new Stonk("BA");
 //System.out.println(stk1.ticker)
// System.out.println( "out of the header")
//System.out.println(stk1.Header)
// System.out.println(stk1.high)
// val stk1 = new TradeStonk("BA",1);
// System.out.println("the sticker name is " + stk1.ticker)
// System.out.println("the sticker sumOfmoney is " + stk1.SumMoney)
//
// System.out.println("the sticker name starting price is " + stk1.high(1))
//
// System.out.println("the sticker name starting price is " + stk1.high(stk1.high.size-1))
//
// stk1.buyAndHold()
// System.out.println("the buy and hold yields " + stk1.SumMoney + "increase")

  var ticker = "none"
 System.out.println("type the stock  ticker symbol ");/* do this */
  @tailrec
  final def printMenu():Unit = {
    println("Put in a ticker: ")
    println("press x to exit")
    println("press t1 to buy and hold")
    println("press s1 to short and hold")
    println("press s to show all trades made ")
    val cmd = scala.io.StdIn.readLine()
    cmd match{
      case "s" => {
        //return Some("Foo")
        val databaseS = new JDBC("dummy",1 ,"dummy")
        databaseS.showToDataBase()
        printMenu()
      }

      case "x" => return None
      case "t1" =>
        val stk2 = new TradeStonk(ticker,1)
        stk2.buyAndHold();
        val database1 = new JDBC(ticker,stk2.SumMoney,"BuyAndHold" )
        database1.saveToDataBase()
        System.out.println("the buy and hold yields " + stk2.SumMoney + "  X increase")
        printMenu();
      case "s1" =>
        val stk2 = new TradeStonk(ticker,1)
        stk2.shortAndHold();
        val database1 = new JDBC(ticker,stk2.SumMoney ,"ShortAndHold")
        database1.saveToDataBase()
        System.out.println("the buy and hold yields " + stk2.SumMoney + "  X increase")
        printMenu();
      case _ =>
        ticker = cmd
        printMenu();
    }
  }

  printMenu()



}