package cn.alex.cp;

import java.io.DataInputStream;
import lombok.Data;

@Data
public class ConstantPoolInfo {

  private Integer tag;

  ConstantPoolInfo(){

  }
  public ConstantPoolInfo(DataInputStream in, Integer tag) {
    this.tag = tag;
    System.out.println("start analysis " + this.getClass().getName());
  }
}
