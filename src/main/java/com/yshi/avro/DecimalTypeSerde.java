package com.yshi.avro;

import org.apache.avro.Conversions;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class DecimalTypeSerde {

  private static final String AVSC_FILE_NAME = "TestCampaign.avsc";

  public static void main (String[] args) throws IOException {

    Schema schema = new Schema.Parser().parse(
        DecimalTypeSerde.class.getClassLoader().getResourceAsStream(AVSC_FILE_NAME));
    GenericRecord campaign = new GenericData.Record(schema);
    campaign.put("orgId", 1L);
    campaign.put("currencyCost", new BigDecimal(101.11).setScale(2, BigDecimal.ROUND_CEILING));

    File file = new File("/tmp/campaign.avro");
    GenericDatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
    datumWriter.getData().addLogicalTypeConversion(new Conversions.DecimalConversion());
    DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
    dataFileWriter.create(schema, file);
    dataFileWriter.append(campaign);
    dataFileWriter.close();
  }
}
