package io.github.bw;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileScanUtil {

  private FileScanUtil() {
  }

  public static List<File> scan(String path) {
    File file = new File(path);
    return Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(File::isFile).collect(Collectors.toList());
  }

  public static List<File> scan(String path, String filePrefix) {
    File file = new File(path);
    return Arrays.stream(
            Objects.requireNonNull(file.listFiles((dir, name) -> name.startsWith(filePrefix))))
        .filter(File::isFile)
        .collect(Collectors.toList());
  }

  public static List<File> scan(String path, String filePrefix, String suffix) {
    File file = new File(path);
    return Arrays.stream(
            Objects.requireNonNull(file.listFiles((dir, name) -> name.startsWith(filePrefix) && name.endsWith(suffix))))
        .filter(File::isFile)
        .collect(Collectors.toList());
  }

  public static List<File> scan(String envPath, String path, String filePrefix, String suffix) {
    String filePath = null;
    if (!isBlank(envPath)) {
      filePath = System.getenv(envPath);
    }

    if (isBlank(filePath)) {
      filePath = path;
    }

    File file = new File(filePath);
    return Arrays.stream(
            Objects.requireNonNull(file.listFiles((dir, name) -> name.startsWith(filePrefix) && name.endsWith(suffix))))
        .filter(File::isFile)
        .collect(Collectors.toList());
  }

  public static List<File> scanWithDefaultEnv(String path, String filenamePrefix, String suffix) {
    return scan("rule_model_path", path, filenamePrefix, suffix);
  }

  public static List<File> scanWithDefaultEnvAndOrdered(String path, String filenamePrefix, String suffix) {
    List<File> files = scanWithDefaultEnv(path, filenamePrefix, suffix);
    // 排序
    files.sort(Comparator.comparing(File::getName));
    Collections.reverse(files);
    return files;
  }

  public static File getWithDefaultEnvAndOrdered(int order, String path, String filenamePrefix, String suffix) {
    List<File> files = scanWithDefaultEnvAndOrdered(path, filenamePrefix, suffix);
    if (order > files.size()) {
      // 说明取值超出了范围，默认取 files 的最后一个
      order = files.size();
    }

    return files.get(order - 1);
  }


  private static boolean isBlank(String string) {
    if (string == null || string.length() == 0) {
      return true;
    }
    int strLen = string.length();
    for (int i = 0; i < strLen; ++i) {
      if (!Character.isWhitespace(string.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
