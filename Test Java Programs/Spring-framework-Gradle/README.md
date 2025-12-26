# Spring Framework Gradle Project

This project demonstrates a Spring Framework application with Aspect-Oriented Programming (AOP) using **Gradle** as the build and dependency management tool.

## Overview

The same Spring Framework application that was built with Maven, now implemented using Gradle for comparison and learning purposes.

## Gradle Build Configuration

### build.gradle

```gradle
plugins {
    id 'java'
    id 'application'
}

group = 'com.kapil'
version = '1.0-SNAPSHOT'

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework:spring-context:6.1.0'
    implementation 'org.springframework:spring-aop:6.1.0'
    implementation 'org.aspectj:aspectjweaver:1.9.20.1'
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'javax.annotation:javax.annotation-api:1.3.2'
}

application {
    mainClass = 'com.kapil.spring.DrawingApp'
}
```

### settings.gradle

```gradle
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = 'Spring-framework-Gradle'
```

## Gradle Commands

### Build the Project
```bash
gradle build
```

### Run the Application
```bash
gradle run
```

### Clean Build
```bash
gradle clean build
```

## Project Structure

```
Spring-framework-Gradle/
├── src/main/java/com/kapil/spring/
│   ├── DrawingApp.java          # Main application class
│   ├── Circle.java             # Shape implementation
│   ├── Triangle.java           # Shape implementation
│   ├── Shape.java              # Interface
│   ├── Point.java              # Model class
│   ├── annotations/
│   │   └── Retry.java          # Custom annotation
│   └── aspects/
│       └── RetryAspect.java    # AOP aspect
├── src/main/resources/
│   └── spring.xml              # Spring configuration
├── build.gradle                # Gradle build configuration
├── settings.gradle             # Gradle settings
└── README.md                   # This file
```

## Key Gradle Features Used

- **Java Plugin**: Basic Java compilation and packaging
- **Application Plugin**: Run applications with `gradle run`
- **Dependencies**: Same Spring Framework dependencies as Maven version
- **Java Compatibility**: Configured for Java 17

## Running the Application

### Method 1: Gradle Run (Development)
```bash
gradle run
```

### Method 2: Generated Distribution
```bash
gradle build
cd build/distributions/
unzip Spring-framework-Gradle-1.0-SNAPSHOT.zip
cd Spring-framework-Gradle-1.0-SNAPSHOT/bin/
./Spring-framework-Gradle
```

## Learning Outcomes

This project demonstrates:
- **Gradle Build System**: Alternative to Maven
- **Dependency Management**: Same Spring dependencies
- **Build Configuration**: Groovy-based build scripts
- **Application Execution**: Multiple ways to run Gradle applications

## Requirements

- **Java**: JDK 17 or higher
- **Gradle**: 8.0 or higher (or use wrapper)

## Gradle Build Folder Structure

After running `gradle build`, Gradle creates a `build/` directory with the following structure:

```
build/
├── classes/                    # Compiled Java classes
│   └── java/
│       └── main/              # Main source compiled classes
│           └── com/kapil/spring/  # Package structure
├── libs/                      # Generated JAR files
│   └── Spring-framework-Gradle-1.0-SNAPSHOT.jar
├── resources/                 # Processed resources
│   └── main/                  # Copied resource files
├── scripts/                   # Application scripts (from Application plugin)
│   ├── Spring-framework-Gradle  # Unix script
│   └── Spring-framework-Gradle.bat  # Windows script
├── distributions/             # Distribution archives (from Application plugin)
│   └── Spring-framework-Gradle-1.0-SNAPSHOT.zip
└── tmp/                       # Temporary build files
    ├── compileJava/          # Java compilation temporaries
    └── jar/                   # JAR creation temporaries
```

### Build Folder Details

#### `classes/java/main/`
- **Purpose**: Contains compiled `.class` files from your source code
- **Structure**: Mirrors your source package structure
- **Usage**: Used by other build tasks (testing, JAR creation)


#### `libs/`
- **Purpose**: Final build artifacts
- **Contents**: JAR files created by the `jar` task
- **Naming**: `{project.name}-{version}.jar`

