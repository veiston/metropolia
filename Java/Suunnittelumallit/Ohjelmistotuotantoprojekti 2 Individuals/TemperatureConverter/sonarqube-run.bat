@echo off
setlocal
echo ========================================================
echo Starting SonarQube Server
echo ========================================================

rem Check if local StartSonar.bat exists (Week 4 Assignment path)
if exist "C:\sonarqube\bin\windows-x86-64\StartSonar.bat" (
    echo Found local SonarQube in C:\sonarqube. Launching StartSonar.bat...
    start "SonarQube" "C:\sonarqube\bin\windows-x86-64\StartSonar.bat"
    goto OPEN_BROWSER
)

rem Otherwise check Docker
where docker >nul 2>nul
if %ERRORLEVEL% equ 0 (
    echo Checking Docker containers for SonarQube...
    for /f "tokens=*" %%i in ('docker ps -a -q -f name=^sonarqube$ 2^>nul') do set CONTAINER_ID=%%i

    if defined CONTAINER_ID (
        echo Found existing SonarQube container. Starting it...
        docker start sonarqube
    ) else (
        echo Starting new SonarQube container on port 9000...
        docker run -d --name sonarqube -p 9000:9000 sonarqube:lts-community
    )
) else (
    echo [WARNING] Neither C:\sonarqube\bin\windows-x86-64\StartSonar.bat nor Docker was found.
    echo Please start Docker Desktop or install SonarQube to C:\sonarqube.
)

:OPEN_BROWSER
echo.
echo ========================================================
echo SonarQube is starting up!
echo Default credentials:
echo   Username: admin
echo   Password: admin
echo.
echo Opening http://localhost:9000 in your browser...
echo (SonarQube takes about 30-60 seconds to fully initialize)
start http://localhost:9000
echo ========================================================
