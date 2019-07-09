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