#### `resources/main/`
- **Purpose**: Processed resource files
- **Contents**: Files from `src/main/resources/` (like `spring.xml`)
- **Processing**: May include filtering or processing

#### `scripts/`
- **Purpose**: Executable scripts for running the application
- **Created by**: Application plugin
- **Files**: Cross-platform scripts for Unix/Windows

#### `distributions/`
- **Purpose**: Complete application distributions
- **Contents**: ZIP/TAR archives with JAR + scripts + resources
- **Usage**: For deployment without Gradle

#### `tmp/`
- **Purpose**: Temporary files during build process
- **Contents**: Intermediate build artifacts
- **Cleanup**: Safe to delete, regenerated on next build

## Difference Between `build/libs/` and `build/distributions/`

### Quick Comparison

| Aspect | `build/libs/` | `build/distributions/` |
|--------|---------------|------------------------|
| **Content** | Single thin JAR (~7KB) | Complete app package (~7MB) |
| **Dependencies** | ❌ Not included | ✅ All dependencies included |
| **Runnable** | ❌ `java -jar` fails | ✅ Ready to run |
| **Use Case** | Library/dependency | Application deployment |
| **Created by** | `jar` task | `distZip` + `distTar` tasks |

### Detailed Explanation

#### `build/libs/` - Thin JAR (Library)
- **Contents**: Only your compiled `.class` files and resources
- **No dependencies**: Spring Framework JARs are NOT included
- **Purpose**: For use as a dependency by other projects
- **Running**: Requires manual classpath setup
- **Example**:
  ```bash

  # We have manually provide the path to all dependencies jar and mainClass path:
  java -cp "build/libs/Spring-framework-Gradle-1.0-SNAPSHOT.jar:path/to/dependencies/*" com.kapil.spring.DrawingApp
  ```

#### `build/distributions/` - Complete Application Package
- **Contents**: ZIP/TAR archives with complete application
- **All dependencies**: Includes Spring Framework, AspectJ, GSON, etc.
- **Scripts included**: Cross-platform executable scripts
- **Purpose**: Production deployment, standalone execution
- **Running**: Unzip and run immediately
- **Example**:
  ```bash
  # This WORKS perfectly:
  cd build/distributions/
  unzip Spring-framework-Gradle-1.0-SNAPSHOT.zip
  cd Spring-framework-Gradle-1.0-SNAPSHOT/bin/
  ./Spring-framework-Gradle
  ```

bin/Spring-framework-Gradle is for Unix and bin/Spring-framework-Gradle.bat is for Windows systems


When you have unzipped build/distributions/Spring-*.jar file, you see all the dependencies are present under lib/ folder

So incase you want to run thin jar under build/libs folder, use the following command:
```
java -cp "build/libs/Spring-framework-Gradle-1.0-SNAPSHOT.jar:build/distributions/Spring-framework-Gradle-1.0-SNAPSHOT/lib/*" com.kapil.spring.DrawingApp
```


### When to Use Each

#### ✅ **Use `libs/` when:**
- You want to publish your JAR to a repository
- Other projects will depend on your code
- You need a clean JAR without bundled dependencies
- You're building a library, not an application

#### ✅ **Use `distributions/` when:**
- You want to deploy the complete application
- You need a self-contained package
- No external dependency management required
- You want production-ready deployment packages

### Why Gradle Uses This Approach

Unlike Maven (which creates fat JARs by default with Shade plugin), Gradle separates concerns:
- **`libs/`**: Clean, dependency-free library JARs
- **`distributions/`**: Complete, self-contained application packages

This approach is actually **more flexible** than Maven's single fat JAR approach!

## Maven Lifecycle vs Gradle Tasks

### Complete Maven-to-Gradle Mapping

Maven has a **fixed lifecycle** with predefined phases, while Gradle has **flexible tasks** that can be customized. Here's how they map:

#### **Maven Lifecycle Phases → Gradle Tasks**

