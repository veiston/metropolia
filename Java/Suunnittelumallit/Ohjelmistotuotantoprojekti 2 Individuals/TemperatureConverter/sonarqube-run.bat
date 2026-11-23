@echo off
docker start sonarqube 2>nul || docker run -d --name sonarqube -p 9000:9000 sonarqube:community
start http://localhost:9000
