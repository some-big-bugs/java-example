package io.github.bw;

import java.io.File;
import java.util.Collections;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

public class Main {

  public static void main(String[] args) {
    InvocationRequest request = new DefaultInvocationRequest();
    request.setPomFile(new File("/Users/zhangyunan/IdeaProjects/zeus/pom.xml"));
//    request.setGoals(Collections.singletonList("dependency:tree"));
    request.setGoals(Collections.singletonList("dependency:tree"));
    request.setUserSettingsFile(new File("/Users/zhangyunan/.m2/setting-bairong.xml"));
    request.setLocalRepositoryDirectory(new File("/Users/zhangyunan/.m2/repository"));
    request.setMavenOpts("-DoutputFile=hello -DoutputType=text");

    Invoker invoker = new DefaultInvoker();
    InvocationResult execute = null;
    try {
      execute = invoker.execute(request);
    } catch (MavenInvocationException e) {
      e.printStackTrace();
    }
    System.out.println(execute);
  }
}
