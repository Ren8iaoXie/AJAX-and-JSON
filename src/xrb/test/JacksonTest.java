package xrb.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import xrb.entry.Person;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * @author xieren8iao
 * @create 2019/3/24 - 13:30
 */
public class JacksonTest {
    @Test
    public void test1() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");

        //创建jackson核心对象
        ObjectMapper mapper = new ObjectMapper();
        //将java对象转化为json字符串
        String json = mapper.writeValueAsString(p);//{"name":"张三","age":18,"gender":"男"}

        //将json字符串以数据形式写入文件并保存
        mapper.writeValue(new File("e://a.txt"), p);

        //保存到writer中
        mapper.writeValue(new FileWriter("e://aa.txt"), p);
    }

    @Test
    public void test2() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(p);
        System.out.println(s);
        //{"name":"张三","age":18,"gender":"男","birthday":"2019-03-24"}
    }
    @Test
    public void test3() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(18);
        p2.setGender("男");
        p2.setBirthday(new Date());

        List<Person> list=new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        //list集合转成json
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
        //以数组的形式
        //[{"name":"张三","age":18,"gender":"男","birthday":"2019-03-24"},{"name":"张三","age":18,"gender":"男","birthday":"2019-03-24"},{"name":"张三","age":18,"gender":"男","birthday":"2019-03-24"}]
    }

    @Test
    public void test4() throws Exception {
        //创建map对象
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name", "王五");
        map.put("age", 18);
        map.put("gender", "男");

        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
        //以键值对的形式
        //{"gender":"男","name":"王五","age":18}
    }

    //演示JSON字符串转化为java对象
    @Test
    public void test5() throws Exception {
        //复制的json字符串自动转义
        String json="{\"gender\":\"男\",\"name\":\"王五\",\"age\":18}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
        //Person{name='王五', age=18, gender='男'}
    }
}