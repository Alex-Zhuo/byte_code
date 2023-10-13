package cn.alex.classFile;

import java.io.DataInputStream;
import lombok.Data;

@Data
public class Field {

  public Field(DataInputStream in){

  }

  /**
   * u2
   */
  private Integer accessFlags;
  /**
   * u2
   */
  private Integer nameIndex;
  /**
   * u2
   */
  private Integer descriptionIndex;
  /**
   * u2
   */
  private Integer attributeCount;
  private AttributeInfo[] attributeInfos;

  @Data
  public static class AttributeInfo {
    /**
     * u2
     */
    private Integer nameIndex;
    /**
     * u4
     */
    private Integer attributeLength;

  }
}
