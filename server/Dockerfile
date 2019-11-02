FROM adoptopenjdk:11-jdk-openj9 AS builder

WORKDIR /media/listaval

COPY gradle ./gradle
COPY gradlew ./
COPY build.gradle ./
COPY src ./src

RUN bash gradlew bootJar
RUN mv build/libs/* build/libs/listaval.jar

FROM adoptopenjdk:11-jre-openj9

WORKDIR /srv/listaval

COPY --from=builder /media/listaval/build/libs/listaval.jar ./
CMD java -jar listaval.jar

