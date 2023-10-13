package cn.alex.cp;

import static cn.alex.constant.ConstantPool.CONSTANT_CLASS;
import static cn.alex.constant.ConstantPool.CONSTANT_DOUBLE;
import static cn.alex.constant.ConstantPool.CONSTANT_DYNAMIC;
import static cn.alex.constant.ConstantPool.CONSTANT_FIELD_REF;
import static cn.alex.constant.ConstantPool.CONSTANT_FLOAT;
import static cn.alex.constant.ConstantPool.CONSTANT_INTEGER;
import static cn.alex.constant.ConstantPool.CONSTANT_INTERFACE_METHOD_REF;
import static cn.alex.constant.ConstantPool.CONSTANT_INVOKE_DYNAMIC;
import static cn.alex.constant.ConstantPool.CONSTANT_LONG;
import static cn.alex.constant.ConstantPool.CONSTANT_METHOD_HANDLE;
import static cn.alex.constant.ConstantPool.CONSTANT_METHOD_REF;
import static cn.alex.constant.ConstantPool.CONSTANT_METHOD_TYPE;
import static cn.alex.constant.ConstantPool.CONSTANT_MODULE;
import static cn.alex.constant.ConstantPool.CONSTANT_NAME_AND_TYPE;
import static cn.alex.constant.ConstantPool.CONSTANT_PACKAGE;
import static cn.alex.constant.ConstantPool.CONSTANT_STRING;
import static cn.alex.constant.ConstantPool.CONSTANT_UTF8;

import cn.alex.util.ClassReader;
import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolFactory {

  public static ConstantPoolInfo getCp(DataInputStream in) throws IOException {
    int tag = ClassReader.readUnsignedByte(in);
    ConstantPoolInfo cp;
    switch (tag) {
      case CONSTANT_UTF8:
        cp = new ConstantUtf8Info(in, tag);
        break;
      case CONSTANT_INTEGER:
        cp = new ConstantIntegerInfo(in, tag);
        break;
      case CONSTANT_FLOAT:
        cp = new ConstantFloatInfo(in, tag);
        break;
      case CONSTANT_LONG:
        cp = new ConstantLongInfo(in, tag);
        break;
      case CONSTANT_DOUBLE:
        cp = new ConstantDoubleInfo(in, tag);
        break;
      case CONSTANT_CLASS:
        cp = new ConstantClassInfo(in, tag);
        break;
      case CONSTANT_STRING:
        cp = new ConstantStringInfo(in, tag);
        break;
      case CONSTANT_FIELD_REF:
        cp = new ConstantFieldRefInfo(in, tag);
        break;
      case CONSTANT_METHOD_REF:
        cp = new ConstantMethodRefInfo(in, tag);
        break;
      case CONSTANT_INTERFACE_METHOD_REF:
        cp = new ConstantInterfaceMethodRefInfo(in, tag);
        break;
      case CONSTANT_NAME_AND_TYPE:
        cp = new ConstantNameAndTypeInfo(in, tag);
        break;
      case CONSTANT_METHOD_HANDLE:
        cp = new ConstantMethodHandleInfo(in, tag);
        break;
      case CONSTANT_METHOD_TYPE:
        cp = new ConstantMethodTypeInfo(in, tag);
        break;
      case CONSTANT_DYNAMIC:
        cp = new ConstantDynamicInfo(in, tag);
        break;
      case CONSTANT_INVOKE_DYNAMIC:
        cp = new ConstantInvokeDynamicInfo(in, tag);
        break;
      case CONSTANT_MODULE:
        cp = new ConstantModuleInfo(in, tag);
        break;
      case CONSTANT_PACKAGE:
        cp = new ConstantPackageInfo(in, tag);
        break;
      default:
        throw new RuntimeException("Unrecognized Constant Tag...");
    }
    return cp;
  }
}
