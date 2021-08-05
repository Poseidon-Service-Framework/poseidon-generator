## 使用手册

方式一 在maven 项目中使用，mvn install 添加依赖 写一个main 函数 示例：

```java

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, String> otherfield=new HashMap<>();
        otherfield.put("parentVersion","1.0-SNAPSHOT");
        ProjectMessage build = ProjectMessage.builder().author("muggle").driver("com.mysql.jdbc.Driver").username("root")
                .swagger(true).tableName(Arrays.asList("oa_url_info")).parentPack("com.muggle.base")
                .jdbcUrl("jdbc:mysql:///p_oa?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
                .suffix("user").password("root").module("muggle-generator").projectPackage("com.muggle")
                .otherField(otherfield).skipJdbc(false).skipBase(false).skipConfig(false).build();
        CodeCommandInvoker invoker = new CodeCommandInvoker( new SimpleCodeGenerator(build));
//        invoker.popCommond("createCode");
        invoker.execute();
    }
}
```



## 功能- 指定基类


## 功能二 添加pom 文件

## 创建配置类

## 使用教程

