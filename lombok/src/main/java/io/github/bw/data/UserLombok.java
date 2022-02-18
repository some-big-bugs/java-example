package io.github.bw.data;


import lombok.Builder;
import lombok.ToString;

@Builder
@ToString(callSuper = true)
public class UserLombok {

  private Integer id;

  private Integer age;

  private String realName;

}
