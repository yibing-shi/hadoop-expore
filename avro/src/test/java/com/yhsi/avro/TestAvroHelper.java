package com.yhsi.avro;

import com.yshi.avro.AvroHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.ByteBuffer;


public class TestAvroHelper {
  public static class TestAvroData {
    private ByteBuffer data;

    public TestAvroData() {
    }

    public void setData(ByteBuffer data) {
      this.data = data;
    }

    public ByteBuffer getData() {
      return this.data;
    }
  }

  private AvroHelper<TestAvroData> helper;

  @BeforeClass
  public void setup() {
    helper = new AvroHelper<TestAvroData>(TestAvroData.class);
  }

  @Test
  public void testAvroHelper() throws IOException {

    TestAvroData data = new TestAvroData();
    data.setData(ByteBuffer.wrap("hello".getBytes()));

    byte[] adata = helper.toAvroBytes(data);
    TestAvroData data1 = helper.fromAvroBytes(adata);
    Assert.assertNotNull(data1);
  }
}
