# ➤ 1. Använd officiell Java 21 image
FROM eclipse-temurin:21-jdk-focal AS build

# ➤ 2. Sätt arbetsmapp
WORKDIR /app

# ➤ 3. Kopiera Maven-filer först för bättre cache
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# ➤ 4. Hämta beroenden (snabbar upp builds)
RUN ./mvnw dependency:go-offline

# ➤ 5. Kopiera in koden och bygg
COPY src ./src
RUN ./mvnw clean package -DskipTests

# ➤ 6. Ny fas: bara körbar JAR och JDK
FROM eclipse-temurin:21-jdk-focal
WORKDIR /app

# ➤ 7. Kopiera färdig .jar från build-steget
COPY --from=build /app/target/*.jar app.jar

# ➤ 8. Exponera port (Render använder 8080 som standard)
EXPOSE 8080

# ➤ 9. Starta appen
CMD ["java", "-jar", "app.jar"]