@echo off
setlocal
cd /d "%~dp0"
if exist "TemperatureConverter\pom.xml" cd TemperatureConverter

echo ========================================================
echo Running Temperature Converter
echo ========================================================
if exist "target\temperature-converter-1.0-SNAPSHOT.jar" (
    echo Launching packaged shaded JAR...
    java -jar target\temperature-converter-1.0-SNAPSHOT.jar
) else (
    echo Launching via Maven JavaFX plugin...
    call mvn javafx:run
)
