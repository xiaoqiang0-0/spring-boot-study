# docker demo

## base version
> 本质上是先打包，然后将jar包移动至镜像，然后镜像内直接通过以来的java环境直接运行生成的jar包。
### `Build`
```bash
docker build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .
```
> `--build-args` 可能会出现一些问题
### `Run`  
> `docker run -p 8000:8080 myorg/myapp`

## A Better Dockerfile

### `Build`
> 主要是将打包后的jar包解压，然后将所有内容全部copy如镜像，通过java执行主类.
1) 解压  
    ``` bash
    jar -xf ../*.jar
    ```
    > 先解压到一个文件夹内   
    ``` bash
    mkdir target/dependency
    cd target/dependency; jar -xf ../*.jar
    ``` 
2) 构建
    ```bash
    docker build -t myorg/myapp .
    ```
### 源码打包
> 将源码直接copy入镜像，然后在镜像内进行打包（可通过maven镜像或者自定义镜像或者通过`mvnw`执行）以及进行后续操作（直接运行或者解压jar包，直接通过主类运行）。

### `Spotify Maven Plugin`
> 本质上还是执行`Dockerfile`构建
#### 命令方式
> 无需修改pom文件
1) 创建对应`Dockerfile`
2) 执行 `mvn com.spotify:dockerfile-maven-plugin:build`
    > 可指定参数 类似`-Ddockerfile.repository=myorg/myapp`
#### pom文件中添加插件
1) `pom.xml`中增加插件
    ```xml
    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>dockerfile-maven-plugin</artifactId>
        <version>1.4.8</version>
        <configuration>
            <repository>myorg/${project.artifactId}</repository>
        </configuration>
    </plugin>
    ```
2) 执行插件 
    ```sh
    $ mvn dockerfile:build
    ```

## 上传私库
1) 搭建镜像仓库（或者使用第三方） 
    > 忽略
2) 登录仓库(已阿里云为例)  
    ```sh
    $ docker login --username=【登录邮箱】 registry.cn-hangzhou.aliyuncs.com
    ```
3) `Tag`
    ```sh
    $ docker tag [镜像本地id] registry.cn-hangzhou.aliyuncs.com/[命名空间]/[远程镜像名]:[镜像版本号]
    ```
4) `push`
    ```sh
    $ docker push registry.cn-hangzhou.aliyuncs.com/[命名空间]/[远程镜像名]:[镜像版本号]
    ```
