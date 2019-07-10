# `Zookeeper`

## 集群搭建
### 原生部署
1) 下载
2) 解压
3) 修改配置文件
    1) 增加节点信息（单机为例）
        ```sh
        server.1=localhost:2888:3888
        server.2=localhost:2899:3899
        server.3=localhost:2877:3877
        ```
    2) 修改端口（物理集群可以忽略）
    3) 修改数据目录（物理集群可以忽略）
4) 数据目录下创建`myid`文件
    ```sh
    echo n > /data/myid
    ```
5) 启动
    ```sh
    $ zkServer.sh start ../conf/zoo.cfg
    ```
### docker部署
> 略
    