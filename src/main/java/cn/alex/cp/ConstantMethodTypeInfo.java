package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u2 descriptor_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantMethodTypeInfo extends ConstantPoolInfo {

  private Integer descriptorIndex;
  public ConstantMethodTypeInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.descriptorIndex = ClassReader.readUnsignedShort(in);
  }
}
