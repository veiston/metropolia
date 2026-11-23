#!/bin/bash
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"
if [ -f "TemperatureConverter/pom.xml" ]; then
    cd TemperatureConverter
fi

echo "========================================================"
echo "Running Temperature Converter"
echo "========================================================"
if [ -f "target/temperature-converter-1.0-SNAPSHOT.jar" ]; then
    echo "Launching packaged shaded JAR..."
    java -jar target/temperature-converter-1.0-SNAPSHOT.jar
else
    echo "Launching via Maven JavaFX plugin..."
    mvn javafx:run
fi
