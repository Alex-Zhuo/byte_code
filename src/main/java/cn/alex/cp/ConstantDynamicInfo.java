package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u2 bootstrap_method_attr_index;
 * u2 name_and_type_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantDynamicInfo extends ConstantPoolInfo {

  private Integer bootstrapMethodAttrIndex;
  private Integer nameAndTypeIndex;
  public ConstantDynamicInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.bootstrapMethodAttrIndex = ClassReader.readUnsignedShort(in);
    this.nameAndTypeIndex = ClassReader.readUnsignedShort(in);
  }
}
