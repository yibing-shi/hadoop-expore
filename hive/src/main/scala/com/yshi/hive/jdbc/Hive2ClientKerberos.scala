package com.yshi.hive.jdbc

import java.security.PrivilegedExceptionAction
import java.sql.{Connection, DriverManager, ResultSet, Statement}

import org.apache.commons.dbutils.DbUtils
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.security.UserGroupInformation

object Hive2ClientScala {
  def main(args: Array[String]): Unit = {
    if (args.length != 4) {
      System.err.println("Usage: java Hive2ClientKerberos <jdbc-url> <krb5.conf-path> <principal> <keytab-file-path>")
      return
    }

    val jdbcUrl = args(0)
    val krb5ConfFile = args(1)
    val principal = args(2)
    val keytabFilePath = args(3)

    Class.forName("org.apache.hive.jdbc.HiveDriver")

    val conf = new Configuration()
    conf.set("hadoop.security.authentication", "kerberos")
    conf.set("java.security.krb5.conf", krb5ConfFile)
    UserGroupInformation.setConfiguration(conf)
    UserGroupInformation.loginUserFromKeytab(principal, keytabFilePath)

    var db:Connection = null
    var stmt:Statement = null
    var rs:ResultSet = null
    try {
      db = UserGroupInformation.getLoginUser().doAs(new PrivilegedExceptionAction[Connection] {
        override def run(): Connection = DriverManager.getConnection(getWholeJdbcUrl(jdbcUrl, principal), "hive", "")
      })
      stmt = db.createStatement()
      rs = stmt.executeQuery("show databases")

      while (rs.next()) {
        System.out.println(rs.getString(1))
      }
    } finally {
      DbUtils.closeQuietly(db, stmt, rs)
    }
  }

  def getWholeJdbcUrl (jdbcUrl: String, servicePrincipal: String):String = {
    if (jdbcUrl.contains(";principal="))
      jdbcUrl
    else
      jdbcUrl + ";principal=" + servicePrincipal
  }
}

