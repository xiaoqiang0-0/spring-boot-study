# `Maven` 私服
## 搭建
1) 使用`nexus` war包方式部署，或者使用第三方提供的服务
2) 注册账号并授权

## 配置`settings.xml`
1) 在servers节点添加如下配置(基于安全考虑页面上不显示密码，点击右侧的复制按钮可以获取包含密码的配置，账号密码为上一步获取的账户密码)
    ```xml
    <servers>
        <server>
            <id>rdc-releases</id>
            <username>gMWWE4</username>
            <password>******</password>
        </server>
        <server>
            <id>rdc-snapshots</id>
            <username>gMWWE4</username>
            <password>******</password>
        </server>
    </servers>
    ```
2) 在profiles节点添加如下配置  
    ```xml
    <profile>
        <id>rdc-private-repo</id>
        <repositories>
            <repository>
                <id>rdc-releases</id>
                <url>https://repo.rdc.aliyun.com/repository/78649-release-Yqebsi/</url>
            </repository>
            <repository>
                <id>rdc-snapshots</id>
                <url>https://repo.rdc.aliyun.com/repository/78649-snapshot-qU7VFb/</url>
            </repository>
        </repositories>
    </profile>
    ```
## `pom`上传配置
`pom.xml`加入以下配置:

```xml
<distributionManagement>
    <repository>
        <id>rdc-releases</id>
        <url>https://repo.rdc.aliyun.com/repository/78649-release-Yqebsi/</url>
    </repository>
    <snapshotRepository>
        <id>rdc-snapshots</id>
        <url>https://repo.rdc.aliyun.com/repository/78649-snapshot-qU7VFb/</url>
    </snapshotRepository>
</distributionManagement>
```
## 发布:
```sh
$ mvn clean deploy -DskipTests
```
