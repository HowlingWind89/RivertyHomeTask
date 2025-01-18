# Используем официальный образ OpenJDK с Gradle
FROM gradle:8-jdk23 AS build

# Setup working directory
WORKDIR /app

# Coping project filres to container
COPY . .

# Executing gradle tests
RUN gradle testSuite

# Command by default
CMD ["gradle", "testSuite"]
