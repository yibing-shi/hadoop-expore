package com.yshi.hive.util;

import org.apache.hive.service.cli.HandleIdentifier;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.UUID;

/**
 * Created by yshi on 31/3/17. Free to use.
 * Contact shi.yibing@gmail.com when necessary.
 */
public class HandleIdConverter {
  public static UUID convertTHandleGuid(String guid) {
    if (guid.length() != 32) {
      throw new InvalidParameterException("GUID should be 32 chars long. Got [" + guid + "] instead");
    }

    long mostSignificant = new BigInteger(guid.substring(0, 16), 16).longValue();
    long leastSignificant = new BigInteger(guid.substring(16, 32), 16).longValue();
    return new UUID(mostSignificant, leastSignificant);
  }

  public static void main(String[] args) {
    HandleIdentifier hiveId = new HandleIdentifier(UUID.fromString("823fae65-03b1-40e9-a2d4-988e052f150c"), UUID.randomUUID());
    for (byte b : hiveId.toTHandleIdentifier().getGuid()) {
      System.out.print(String.format("%02x", b));
    }
    System.out.println();

    System.out.println(HandleIdConverter.convertTHandleGuid("823fae6503b140e9a2d4988e052f150c"));
  }
}
