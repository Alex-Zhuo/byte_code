package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u2 length;
 * u1 bytes[length];
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantUtf8Info extends ConstantPoolInfo {

  private Integer length;
  private byte[] bytes;

  public ConstantUtf8Info(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    int len = ClassReader.readUnsignedShort(in);
    this.length = len;
    byte[] data = new byte[len];
    for (int i = 0; i < len; i++) {
      data[i] = (byte) ClassReader.readUnsignedByte(in);
    }
    this.bytes = data;
  }
}
