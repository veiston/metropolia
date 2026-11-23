# Hallo! Here's my Temperature Converter 2
So, the problem being: Converting temperatures between Celsius, Fahrenheit, and Kelvin manually is tedious and terrible. This solves that and streamlines the experience with a simple GUI.

## 1. Assignment Description

This version implements **Database Localization** (In-class Assignment 6) extending the Temperature Converter application:

- JavaFX FXML GUI for converting temperatures between Celsius, Fahrenheit, and Kelvin.
- Dynamic runtime GUI localization across 5 languages: English, Finnish, Swedish, Japanese, and Arabic (with RTL layout).
- **Database Localization**: Unit names (e.g. Celsius, 摂氏, درجة مئوية) and unit descriptions are stored in and fetched dynamically from the database using the **Translation Table** approach.
- Robust English fallback mechanism when a language or translation is missing.
- Conversion history tracking: Saves each conversion (input value, source unit, output value, target unit, language, and timestamp) and shows the 5 most recent conversions in the GUI.
- `init.sql` schema and seed script containing measurement tables, temperature units, speed/distance/time units, and translations across all 5 languages in UTF-8.
- Comprehensive JUnit 5 unit tests with JaCoCo coverage (including localized lookups and fallback scenarios).
- Dockerfile supporting X11/XMing display forwarding, deployed to Docker Hub.
- Jenkinsfile for CI pipeline automation (build, test, JaCoCo, SonarQube analysis, Docker build & push).
- Static code analysis integration with SonarQube and SonarScanner (`sonar-project.properties`).
- User Acceptance Testing (UAT) with 10 comprehensive test cases documented in `UAT_Test_Cases.md`.
- Kubernetes deployment manifest (`temperature-converter.yaml`) for Minikube.

## 2. Technologies & Tools Used

- **Language**: Java 21
- **GUI**: JavaFX 21
- **Database**: SQLite (`sqlite-jdbc`) with UTF-8 encoding
- **Build**: Maven
- **Testing**: JUnit 5, JaCoCo
- **CI/CD & Container**: Docker, Jenkins, XMing (X11)
- **Orchestration**: Kubernetes (Minikube)

## 3. Database Localization: Translation Table Approach

### 3.1 Chosen Approach & Justification

For this assignment, the **Translation Table** approach was chosen. In this design, language-neutral entity metadata is separated from linguistic translations:
- **Base table** (`temperature_unit`): Stores non-linguistic data such as unit `id`, default canonical name, `symbol` (e.g. `C`, `F`, `K`), and `category`.
- **Translation table** (`unit_translation`): Stores language-specific values (`unit_id`, `lang`, `name`, `description`) linked by foreign key.

```
+--------------------+        +---------------------+
|  temperature_unit  | 1    * |  unit_translation   |
+--------------------+--------+---------------------+
| id (PK)            |        | unit_id (PK, FK)    |
| name (UNIQUE)      |        | lang (PK)           |
| symbol             |        | name                |
| category           |        | description         |
+--------------------+        +---------------------+
```

### 3.2 Reasons for Choosing the Translation Table Approach

1. **Clean 3NF Normalization**: Unlike the *Row approach*, non-text columns (symbols, IDs, conversion mathematical properties) are stored exactly once. This eliminates data redundancy and prevents update anomalies.
2. **Schema Stability & Extensibility (Open-Closed Principle)**: Unlike the *Field (Column) approach* which requires executing `ALTER TABLE ADD COLUMN` for every new language, adding new languages (e.g., German, Spanish, French) requires only inserting new rows. The database schema stays completely stable.
3. **No Dynamic Table Names**: Unlike the *Table approach* (e.g. `unit_en`, `unit_fi`), which forces application code to construct table names dynamically at runtime and duplicates the schema across multiple tables, the translation table allows static, parameterized queries that are safe from SQL injection.
4. **Graceful English Fallback**: Fallback to default English is clean and efficient in SQL using a `LEFT JOIN` and `COALESCE`:
   ```sql
   SELECT u.id, u.symbol,
          COALESCE(t.name, fallback.name, u.name) AS localized_name,
          COALESCE(t.description, fallback.description, '') AS localized_desc
   FROM temperature_unit u
   LEFT JOIN unit_translation t ON u.id = t.unit_id AND t.lang = ?
   LEFT JOIN unit_translation fallback ON u.id = fallback.unit_id AND fallback.lang = 'en'
   WHERE u.category = 'temperature'
   ORDER BY u.id;
   ```
   If a translation in the requested language exists, it is returned. If missing, it immediately falls back to English without application-level branching or errors.
5. **Industry Standard**: Translation tables represent the standard enterprise pattern across content management systems, relational database architectures, and e-commerce platforms.

