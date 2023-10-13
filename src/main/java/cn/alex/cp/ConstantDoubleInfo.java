package cn.alex.cp;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConstantDoubleInfo extends ConstantPoolInfo{

  private Integer highBytes;
  private Integer lowBytes;
  public ConstantDoubleInfo(DataInputStream in, Integer tag) throws IOException {
    super(in, tag);
    this.highBytes = ClassReader.readInt(in);
    this.lowBytes = ClassReader.readInt(in);
  }
}
