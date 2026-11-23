@echo off
setlocal
cd /d "%~dp0"
if exist "TemperatureConverter\pom.xml" cd TemperatureConverter

echo ========================================================
echo Installing and Building Temperature Converter
echo ========================================================
call mvn clean install
if %ERRORLEVEL% equ 0 (
    echo.
    echo [SUCCESS] Build and installation completed successfully!
) else (
    echo.
    echo [ERROR] Build failed. Please verify Java 21 and Maven installation.
)
exit /b %ERRORLEVEL%
