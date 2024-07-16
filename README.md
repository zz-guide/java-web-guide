# java-web-guide
练习java-web
- 采用tomcat10以上版本
- jdk 17
- api全部采用jakarta.servlet.*


# 模块
- [x] learn-jsp
- [x] learn-servlet
- [x] learn-servlet-annotation
- [x] learn-servlet-fud
- [x] learn-thymeleaf
- [x] learn-freemarker

## tomcat乱码
启动增加vm参数: -Dfile.encoding=UTF-8

## 关于jstl
旧版本使用以下这2个包
```xml
<properties>
    <taglibs.standard.version>1.2.5</taglibs.standard.version>
</properties>

<dependencyManagement>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.apache.taglibs/taglibs-standard-impl -->
        <dependency>
            <groupId>org.apache.taglibs</groupId>
            <artifactId>taglibs-standard-impl</artifactId>
            <version>${taglibs.standard.version}</version>
            <scope>runtime</scope>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.apache.taglibs/taglibs-standard-spec -->
        <dependency>
            <groupId>org.apache.taglibs</groupId>
            <artifactId>taglibs-standard-spec</artifactId>
            <version>${taglibs.standard.version}</version>
        </dependency>
    
    </dependencies>
</dependencyManagement>
```

新版本
```xml
<properties>
    <servlet.jsp.jstl.api.version>3.0.0</servlet.jsp.jstl.api.version>
    <jakarta.servlet.jsp.jstl.version>3.0.1</jakarta.servlet.jsp.jstl.version>
</properties>

<dependencyManagement>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api -->
        <dependency>
            <groupId>jakarta.servlet.jsp.jstl</groupId>
            <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
            <version>${servlet.jsp.jstl.api.version}</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl -->
        <dependency>
            <groupId>org.glassfish.web</groupId>
            <artifactId>jakarta.servlet.jsp.jstl</artifactId>
            <version>${jakarta.servlet.jsp.jstl.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```