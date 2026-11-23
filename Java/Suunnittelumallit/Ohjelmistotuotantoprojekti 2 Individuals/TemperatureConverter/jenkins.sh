#!/bin/bash
docker start jenkins 2>/dev/null || docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkins/jenkins:lts-jdk21
echo "Jenkins: http://localhost:8080"
