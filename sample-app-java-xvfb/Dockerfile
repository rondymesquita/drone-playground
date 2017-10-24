FROM ubuntu:16.04

RUN apt update &&\
	apt install -y\
	xvfb \
	x11vnc \
	firefox \
	wget \
	openjdk-8-jdk \
	openjdk-8-doc \
	openjdk-8-jdk-headless \
	openjdk-8-jre \
	maven

RUN export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
RUN export JAVAHOME=$JAVA_HOME
RUN export PATH=$PATH:$JAVA_HOME/bin

ENV DISPLAY=:0

ADD ./x11vnc /etc/init.d/
RUN chmod +x /etc/init.d/x11vnc
ADD ./xvfb /etc/init.d/
RUN chmod +x /etc/init.d/xvfb

ADD ./entrypoint.sh /usr/opt/
RUN chmod +x /usr/opt/entrypoint.sh
ENTRYPOINT ["/usr/opt/entrypoint.sh"]


