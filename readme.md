## 使用手册

1. 下载项目到本地：
```shell script
git cloen https://github.com/Poseidon-Service-Framework/poseidon-generator.git
```

2. 执行安装命令

```shell script
mvn install
```
3. 添加依赖到你的maven 项目中

```shell script
<dependency>
    <groupId>com.muggle</groupId>
    <artifactId>poseidon-generator-ui</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

执行以下代码（根据实际情况填写包信息和数据库信息）：

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
## 功能说明
1. 指定项目基类包 `parentPack`，该属性用于生成 entity controller 时指定对应的父类名称。

2. 模块名 `module` 用于多模块项目，如果你的项目是单体项目可以忽略该字段。

3. 内置指令，用户可以选择性的创建文件，默认全部创建，可以使用方法invoker.popCommond("指令名称"); 移除内置的指令

内置指令说明：

- createCode 生成业务代码，包括controller entity mapper service 代码
- createPom 生成pom 文件
- createApplication 生成application。properties
- createBootstrap 生成 bootstrap.properties
- createBanner 生成banner.txt
- createConfig 生成 配置类
- createLogback 生成 spring-lobbacg-spring.xml
- createMainClass 生成启动类
- createReadme 生成readme.md

## 代码扩展

每个人对代码生成的需求不同，如果该工具默认生成的代码不能满足你的需求，那么你可以尝试自己修改代码模板，
来满足你的需求，你可以直接在源码中找 `resources\psf-others\config` , `resources\psf-template` 
两个文件夹中的模板进行修改，而 controller ，service 等模板需要你自己创建 文件夹 resources\templates，
并在其中创建 mapper.xml.ftl 等类似文件以覆盖 mybati plus generator 中的模板，当然你也可以 以同样的方式覆盖
poseidon generator 中的模板
