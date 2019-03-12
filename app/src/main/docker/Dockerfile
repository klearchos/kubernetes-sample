FROM openjdk:8-jre-alpine

RUN adduser -D -s /bin/sh applicationAdmin
WORKDIR /home/applicationAdmin

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown applicationAdmin:applicationAdmin entrypoint.sh
USER applicationAdmin

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8079

ADD *.jar app.war
