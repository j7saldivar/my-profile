# How to run docker
# docker build -t jorgesaldivar.com .
# docker run -d --name jorgesaldivar-container -p 8080:8080 \ 
#  -v ${replace}:/home/saldivar j7saldivar/my-website:latest /bin/bash -c \
#  "cp my-website/target/my-profile*.jar /home/saldivar/my-profile.jar && cd /home/saldivar && java -jar /home/saldivar/my-profile.jar > /home/saldivar/my-profile.log 2>&1"
FROM centos:centos7
RUN yum install -y git \
	&& git clone https://github.com/jorgesaldivar/my-website.git \
	&& yum install -y java-1.8.0-openjdk \	
	&& yum install -y maven \
	&& mvn -f my-website/pom.xml clean package 
EXPOSE 8080 8443
