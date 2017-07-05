package com.yhsi.avro;

import com.yshi.avro.TestRecord;
import org.apache.avro.Conversion;
import org.apache.avro.Conversions;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

public class LogicalTypeTest {
  Schema schema;
  MutableDateTime epoch;

  @BeforeClass
  public void setUp() {
    schema = TestRecord.getClassSchema();
    epoch = new MutableDateTime();
    epoch.setDate(0); //Set to Epoch time
  }

  @Test
  public void testGenericWriter() throws IOException {
    GenericRecordBuilder builder = new GenericRecordBuilder(schema);
    GenericRecord record = builder
        .set("recordId", "test101")
        .set("intArrayField", Arrays.asList(1, 2, 3))
        .set("dateArrayField", Arrays.asList(Days.daysBetween(epoch, new DateTime()).getDays()))
        .build();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(8192);
    DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
    Encoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
    datumWriter.write(record, encoder);

    encoder.flush();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
    Decoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
    DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
    GenericRecord readOut = reader.read(null, decoder);
    readOut.get(0);
    Assert.assertEquals(readOut, record, "should be the same");
  }

  @Test
  public void testSpecificWriter() throws IOException {
    TestRecord campaign = TestRecord.newBuilder()
        .setRecordId("test102")
        .setIntArrayField(Arrays.asList(1, 2, 3))
        .setDateArrayField(Arrays.asList(new LocalDate()))
        .build();
    DatumWriter<TestRecord> datumWriter = new SpecificDatumWriter<TestRecord>(schema);
    final ByteArrayOutputStream out = new ByteArrayOutputStream(8192);
    final Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
    datumWriter.write(campaign, encoder);
    encoder.flush();

    final InputStream in = new ByteArrayInputStream(out.toByteArray());
    final Decoder decoder = DecoderFactory.get().binaryDecoder(in, null);
    final DatumReader<TestRecord> reader = new SpecificDatumReader<TestRecord>(schema);
    TestRecord readOut = reader.read(null, decoder);

    Assert.assertEquals(readOut, campaign);
  }

  @Test
  public void testGenericDataDeepCopy() throws IOException {
    TestRecord campaign = TestRecord.newBuilder()
        .setRecordId("test102")
        .setLongField(1L)
        .setIntField(2)
        .setIntArrayField(Arrays.asList(1, 2, 3))
        .setDateArrayField(Arrays.asList(new LocalDate()))
        .build();

    GenericData.get().deepCopy(schema, campaign);
  }

  @Test
  public void testSpecificDataDeepCopyFromGenericRecord() throws IOException {
    GenericRecordBuilder builder = new GenericRecordBuilder(schema);
    GenericRecord record = builder
        .set("recordId", "test101")
        .set("intArrayField", Arrays.asList(1, 2, 3))
        .set("dateArrayField", Arrays.asList(Days.daysBetween(epoch, new DateTime()).getDays()))
        .build();

    SpecificData data = new SpecificData();
    GenericRecord copied = data.deepCopy(schema, record);

    Assert.assertEquals(copied.get("recordId"), record.get("recordId"));
  }

  @Test
  public void testDeepCopy() throws Exception {
    TestRecord campaign = TestRecord.newBuilder()
        .setRecordId("test102")
        .setLongField(1L)
        .setIntField(2)
        .setIntArrayField(Arrays.asList(1, 2, 3))
        .setDateArrayField(Arrays.asList(new LocalDate()))
        .build();
    SpecificData data = new SpecificData();
    data.deepCopy(campaign.getSchema(), campaign);
  }
}
