package com.yhsi.avro;

import com.yshi.avro.TestRecord;
import org.apache.avro.Conversions;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumWriter;
import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class LogicalTypeTest {
  Schema schema;

  @BeforeClass
  public void setUp() {
    schema = TestRecord.getClassSchema();
  }

  @Test
  public void testGenericWriter() throws IOException {
    GenericRecordBuilder builder = new GenericRecordBuilder(schema);
    GenericRecord campaign = builder.set("recordId", "test101").build();

    File file = File.createTempFile("campaign", "avro");
    file.deleteOnExit();
    DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
    DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
    dataFileWriter.create(schema, file);
    dataFileWriter.append(campaign);
    dataFileWriter.close();
  }

  @Test
  public void testSpecificWriter() throws IOException {
    TestRecord campaign = TestRecord.newBuilder().
        setRecordId("test102").
        build();
    File file = File.createTempFile("campaign", "avro");
    file.deleteOnExit();
    DatumWriter<TestRecord> datumWriter = new SpecificDatumWriter<TestRecord>(schema);
    DataFileWriter<TestRecord> dataFileWriter = new DataFileWriter<TestRecord>(datumWriter);
    dataFileWriter.create(schema, file);
    dataFileWriter.append(campaign);
    dataFileWriter.close();
  }

  @Test
  public void testGenericDataDeepCopy() throws IOException {
    GenericRecordBuilder builder = new GenericRecordBuilder(schema);
    GenericRecord campaign = builder.
        set("recordId", "test101").
        set("decimalType", new BigDecimal(1.02)).
        build();

    GenericData.get().deepCopy(schema, campaign);
  }

  @Test
  public void testSpecificDataDeepCopyFromGenericRecord() throws IOException {
    GenericRecordBuilder builder = new GenericRecordBuilder(schema);
    GenericData.get().addLogicalTypeConversion(new TimeConversions.DateConversion());
    GenericData.get().addLogicalTypeConversion(new TimeConversions.TimeConversion());
    GenericData.get().addLogicalTypeConversion(new TimeConversions.TimestampConversion());
    GenericData.get().addLogicalTypeConversion(new Conversions.DecimalConversion());
    GenericRecord campaign = builder.
        set("recordId", "test101").
        set("decimalType", ByteBuffer.wrap(new BigDecimal(1.02).unscaledValue().toByteArray())).
        set("dateField", 1451606400).
        build();

    TestRecord copied = (TestRecord) SpecificData.get().deepCopy(schema, campaign);

    Assert.assertEquals(copied.getRecordId(), campaign.get("recordId"));
  }

  @Test
  public void testDeepCopy() throws Exception {
    LocalDate dateValue = new LocalDate(2016,1,1);
    TestRecord campaign = TestRecord.newBuilder().
        setRecordId("test102").
        setLongField(1L).
        setIntField(2).
        setDateField(dateValue).
        build();
    SpecificData.get().deepCopy(campaign.getSchema(), campaign);
  }
}
