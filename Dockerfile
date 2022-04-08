FROM registry.infra.ifood-prod.com.br/ifood/docker-images/newrelic-java as apm-agent-builder

FROM openjdk:11-jdk-slim as app-builder
ARG BUILD_CACHE_PATH
ENV GRADLE_USER_HOME="$BUILD_CACHE_PATH"
WORKDIR /tmp
COPY . .
RUN ./gradlew --no-daemon assemble

FROM openjdk:11-jre-slim-buster
ENV JAVA_OPTS_DOCKER="-javaagent:./newrelic.jar -Dnewrelic.config.file=./newrelic.yml"
ENV JAVA_MEM_OPTS_DOCKER=""
WORKDIR /srv
COPY --from=apm-agent-builder /nr/* .
COPY --from=app-builder /tmp/application/build/libs/app.jar .
CMD if [ -d /vault/ ]; then for VAULT_FILE in /vault/secrets/*; do echo "Importing $VAULT_FILE";. $VAULT_FILE; done; fi \
    && sed -i "s/\$NR_LICENSE_KEY/$APM_LICENSE_KEY/g" ./newrelic.yml \
    && sed -i "s/\$NR_APP_NAME/$APP_NAME/g" ./newrelic.yml \
    && JAVA_OPTS="$JAVA_OPTS $JAVA_OPTS_DOCKER" \
    && JAVA_MEM_OPTS="$JAVA_MEM_OPTS $JAVA_MEM_OPTS_DOCKER" \
    && exec java -Dlog4j2.formatMsgNoLookups=true $JAVA_OPTS $JAVA_MEM_OPTS -jar app.jar
