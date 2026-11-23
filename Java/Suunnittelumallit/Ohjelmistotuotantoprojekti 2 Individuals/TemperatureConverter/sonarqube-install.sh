#!/bin/bash
set -e
echo "========================================================"
echo "Installing SonarQube"
echo "========================================================"

if command -v docker >/dev/null 2>&1; then
    echo "Pulling official SonarQube LTS image via Docker..."
    docker pull sonarqube:lts-community
    echo "[OK] SonarQube Docker image ready."
else
    echo "Docker not detected. Please install Docker or download SonarQube from:"
    echo "https://www.sonarsource.com/products/sonarqube/downloads/"
fi

echo "========================================================"
echo "Use ./sonarqube-run.sh to start SonarQube."
echo "========================================================"
