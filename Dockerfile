FROM openjdk:8

RUN mkdir -p /home/serveradmin/services/game_show_engine_rewamp/
RUN chmod 765 /home/serveradmin/services/game_show_engine_rewamp/

EXPOSE 8889
ADD target/spring-demo-jpa.jar /home/serveradmin/services/spring-demo-jpa.jar
ENTRYPOINT ["java","-jar","/home/serveradmin/services/spring-demo-jpa.jar"]
