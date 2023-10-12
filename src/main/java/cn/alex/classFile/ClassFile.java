package cn.alex.classFile;

public class ClassFile {

  public int magic;
  public int minor_version;
  public int major_version;
  public ConstantPool constant_pool;
  public AccessFlags access_flags;
  public int this_class;
  public int super_class;
  public int[] interfaces;
  public Field[] fields;
  public Method[] methods;
  public Attributes attributes;
}
