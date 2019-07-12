# ACL

> Access Control List 访问控制列表

### 权限
```java
public interface Perms {
    int READ = 1;
    int WRITE = 2;
    int CREATE = 4;
    int DELETE = 8;
    int ADMIN = 16;
    int ALL = 31;
}
```
