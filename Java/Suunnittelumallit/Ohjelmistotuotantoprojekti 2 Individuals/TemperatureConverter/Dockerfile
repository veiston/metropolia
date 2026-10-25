FROM eclipse-temurin:21-jre
RUN apt-get update && apt-get install -y \
    libgl1 \
    libgtk-3-0 \
    libx11-6 \
    libxext6 \
    libxrender1 \
    libxtst6 \
    && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY target/temperature-converter-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
