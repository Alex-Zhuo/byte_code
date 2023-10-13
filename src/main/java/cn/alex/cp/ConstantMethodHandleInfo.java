package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * u1 tag;
 * u1 reference_kind;
 * u2 reference_index;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantMethodHandleInfo extends ConstantPoolInfo {

  private Integer referenceKind;
  private Integer referenceIndex;

  public ConstantMethodHandleInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.referenceKind = ClassReader.readUnsignedByte(in);
    this.referenceIndex = ClassReader.readUnsignedShort(in);
  }
}
