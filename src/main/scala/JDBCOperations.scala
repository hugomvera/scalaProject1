class JDBC(tickerIn:String,money:Double,strategy:String) {
// this class will save on a database
  import java.sql.DriverManager
  import java.sql.Connection
  import java.sql.PreparedStatement
  import java.sql.SQLException



      println("Mysql writing to database")
      val driver = "com.mysql.cj.jdbc.Driver"
      val url = "jdbc:mysql://localhost:3306/testConnection"
      val username = "prog"
      val password = "Password"


  def saveToDataBase(): Unit = {
    var connection:Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val str1 = "INSERT INTO buyAndHold (ticker,profitLoss,strategy) VALUES (" + '"' +tickerIn  + '"'+","+ money+","+'"'+ strategy + '"'    +      ");"
    System.out.println(str1)
    val inputToDatabase =  statement.executeUpdate(str1)
    //val resultSet = statement.executeQuery("SELECT * FROM buyAndHold;")
    //      println(resultSet)
    //      while ( resultSet.next() ) {
    //        println(resultSet.getString(1)+", " +resultSet.getString(2) )
    //      }
    connection.close()
  }



  def showToDataBase(): Unit = {
    System.out.println("########  SHowing data       ############")
    var connection:Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
   // val inputToDatabase =  statement.executeUpdate("INSERT INTO buyAndHold (ticker,profitLoss) VALUES (\"" +tickerIn +"\","+money+");")
    val resultSet = statement.executeQuery("SELECT * FROM buyAndHold;")
          while ( resultSet.next() ) {
            println(resultSet.getString(1)+", " +resultSet.getString(2) +", " +resultSet.getString(3))
          }
    connection.close()
    System.out.println("########  Stop SHowing Data      ############")
  }


}
