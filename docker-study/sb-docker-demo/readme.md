# docker demo

## base version
### `Build`
```bash
docker build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .
```
> `--build-args` 可能会出现一些问题
### `Run`  
> `docker run -p 8000:8080 myorg/myapp`

