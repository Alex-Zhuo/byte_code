package cn.alex.constant;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JavaVersion {

  MIN_SUPPORTED_VERSION(45), PREVIEW_VERSION(65535), JAVA_5_VERSION(49), JAVA_6_VERSION(50), JAVA_7_VERSION(
      51), JAVA_8_VERSION(52), JAVA_9_VERSION(53), JAVA_10_VERSION(54), JAVA_11_VERSION(55), JAVA_12_VERSION(
      56), JAVA_13_VERSION(57), JAVA_14_VERSION(58), JAVA_15_VERSION(59), JAVA_16_VERSION(60), JAVA_17_VERSION(
      61), JAVA_18_VERSION(62), JAVA_19_VERSION(63), JAVA_20_VERSION(64), JAVA_21_VERSION(65),
  ;
  private final Integer version;

  public static String getVersion(Integer version) {
    return Arrays.stream(JavaVersion.values()).filter(v -> v.getVersion().equals(version)).findFirst().map(JavaVersion::name)
        .orElse("");
  }
}
