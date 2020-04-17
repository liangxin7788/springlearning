package spring.demo.interview.reflect;

/**
 * @Package: spring.demo.interview.reflect
 * @ClassName: Person
 * @Description: 测试反射基础类
 * @Author: liangxin
 * @CreateDate: 2019/7/30 14:13
 * @UpdateDate: 2019/7/30 14:13
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
    }

    /**
     * protected、private都能被反射获取到
     * @param name
     * @return
     */
    protected String testGetMethod(String name){
        return "Hello " + name;
    }

}
