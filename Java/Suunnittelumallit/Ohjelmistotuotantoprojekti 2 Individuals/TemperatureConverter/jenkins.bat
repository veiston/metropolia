@echo off
setlocal
echo ========================================================
echo Starting Jenkins Server
echo ========================================================

rem Check if Docker is available
where docker >nul 2>nul
if %ERRORLEVEL% equ 0 (
    echo Checking Docker containers for Jenkins...
    for /f "tokens=*" %%i in ('docker ps -a -q -f name=^jenkins$ 2^>nul') do set CONTAINER_ID=%%i

    if defined CONTAINER_ID (
        echo Found existing Jenkins container. Starting it...
        docker start jenkins
    ) else (
        echo Starting new Jenkins container (jenkins/jenkins:lts-jdk17)...
        docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts-jdk17
    )

    if %ERRORLEVEL% equ 0 (
        echo.
        echo Jenkins container started!
        echo Admin password command:
        echo   docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
    )
) else (
    if exist "jenkins.war" (
        echo Starting local jenkins.war on port 8080...
        start "Jenkins" java -jar jenkins.war --httpPort=8080
    ) else (
        echo Neither Docker nor jenkins.war found.
        echo Please ensure Docker Desktop is started or place jenkins.war in this folder.
    )
)

echo Opening http://localhost:8080 in browser...
start http://localhost:8080
echo ========================================================
