#!/bin/bash
docker start sonarqube 2>/dev/null || docker run -d --name sonarqube -p 9000:9000 sonarqube:community
echo "SonarQube: http://localhost:9000"
