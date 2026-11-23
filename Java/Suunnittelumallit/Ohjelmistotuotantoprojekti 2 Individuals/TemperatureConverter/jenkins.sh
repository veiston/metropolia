#!/bin/bash
set -e
echo "========================================================"
echo "Starting Jenkins Server"
echo "========================================================"

if command -v docker >/dev/null 2>&1; then
    CONTAINER_ID=$(docker ps -a -q -f name=^jenkins$ 2>/dev/null || true)
    if [ -n "$CONTAINER_ID" ]; then
        echo "Found existing Jenkins container. Starting it..."
        docker start jenkins
    else
        echo "Starting new Jenkins container (jenkins/jenkins:lts-jdk17)..."
        docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts-jdk17
    fi
    echo ""
    echo "Jenkins container started!"
    echo "Admin password command:"
    echo "  docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword"
elif [ -f "jenkins.war" ]; then
    echo "Starting local jenkins.war on port 8080..."
    java -jar jenkins.war --httpPort=8080 &
else
    echo "Neither Docker nor jenkins.war found."
    echo "Please ensure Docker or Java is installed."
fi

echo "Access Jenkins at: http://localhost:8080"
if command -v xdg-open >/dev/null 2>&1; then
    xdg-open http://localhost:8080 >/dev/null 2>&1 || true
elif command -v open >/dev/null 2>&1; then
    open http://localhost:8080 >/dev/null 2>&1 || true
fi
echo "========================================================"
