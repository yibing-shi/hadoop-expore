package com.yshi.hive;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.hadoop.hive.cli.CliDriver;
import org.apache.hadoop.hive.cli.CliSessionState;
import org.apache.hadoop.hive.common.LogUtils;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.session.SessionState;

public class RunHQLScript {
  private static class MyCliSessionState extends CliSessionState {
    String host;
    int port;
    public MyCliSessionState(HiveConf conf, String host, int port) {
      super(conf);
      this.host = host;
      this.port = port;
    }
  }

  private static void printProperties(Properties props) {
    System.out.println("*** Printing properties from file ***");
    for (Iterator<Map.Entry<Object, Object>> it = props.entrySet()
        .iterator(); it.hasNext();) {
      Map.Entry<Object, Object> entry = it.next();
      System.out.println((String) entry.getKey() + "="
          + entry.getValue().toString());
    }
  }

  private static void printConf(HiveConf conf) {
    System.out.println("\n*** Printing configs from hiveconf ***");
    Properties props = conf.getAllProperties();
    for (Iterator<Map.Entry<Object, Object>> it = props.entrySet()
        .iterator(); it.hasNext();) {
      Map.Entry<Object, Object> entry = it.next();
      System.out.println((String) entry.getKey() + "="
          + entry.getValue().toString());
    }
  }

  private static void updateConf(HiveConf conf, Properties props) {
    for (Iterator<Map.Entry<Object, Object>> it = props.entrySet()
        .iterator(); it.hasNext();) {
      Map.Entry<Object, Object> entry = it.next();
      conf.set((String) entry.getKey(), entry.getValue().toString());
    }
  }

  public static void main(String[] args) throws Exception {
    LogUtils.initHiveLog4j();
    System.out.println("hellloo ");
    HiveConf conf = new HiveConf(SessionState.class);

    Properties props = new Properties();

    try {
      props.load(new FileInputStream("hadoop.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    //add site xmls to conf
    conf.addResource("core-site.xml");
    conf.addResource("hdfs-site.xml");
    conf.addResource("hive-site.xml");
    conf.addResource("mapred-site.xml");
    conf.addResource("yarn-site.xml");

    printProperties(props);
    updateConf(conf, props);
    printConf(conf);

    CliSessionState ss = new MyCliSessionState(conf, "", 0);

    ss.in = System.in;
    ss.out = new PrintStream(System.out, true, "UTF-8");
    ss.err = new PrintStream(System.err, true, "UTF-8");
/*
 *         ss.connect();
 *                 System.out.println("ss.connect issued: " + ss.getSessionId());
 *                 */

    SessionState.start(ss);
    CliDriver cli = new CliDriver();

    String tableName1 = "infaTbl1";
    String tableName2 = "infaTbl2";

    System.out.println("calling show DATABASES");
    cli.processLine("SHOW DATABASES");

    System.out.println("cli command issued");
    cli.processLine("DROP TABLE IF EXISTS " + tableName1);
    cli.processLine("DROP TABLE IF EXISTS " + tableName2);
    cli.processLine("create table " + tableName1 + " (name STRING, num STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ','");
    cli.processLine("create table " + tableName2 + " (name STRING, num STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ','");
    System.out.println("cli command completed");


    System.out.println("calling describe");
    cli.processLine("DESCRIBE " + tableName1);
    cli.processLine("DESCRIBE " + tableName2);

    System.out.println("calling load data");
    cli.processLine("LOAD DATA LOCAL INPATH './tabledata' INTO TABLE " + tableName1);

    System.out.println("calling select on " + tableName1);
    cli.processLine("SELECT * FROM " + tableName1);

    System.out.println("calling insert overwrite into " + tableName2);
    cli.processLine("INSERT OVERWRITE TABLE " + tableName2 + " SELECT * FROM " + tableName1);


    System.out.println("calling select on " + tableName2);
    cli.processLine("SELECT * FROM " + tableName2);

    ss.close();
  }
}

