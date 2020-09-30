FROM openjdk:8-jdk-alpine

#ARG JAR_FILE=target/find-links.jar
#ARG JAR_LIB_FILE=target/lib/

# cd /usr/local/runme
WORKDIR /app

# copy target/find-links.jar /usr/local/runme/app.jar
COPY sl4jpoc-0.0.1-SNAPSHOT.jar /app/app.jar

RUN mkdir /logpath

# copy project dependencies
# cp -rf target/lib/  /usr/local/runme/lib
#ADD ${JAR_LIB_FILE} lib/

# java -jar /usr/local/runme/app.jar
#ENTRYPOINT ["java","-jar","app.jar"]
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

