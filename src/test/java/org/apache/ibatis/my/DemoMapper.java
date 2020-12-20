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

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoMapper {
  @Select("SELECT * FROM demo WHERE id = #{id}")
  Demo getDemo(@Param(value = "id") int id);

  @Insert("INSERT INTO demo (name) VALUES(#{name})")
  Long createDemo(@Param(value = "name") String name);

  @Update("UPDATE demo SET name=#{name} WHERE id=#{id}")
  int modifyDemo(@Param(value = "id") int id, @Param(value = "name") String name);
}
