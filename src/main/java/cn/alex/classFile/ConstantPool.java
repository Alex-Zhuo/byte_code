package cn.alex.classFile;

import cn.alex.cp.ConstantPoolFactory;
import cn.alex.cp.ConstantPoolInfo;
import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConstantPool {

  //u2
  private int count;
  private List<ConstantPoolInfo> pool;

  public ConstantPool(DataInputStream in) throws IOException {
    int cnt = ClassReader.readUnsignedShort(in);
    List<ConstantPoolInfo> pool = new ArrayList<>();
    for (int j = 1; j < cnt; j++) {
      pool.add(ConstantPoolFactory.getCp(in));
    }
    this.count = cnt;
    this.pool = pool;
  }
}
