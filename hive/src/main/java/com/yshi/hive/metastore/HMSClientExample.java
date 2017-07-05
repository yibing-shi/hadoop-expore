package com.yshi.hive.metastore;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.SerDeInfo;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.thrift.TException;

import java.util.Arrays;

public class HMSClientExample {
  public static void main(String[] args) throws TException {
    FieldSchema fieldSchema = new FieldSchema("column", "int", "keyword as name");
    SerDeInfo serDeInfo = new SerDeInfo();
    StorageDescriptor sd = new StorageDescriptor();
    sd.setCols(Arrays.asList(fieldSchema));
    sd.setInputFormat("org.apache.hadoop.mapred.TextInputFormat");
    sd.setOutputFormat("org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat");
    sd.setSerdeInfo(serDeInfo);

    Table table = new Table();
    table.setDbName("default");
    table.setTableName("table");

    table.setSd(sd);

    HiveConf conf = new HiveConf();
    HiveMetaStoreClient client = new HiveMetaStoreClient(conf);
    client.createTable(table);
  }
}
