#!/bin/bash
cd "$(dirname "$0")"
mvn -q package -DskipTests && java -jar target/temperature-converter-1.0-SNAPSHOT.jar
