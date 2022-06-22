FROM adoptopenjdk/openjdk15:ubi
COPY target/mediScreenDemoGraphics-0.0.1-SNAPSHOT.jar mediScreenDemoGraphics.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "mediScreenDemoGraphics.jar"]