FROM openjdk:8-jdk-alpine
VOLUME /tmp

#-------------------------------------------------------------
# Base
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#-------------------------------------------------------------

# Smaller

#-------------------------------------------------------------
# Better
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.xiaoqiang.docker.study.DockerApplication"]
#-------------------------------------------------------------
# Multi-Stage

# Experimental Features