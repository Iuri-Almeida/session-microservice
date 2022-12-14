###########################################################
# BUILD
###########################################################
FROM maven:3-openjdk-17 AS build

WORKDIR /app/build

COPY pom.xml .

RUN mvn -B dependency:go-offline

COPY src/ ./src/

RUN mvn package
###########################################################

###########################################################
# RUN
###########################################################
FROM openjdk:17-alpine

WORKDIR /app/run

COPY --from=build /app/build/target/*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
###########################################################
