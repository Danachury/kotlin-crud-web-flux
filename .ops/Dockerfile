FROM gradle:6.5-jdk11

WORKDIR /kotlin-crud-web-flux/

COPY build/libs/*.jar /kotlin-crud-web-flux/
COPY .ops/*.sh /kotlin-crud-web-flux/

EXPOSE $PORT

ENTRYPOINT sh entrypoint.sh
