class TradeStonk(tickerIn:String,money:Double)  extends Stonk(tickerIn:String){

  //will trade here
  var SumMoney = money;


  def buyAndHold(): Unit = {

    SumMoney = (this.high(this.high.size-1)-  this.high(1))/(this.high(1)) * SumMoney

  }


  def shortAndHold(): Unit = {

    SumMoney = (  this.high(1)  - this.high(this.high.size-1))/(this.high(1)) * 1

  }


}
