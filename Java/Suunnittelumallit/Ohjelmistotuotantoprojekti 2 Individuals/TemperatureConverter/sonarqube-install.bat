@echo off
setlocal
echo ========================================================
echo Installing SonarQube & SonarScanner
echo ========================================================

rem 1. Check Docker option
where docker >nul 2>nul
if %ERRORLEVEL% equ 0 (
    echo [Option 1: Docker] Pulling official SonarQube LTS image...
    docker pull sonarqube:lts-community
    if %ERRORLEVEL% equ 0 (
        echo [OK] SonarQube Docker image ready.
    )
) else (
    echo Docker not found or not active.
)

rem 2. Check local C:\sonarqube directory (Week 4 Assignment path)
if exist "C:\sonarqube" (
    echo [OK] Local SonarQube folder already exists at C:\sonarqube.
) else (
    echo.
    echo Local installation folder C:\sonarqube not found.
    echo If you want local zip install:
    echo 1. Download SonarQube from: https://www.sonarsource.com/products/sonarqube/downloads/
    echo 2. Extract to C:\sonarqube
    echo 3. Download SonarScanner from: https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner/
    echo 4. Extract to C:\sonarscanner
)

echo.
echo ========================================================
echo SonarQube installation setup finished!
echo Use sonarqube-run.bat to launch SonarQube.
echo ========================================================
