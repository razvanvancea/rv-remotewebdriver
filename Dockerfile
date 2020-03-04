#This is a sample image
FROM ubuntu:18.04

WORKDIR /usr/share/rv
COPY target target
RUN apt-get update && apt-get install -y iputils-ping && mkdir loremIpsum
ENV myName="RV"
ENTRYPOINT echo $myName
