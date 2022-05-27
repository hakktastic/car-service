# improved caching
FROM openjdk:11-slim
EXPOSE 8082
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","nl.svb.leaseacarapi.leasecalculationservice.CarServiceApplication"]