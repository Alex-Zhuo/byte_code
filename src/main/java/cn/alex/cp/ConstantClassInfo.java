package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * u1 tag;
 * u2 name_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantClassInfo extends ConstantPoolInfo {

  private Integer nameIndex;

  public ConstantClassInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.nameIndex = ClassReader.readUnsignedShort(in);
  }
}
