FROM registry.infra-aws.com/docker-registry/gradle:8.10.0-jdk21 AS builder

ARG MODULE_NAME=ap-eosh

WORKDIR /app
COPY . /app
RUN --mount=type=cache,target=/root/.gradle gradle clean build -xtest

FROM registry.infra-aws.com/docker-registry/amazoncorretto:21-alpine

ARG MODULE_NAME
ENV MODULE_NAME=${MODULE_NAME:-ap-eosh}


# ARG 설정 (빌드 시점에 값 전달)
ARG SECRET_ID

# ARG를 ENV로 설정 (런타임 시점에서도 사용 가능)
ENV SECRET_ID=${SECRET_ID}

ARG PORT
ENV PORT=${PORT:-8088}

ARG HEAP_SIZE
ENV HEAP_SIZE=${HEAP_SIZE:-2048M}
ARG NEW_SIZE
ENV NEW_SIZE=${NEW_SIZE:-512M}
ARG META_SIZE
ENV META_SIZE=${META_SIZE:-512M}

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/${MODULE_NAME}-1.0.0.jar

EXPOSE ${PORT}

ENTRYPOINT java -Xms${HEAP_SIZE} -Xmx${HEAP_SIZE} -Djava.net.preferIPv4Stack=true -XX:NewSize=${NEW_SIZE} -XX:MaxNewSize=${NEW_SIZE} -XX:MaxMetaspaceSize=${META_SIZE} -jar ${MODULE_NAME}-1.0.0.jar
