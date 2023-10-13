package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u2 name_index;
 * u2 descriptor_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantNameAndTypeInfo extends ConstantPoolInfo {

  private Integer nameIndex;
  private Integer descriptorIndex;

  public ConstantNameAndTypeInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.nameIndex = ClassReader.readUnsignedShort(in);
    this.descriptorIndex = ClassReader.readUnsignedShort(in);
  }
}
