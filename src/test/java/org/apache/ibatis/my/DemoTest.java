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

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoTest {
  private final static SqlSessionFactory sqlSessionFactory;

  static {
    //获取SqlSessionFactory工厂类
    String resource = "org/apache/ibatis/my/mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  @Test
  public void getDemoTest() {
    //通过SqlSessionFactory获取SqlSession实例
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
      Demo demo = mapper.getDemo(1);
      System.out.println(demo);
    }
  }

  @Test
  public void getDemoNoCacheTest() {
    //通过SqlSessionFactory获取SqlSession实例
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
      Demo demo = mapper.getDemo(1);
      System.out.println(demo);
    }

    try (SqlSession sqlSession2 = sqlSessionFactory.openSession()) {
      DemoMapper mapper2 = sqlSession2.getMapper(DemoMapper.class);
      Demo demo2 = mapper2.getDemo(1);
      System.out.println(demo2);
    }
  }

  @Test
  public void getDemoCacheTest() {
    //通过SqlSessionFactory获取SqlSession实例
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
      Demo demo = mapper.getDemo(1);
      System.out.println(demo);

      DemoMapper mapper2 = sqlSession.getMapper(DemoMapper.class);
      Demo demo2 = mapper2.getDemo(1);
      System.out.println(demo2);

    }
  }

  @Test
  public void getDemoCacheAfterOperationTest() {
    //通过SqlSessionFactory获取SqlSession实例
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
      Demo demo = mapper.getDemo(1);
      System.out.println(demo);

//      Long i = mapper.createDemo("张三" + System.currentTimeMillis());
//      System.out.println(i);

//      int m = mapper.modifyDemo(1, "张三" + System.currentTimeMillis());
//      System.out.println(m);

//      sqlSession.clearCache();

      DemoMapper mapper2 = sqlSession.getMapper(DemoMapper.class);
      Demo demo2 = mapper2.getDemo(1);
      System.out.println(demo2);
    }
  }

  @Test
  public void getDemoDataTest() {
    //通过SqlSessionFactory获取SqlSession实例
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
      List<DemoData> demoDataList = mapper.queryDemoDataList(1);
      demoDataList.forEach(n -> System.out.println("***" + n.getDesc())
      );
    }
  }

  @Test
  public void getDemoDataTest2() {
    //通过SqlSessionFactory获取SqlSession实例
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
      List<DemoData> demoDataList = mapper.queryDemoDataList(1);
      demoDataList.forEach(n -> System.out.println("***" + n.getDemo())
      );
    }
  }
}
