package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u2 class_index;
 * u2 name_and_type_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantMethodRefInfo extends ConstantPoolInfo {
  private Integer classIndex;
  private Integer nameAndTypeIndex;
  public ConstantMethodRefInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.classIndex = ClassReader.readUnsignedShort(in);
    this.nameAndTypeIndex = ClassReader.readUnsignedShort(in);
  }
}
