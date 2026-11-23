#!/bin/bash
set -e
echo "========================================================"
echo "Starting SonarQube Server"
echo "========================================================"

if command -v docker >/dev/null 2>&1; then
    CONTAINER_ID=$(docker ps -a -q -f name=^sonarqube$ 2>/dev/null || true)
    if [ -n "$CONTAINER_ID" ]; then
        echo "Found existing SonarQube container. Starting it..."
        docker start sonarqube
    else
        echo "Starting new SonarQube container on port 9000..."
        docker run -d --name sonarqube -p 9000:9000 sonarqube:lts-community
    fi
else
    echo "Docker not found. Please ensure Docker is running."
fi

echo ""
echo "SonarQube is starting up on http://localhost:9000"
echo "Default credentials: admin / admin"
echo "(It usually takes 30-60 seconds for the service to be fully ready)"

if command -v xdg-open >/dev/null 2>&1; then
    xdg-open http://localhost:9000 >/dev/null 2>&1 || true
elif command -v open >/dev/null 2>&1; then
    open http://localhost:9000 >/dev/null 2>&1 || true
fi
echo "========================================================"
