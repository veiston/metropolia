@echo off
cd /d "%~dp0"
call mvn -q package -DskipTests || exit /b 1
java -jar target\temperature-converter-1.0-SNAPSHOT.jar
