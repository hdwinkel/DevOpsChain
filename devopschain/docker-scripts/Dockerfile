FROM openjdk:8

MAINTAINER winkel "public@egladil.de"

WORKDIR /usr/local/bin/devopschain

COPY devopschain-0.0.1-SNAPSHOT.jar ./devopschain-0.0.1-SNAPSHOT.jar

# mount as /home/winkel/work/devopschain
VOLUME /usr/local/bin/devopschain/config

EXPOSE 9991

# java -cp devopschain-0.0.1-SNAPSHOT.jar de.egladil.winkel.devopschain.HelloWorldServer
CMD ["java","-cp","devopschain-0.0.1-SNAPSHOT.jar","de.egladil.winkel.devopschain.HelloWorldServer"]
