package io.github.bw.log;

import lombok.extern.java.Log;

@Log
public class LogLombok {

  public void log() {
    log.info("打个日志");
  }
}
