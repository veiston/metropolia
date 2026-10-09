# Hallo! Here's my Temperature Converter
So, the problem being: Converting temperatures between Celsius, Fahrenheit, and Kelvin manually is tedious and terrible. This solves that and streamlines the experience with a simple GUI.

## 1. Assignment Description

This converts the temperature converter into a JavaFX desktop app with SQLite database persistence:

- JavaFX GUI for converting temperatures between Celsius, Fahrenheit, and Kelvin.
- SQLite database with two related tables to track units and conversion history.
- JUnit 5 unit tests with JaCoCo code coverage.
- Dockerfile supporting X11/XMing display forwarding, deployed to Docker Hub.
- Jenkinsfile for CI pipeline automation.

## 2. Technologies & Tools Used

- **Language**: Java 21
- **GUI**: JavaFX 21
- **Database**: SQLite (`sqlite-jdbc`)
- **Build**: Maven
- **Testing**: JUnit 5, JaCoCo
- **CI/CD & Container**: Docker, Jenkins, XMing (X11)

## 3. Design Approach & Implementation Method

- **Database**:
  - `temperature_unit`: Stores units (`id`, `name`, `symbol`).
  - `temp_record`: Stores conversions (`input_value`, `source_unit_id`, `output_value`, `target_unit_id`) referencing `temperature_unit(id)`.
- **Implementation**:
  - `TempCalculator`: Handles conversion math using Celsius as baseline.
  - `TemperatureUnitDAO` & `TempRecordDAO`: Handle SQLite queries via `PreparedStatement`.
  - `Main`: JavaFX layout with input fields, unit dropdowns, and conversion history list.
  - `Launcher`: Main class entry point for the shaded executable JAR.

## 4. Testing & Quality Assurance Steps

- **Automated Tests**: 21 unit tests (100% pass):
  - `TempCalculatorTest`: Tests conversions between all units and edge cases.
  - `DBConnectionTest` & DAOs: Test connection and CRUD queries using in-memory SQLite (`:memory:`).
  - Model tests: Test constructors and getters.
- **Coverage**: Generated with JaCoCo (`mvn test jacoco:report`).
- **Manual Verification**: Tested GUI locally and in Docker via XMing (`DISPLAY=host.docker.internal:0.0`).

## 5. How to Run

### Prerequisites

- Java 21 JDK & Maven 3.9+
- Docker Desktop & XMing (optional, for container execution)

### Run Locally

```bash
mvn clean compile javafx:run
```

Or run the packaged JAR:

```bash
mvn clean package -DskipTests
java -jar target/temperature-converter-1.0-SNAPSHOT.jar
```

### Run Tests

```bash
mvn test
```

### Run with Docker & XMing ✅😎

1. Start XMing on Windows:

```powershell
& "C:\Program Files (x86)\Xming\Xming.exe" :0 -clipboard -multiwindow -ac
```

1. Run container:

```bash
docker run -e DISPLAY=host.docker.internal:0.0 --rm veiston/temperature-converter:latest
```

## Links

- **GitHub**: <https://github.com/veiston/metropolia/tree/main/Java/Suunnittelumallit/Dirin%20in%20class%20assignment%202>
- **Docker Hub**: <https://hub.docker.com/r/veiston/temperature-converter>