| Maven Phase | Maven Command | Gradle Task | Gradle Command | Description |
|-------------|---------------|-------------|----------------|-------------|
| **validate** | `mvn validate` | `check` | `gradle check` | Validate project structure and configuration |
| **compile** | `mvn compile` | `compileJava` | `gradle compileJava` | Compile main source code |
| **test** | `mvn test` | `test` | `gradle test` | Run unit tests |
| **package** | `mvn package` | `jar` + `distZip/Tar` | `gradle build` | Create JAR and distribution packages |
| **verify** | `mvn verify` | `check` + `test` | `gradle check test` | Run integration tests and checks |
| **install** | `mvn install` | `publishToMavenLocal` | `gradle publishToMavenLocal` | Install to local repository |
| **deploy** | `mvn deploy` | `publish` | `gradle publish` | Deploy to remote repository |

#### **Maven Phase Execution Flow**

```bash
# Maven executes phases sequentially
mvn clean compile test package install deploy
# ↑    ↑      ↑    ↑      ↑      ↑
# Executes: clean → compile → test → package → install → deploy
```

#### **Gradle Task Execution Flow**

```bash
# Gradle executes tasks with dependencies
gradle clean build publishToMavenLocal
# Task dependencies automatically resolved
```

### Detailed Phase-by-Phase Comparison

#### **1. Clean Phase**
- **Maven**: `mvn clean` - Deletes `target/` directory
- **Gradle**: `gradle clean` - Deletes `build/` directory
- **Same result**: Fresh build environment

#### **2. Validate/Initialize Phase**
- **Maven**: `validate` - Check POM, dependencies, plugins
- **Gradle**: `gradle buildEnvironment` - Check build configuration
- **Purpose**: Ensure build can proceed

#### **3. Compile Phase**
- **Maven**: `mvn compile` - Compile `src/main/java/` to `target/classes/`
- **Gradle**: `gradle compileJava` - Compile `src/main/java/` to `build/classes/`
- **Same result**: Compiled `.class` files

#### **4. Test Phase**
- **Maven**: `mvn test` - Run JUnit/TestNG tests
- **Gradle**: `gradle test` - Run JUnit/TestNG tests
- **Same result**: Test execution and reports

#### **5. Package Phase**
- **Maven**: `mvn package` - Create JAR in `target/`
- **Gradle**: `gradle jar` - Create JAR in `build/libs/`
- **Extra**: `gradle distZip` creates distribution archives
 
Or use `gradle build` to create both JAR in build/libs/ and create distribution archives.

#### **6. Verify Phase**
- **Maven**: `verify` - Run integration tests, quality checks
- **Gradle**: `gradle check` - Run code quality checks
- **Note**: Gradle doesn't have built-in integration test phase

#### **7. Install Phase**
- **Maven**: `mvn install` - Copy to `~/.m2/repository/`
- **Gradle**: `gradle publishToMavenLocal` - Copy to `~/.m2/repository/`
- **Same result**: Available as local dependency

#### **8. Deploy Phase**
- **Maven**: `mvn deploy` - Upload to remote repository
- **Gradle**: `gradle publish` - Upload to configured repositories
- **Requires**: Repository configuration in both tools

### Key Differences

#### **Phase Dependencies**
- **Maven**: Fixed, linear sequence (can't skip phases)
- **Gradle**: Task dependencies (can run any task independently)

#### **Customization**
- **Maven**: Limited customization (plugins extend lifecycle)
- **Gradle**: Highly customizable (write custom tasks in Groovy/Kotlin)

#### **Parallel Execution**
- **Maven**: Limited parallelization
- **Gradle**: Built-in parallel task execution

#### **Build Scripts**
- **Maven**: XML (`pom.xml`)
- **Gradle**: Groovy/Kotlin DSL (`build.gradle`)

### Common Command Translations

```bash
# Development workflow
mvn clean compile          →  gradle clean compileJava
mvn clean test             →  gradle clean test
mvn clean package          →  gradle clean build
mvn clean install          →  gradle clean build publishToMavenLocal

# Production deployment
mvn clean package          →  gradle clean build
mvn clean deploy           →  gradle clean build publish

# Development
mvn compile                →  gradle compileJava
mvn test                   →  gradle test
mvn exec:java              →  gradle run
```
