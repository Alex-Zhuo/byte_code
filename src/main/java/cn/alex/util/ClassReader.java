package cn.alex.util;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassReader {

  public static int readUnsignedByte(DataInputStream in) throws IOException {
    return in.readUnsignedByte();
  }

  public static int readUnsignedShort(DataInputStream in) throws IOException {
    return in.readUnsignedShort();
  }

  public static int readInt(DataInputStream in) throws IOException {
    return in.readInt();
  }

  public static long readLong(DataInputStream in) throws IOException {
    return in.readLong();
  }

  public static float readFloat(DataInputStream in) throws IOException {
    return in.readFloat();
  }

  public static double readDouble(DataInputStream in) throws IOException {
    return in.readDouble();
  }

  public static String readUTF(DataInputStream in) throws IOException {
    return in.readUTF();
  }
}
