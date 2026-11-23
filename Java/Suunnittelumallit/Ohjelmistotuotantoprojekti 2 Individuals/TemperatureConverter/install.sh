#!/bin/bash
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"
if [ -f "TemperatureConverter/pom.xml" ]; then
    cd TemperatureConverter
fi

echo "========================================================"
echo "Installing and Building Temperature Converter"
echo "========================================================"
mvn clean install
echo ""
echo "[SUCCESS] Build and installation completed successfully!"
