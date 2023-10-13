package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u2 name_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantModuleInfo extends ConstantPoolInfo {

  private Integer nameIndex;

  public ConstantModuleInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.nameIndex = ClassReader.readUnsignedShort(in);
  }
}
