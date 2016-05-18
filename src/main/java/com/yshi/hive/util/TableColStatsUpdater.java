package com.yshi.hive.util;

import com.google.common.collect.Lists;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.*;
import org.apache.thrift.TException;

import java.util.List;

public class TableColStatsUpdater {
  private HiveMetaStoreClient getMetaStoreClt() throws MetaException {
    HiveConf conf = new HiveConf();
    return new HiveMetaStoreClient(conf);
  }

  public void updateColStats(String dbName, String tableName) throws TException {
    HiveMetaStoreClient client = getMetaStoreClt();
    Table tbl = client.getTable(dbName, tableName);

    List<ColumnStatisticsObj> statsObjLst = Lists.newArrayList();
    for (FieldSchema col : tbl.getSd().getCols()) {
      String colName = col.getName();
      String colType = col.getType();
      ColumnStatisticsData data = createStatsData(colType);
      if (data != null) {
        System.out.println("creating stats info for column " + colName +
            " with type " + colType);
        statsObjLst.add(new ColumnStatisticsObj(colName, colType, data));
      } else {
        System.err.println("WARN: ignoring column " + colName +
            " with type " + colType);
      }
    }
    ColumnStatisticsDesc desc = new ColumnStatisticsDesc(true, dbName, tableName);
    ColumnStatistics stats = new ColumnStatistics(desc, statsObjLst);
    System.out.println("Updating stats info for " + dbName + '.' + tableName);
    client.updateTableColumnStatistics(stats);
    System.out.println("Successfully updated stats info for " + dbName + '.' + tableName);
  }

  private ColumnStatisticsData createStatsData(String type) {
    ColumnStatisticsData data = new ColumnStatisticsData();
    if (type.equals("string") || type.startsWith("char") || type.startsWith("varchar")) {
      data.setStringStats(new StringColumnStatsData(1024, 256, -1, 111));
    } else if (type.equals("int") || type.equals("bigint") ||
        type.equals("smallint") || type.equals("tinyint")) {
      data.setLongStats(new LongColumnStatsData(-1, 111));
    } else if (type.equals("float") || type.equals("double")) {
      data.setDoubleStats(new DoubleColumnStatsData(-1, 111));
    } else if (type.startsWith("decimal")) {
      data.setDecimalStats(new DecimalColumnStatsData(-1, 111));
    } else if (type.equals("boolean")) {
      data.setBooleanStats(new BooleanColumnStatsData(10, 20, -1));
    } else if (type.equals("binary")) {
      data.setBinaryStats(new BinaryColumnStatsData(100, 33, -1));
    } else if (type.equals("float") || type.equals("double")) {
      data.setDoubleStats(new DoubleColumnStatsData(-1, 111));
    } else {
      return null;
    }

    return data;
  }

  public static void main(String[] args) throws TException {
    if (args.length != 2) {
      System.err.println("Parameters: <db-name> <table-name>");
      return;
    }

    TableColStatsUpdater updater = new TableColStatsUpdater();
    updater.updateColStats(args[0], args[1]);
  }
}
