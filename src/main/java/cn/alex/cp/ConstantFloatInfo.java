package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u4 bytes;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantFloatInfo extends ConstantPoolInfo {

  private Integer bytes;

  public ConstantFloatInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.bytes = ClassReader.readInt(in);
  }
}
