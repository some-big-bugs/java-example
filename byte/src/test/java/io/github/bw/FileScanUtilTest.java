package io.github.bw;

import java.io.File;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class FileScanUtilTest {

  @Test
  void testScan() {
    List<File> fileList = FileScanUtil.scan(
        "/Users/zhangyunan/project/some-big-bugs/java-example/byte/src/test/resources");
    for (File file : fileList) {
      log.info("filename: {}, \tpath: {}", file.getName(), file.getAbsolutePath());
    }
  }

  @Test
  void testScanAcardRecall() {
    List<File> fileList = FileScanUtil.scan("dd",
        "/Users/zhangyunan/project/some-big-bugs/java-example/byte/src/test/resources", "sdk_acard_qianshai_recall",
        "model");
    for (File file : fileList) {
      log.info("filename: {}, \tpath: {}", file.getName(), file.getAbsolutePath());
    }
  }

  @Test
  void testScanAcardRecallWithOrdered() {
    List<File> fileList = FileScanUtil.scanWithDefaultEnvAndOrdered(
        "/Users/zhangyunan/project/some-big-bugs/java-example/byte/src/test/resources", "sdk_acard_qianshai_recall",
        "model");
    for (File file : fileList) {
      log.info("filename: {}, \tpath: {}", file.getName(), file.getAbsolutePath());
    }
  }

  @Test
  void getWithDefaultEnvAndOrdered() {
    File file = FileScanUtil.getWithDefaultEnvAndOrdered(4,
        "/Users/zhangyunan/project/some-big-bugs/java-example/byte/src/test/resources", "sdk_acard_qianshai_recall",
        "model");
    log.info("filename: {}, \tpath: {}", file.getName(), file.getAbsolutePath());
  }
}