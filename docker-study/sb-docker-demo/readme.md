# docker demo

## base version
### `Build`
```bash
docker build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .
```
> `--build-args` 可能会出现一些问题
### `Run`  
> `docker run -p 8000:8080 myorg/myapp`

## A Better Dockerfile

### `Build`
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
