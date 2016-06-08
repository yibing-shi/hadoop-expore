package com.yhsi.avro;

import com.yshi.avro.TestRecord;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

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
}
