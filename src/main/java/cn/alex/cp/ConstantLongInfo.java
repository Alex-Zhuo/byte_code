package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  u1 tag;
 *     u4 high_bytes;
 *     u4 low_bytes;
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantLongInfo extends ConstantPoolInfo{
  private Integer highBytes;
  private Integer lowBytes;
  public ConstantLongInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.highBytes = ClassReader.readInt(in);
    this.lowBytes = ClassReader.readInt(in);
  }
}
