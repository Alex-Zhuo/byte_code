package cn.alex.classFile;

import cn.alex.cp.ConstantPoolFactory;
import cn.alex.cp.ConstantPoolInfo;
import cn.alex.util.ClassReader;
import com.alibaba.fastjson2.JSONObject;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassFile {

  /**
   * u4
   */
  public int magic;
  /**
   * u2
   */
  public int minorVersion;
  /**
   * u2
   */
  public int majorVersion;
  /**
   * u2
   */
  public int constantPoolCount;
  /**
   * constantPoolCount
   */
  public ConstantPoolInfo[] constantPool;
  /**
   * u2
   */
  public int accessFlags;
  /**
   * u2
   */
  public int thisClass;
  /**
   * u2
   */
  public int superClass;
  /**
   * <p>u2</p>
   * If the value of the super_class item is zero,
   * then this class file must represent the class Object,
   * the only class or interface without a direct superclass.
   */
  public int interfaceCount;
  /**
   * <p>interfaceCount</p>
   * Each value in the interfaces array must be a valid index into the constant_pool table
   */
  public int[] interfaces;
  /**
   * u2
   */
  public int fieldCount;
  /**
   * fieldCount
   */
  public Field[] fields;
  /**
   * u2
   */
  public int methodCount;
  /**
   * methodCount
   */
  public Method[] methods;
  /**
   * u2
   */
  public int attributeCount;
  /**
   * attributeCount
   */
  public Attributes attributes;

  public ClassFile(DataInputStream in) {
    try {
      //magic: 0xCAFEBABE
      this.magic = ClassReader.readInt(in);
      System.out.println("magic: >>> " + this.magic);
      this.minorVersion = ClassReader.readUnsignedShort(in);
      System.out.println("minorVersion: >>> " + this.minorVersion);
      this.majorVersion = ClassReader.readUnsignedShort(in);
      System.out.println("majorVersion: >>> " + this.majorVersion);
      this.constantPoolCount = ClassReader.readUnsignedShort(in);
      System.out.println("constantPoolCount: >>> " + this.constantPoolCount);
      this.constantPool = new ConstantPoolInfo[this.constantPoolCount];
      for (int i = 1; i < this.constantPoolCount; i++) {
        ConstantPoolInfo cp = ConstantPoolFactory.getCp(in);
        this.constantPool[i] = cp;
        System.out.println(
            "constantPool[" + i + "]: " + cp.getClass().getSimpleName() + " >>> " + JSONObject.toJSONString(cp));
      }
      this.accessFlags = ClassReader.readUnsignedShort(in);
      System.out.println("\naccessFlags: >>> " + this.accessFlags);
      //this class name index in constant pool
      this.thisClass = ClassReader.readUnsignedShort(in);
      System.out.println("thisClass: >>> " + this.thisClass);
      //super class name index in constant pool
      this.superClass = ClassReader.readUnsignedShort(in);
      System.out.println("superClass: >>> " + this.superClass);
      //interface count
      this.interfaceCount = ClassReader.readUnsignedShort(in);
      System.out.println("interfaceCount: >>> " + this.interfaceCount);
      this.interfaces = new int[this.interfaceCount];
      for (int i = 0; i < this.interfaceCount; i++) {
        int f = ClassReader.readUnsignedShort(in);
        this.interfaces[i] = f;
        System.out.println("interfaces[" + i + "] >>> " + f);
      }
      //field count
      this.fieldCount = ClassReader.readUnsignedShort(in);
      System.out.println("fieldCount: >>> " + this.interfaceCount);
      this.fields = new Field[this.fieldCount];
      for (int i = 0; i < this.fieldCount; i++) {
        Field field = new Field(in);
        this.fields[i] = field;
        System.out.println("fields[" + i + "] >>> " + JSONObject.toJSONString(field));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ClassFile(String path) throws FileNotFoundException {
    this(new DataInputStream(new FileInputStream(path)));
  }

  public static void main(String[] args) throws FileNotFoundException {
    ClassFile classFile = new ClassFile("/Users/alex/idea/byte_code/target/classes/cn/alex/Main.class");
  }
}
