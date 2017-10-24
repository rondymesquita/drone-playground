FROM ubuntu:16.04

RUN apt update &&\
	apt install -y\
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

# Replace 1000 with your user / group id
RUN export uid=0 gid=0 && \
    mkdir -p /home/developer && \
    echo "developer:x:${uid}:${gid}:Developer,,,:/home/developer:/bin/bash" >> /etc/passwd && \
    echo "developer:x:${uid}:" >> /etc/group && \
    mkdir -p /etc/sudoers.d/ && \
    echo "developer ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/developer && \
    chmod 0440 /etc/sudoers.d/developer && \
    chown ${uid}:${gid} -R /home/developer

RUN wget https://github.com/mozilla/geckodriver/releases/download/v0.18.0/geckodriver-v0.18.0-linux64.tar.gz -O ~/geckodriver.tar.gz
RUN tar xzf ~/geckodriver.tar.gz -C ~/

# VOLUME /tmp/.X11-unix:/tmp/.X11-unix
# ENV DISPLAY=:0

# USER root