## 4. Database Schema Overview

The database contains three key groups of tables:

1. **Unit & Lookup Data**:
   - `temperature_unit`: Base table storing units for temperature (`Celsius`, `Fahrenheit`, `Kelvin`) as well as speed, distance, and time (`km/h`, `mph`, `m/s`, `km`, `mi`, `h`, `s`).
   - `unit_translation`: Localized names and descriptions across 5 languages (`en`, `fi`, `sv`, `ja`, `ar`).
2. **Measurement Tables**:
   - `temp_record`: Tracks temperature conversions (`input_value`, `source_unit_id`, `output_value`, `target_unit_id`, `language`, `timestamp`) with foreign keys to `temperature_unit(id)`.
   - `speed_measurement`: Tracks multi-table calculations (`distance`, `time`, `speed`) referencing `temperature_unit(id)`.
3. **Database Initialization**:
   - Both `init.sql` and `DBConnection.initDatabase()` configure tables and populate complete localized datasets in all 5 languages using UTF-8.

## 5. Testing & Quality Assurance

- **Automated Tests**: 33 unit tests passing (100% pass rate):
  - `TemperatureUnitDAOTest`: Tests localized lookups across all 5 languages (English, Finnish, Swedish, Japanese, Arabic), missing language fallback to English, ID lookups, saving units, and adding translations.
  - `TempRecordDAOTest`: Tests saving conversions with language and timestamp, retrieving all records, and retrieving the 5 most recent records (`findRecent(5)`).
  - `TempCalculatorTest`: Tests temperature conversions across all supported units and symbols (`C`, `F`, `K`).
  - `TemperatureConverterTest`: Tests edge cases and extreme temperature threshold detection (-40°C and 50°C).
  - `DBConnectionTest`, `TemperatureUnitTest`, `TempRecordTest`: Test database connections and entity models.
- **Coverage**: Measured with JaCoCo (`mvn test jacoco:report`). Core logic exceeds the required 80% line coverage.
- **SonarQube Static Analysis**: Configured via `sonar-project.properties` and integrated into the Jenkins CI/CD pipeline.
- **User Acceptance Testing (UAT)**: 10 functional acceptance test cases documented in [UAT_Test_Cases.md](UAT_Test_Cases.md) based on Sprint 6 criteria (100% pass rate).

## 6. How to Run

### Prerequisites

- Java 21 JDK & Maven 3.9+
- Docker Desktop & XMing (optional, for container execution)

### Quick Scripts (.bat & .sh)

For simple one-click setup and execution, scripts are provided for both Windows (`.bat`) and Linux/macOS (`.sh`):

- **Build / Install**: `install.bat` / `./install.sh` (executes `mvn clean install` to test and package)
- **Run Application**: `run.bat` / `./run.sh` (launches packaged application or JavaFX)
- **Start Jenkins**: `jenkins.bat` / `./jenkins.sh` (starts Jenkins and opens `http://localhost:8080`)
- **Install SonarQube**: `sonarqube-install.bat` / `./sonarqube-install.sh` (pulls LTS Docker image / setup)
- **Start SonarQube**: `sonarqube-run.bat` / `./sonarqube-run.sh` (starts SonarQube and opens `http://localhost:9000`)

### Run Locally

```bash
mvn clean compile javafx:run
```

Or run the packaged shaded JAR:

```bash
mvn clean package -DskipTests
java -jar target/temperature-converter-1.0-SNAPSHOT.jar
```

### Run Tests

```bash
mvn test
```

### Run SonarQube Code Analysis

Run with Maven:

```powershell
mvn clean verify sonar:sonar `
  "-Dsonar.projectKey=temperature-converter" `
  "-Dsonar.token=$env:SONAR_TOKEN" `
  "-Dsonar.host.url=http://localhost:9000"
```

Or run with SonarScanner:

```bash
sonar-scanner
```

### Run with Docker & XMing ✅😎

1. Start XMing on Windows:

```powershell
& "C:\Program Files (x86)\Xming\Xming.exe" :0 -clipboard -multiwindow -ac
```

2. Run container:

```bash
docker run -e DISPLAY=host.docker.internal:0.0 --rm veiston/temperature-converter:latest
```

### Run with Minikube (Kubernetes)

```bash
minikube start
kubectl apply -f temperature-converter.yaml
```

## Links

- **GitHub**: <https://github.com/veiston/metropolia/tree/main/Java/Suunnittelumallit/Ohjelmistotuotantoprojekti%202%20Individuals/TemperatureConverter>
- **Docker Hub**: <https://hub.docker.com/r/veiston/temperature-converter>
