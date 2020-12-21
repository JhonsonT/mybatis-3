/**
 * Copyright 2009-2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.my;

import java.io.Serializable;

public class DemoData implements Serializable {
  private Integer id;
  private Integer demoId;
  private String desc;
  private Demo demo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDemoId() {
    return demoId;
  }

  public void setDemoId(Integer demoId) {
    this.demoId = demoId;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Demo getDemo() {
    return demo;
  }

  public void setDemo(Demo demo) {
    this.demo = demo;
  }

  @Override
  public String toString() {
    return "DemoData{" +
      "id=" + id +
      ", demoId=" + demoId +
      ", desc='" + desc + '\'' +
      ", demo=" + demo +
      '}';
  }
}
