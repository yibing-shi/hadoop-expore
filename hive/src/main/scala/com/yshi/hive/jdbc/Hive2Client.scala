package com.yshi.hive.jdbc

import java.sql.DriverManager

object Hive2ClientScala {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    val conn = DriverManager.getConnection("jdbc:hive2://yshi-4.gce.cloudera.com:10000/default", "hive", "")
    val stmt = conn.createStatement()
    val rs = stmt.executeQuery("select * from c135258.bigskew limit 0")
    val md = rs.getMetaData
    val cols = new Iterator[String] {
      var i = 0
      override def hasNext : Boolean = {i < md.getColumnCount}
      override def next() : String = {
        i = i + 1
        md.getColumnName(i)
      }
    }
    for (colName <- cols.toStream) {
      println(colName)
    }
  }
}

