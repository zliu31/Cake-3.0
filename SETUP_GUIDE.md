# Project Setup Guide - Cake Customization Application

## Complete Directory Structure

Create the following directory structure for your Spring Boot project:

```
cake-customization/
│
├── pom.xml
├── README.md
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── cake/
    │   │           └── customization/
    │   │               ├── CakeCustomizationApplication.java
    │   │               ├── config/
    │   │               │   └── WebConfig.java
    │   │               ├── controller/
    │   │               │   └── CakeController.java
    │   │               ├── model/
    │   │               │   └── CakeOrder.java
    │   │               └── service/
    │   │                   └── CakeService.java
    │   │
    │   └── resources/
    │       ├── application.properties
    │       │
    │       └── static/
    │           ├── index.html
    │           ├── styles.css
    │           └── app.js
    │
    └── test/
        └── java/
            └── com/
                └── cake/
                    └── customization/
                        └── service/
                            └── CakeServiceTest.java
```

## Step-by-Step Setup Instructions

### Step 1: Create Root Directory

```bash
mkdir cake-customization
cd cake-customization
```

### Step 2: Create Maven Structure

```bash
# Create main Java directory structure
mkdir -p src/main/java/com/cake/customization/config
mkdir -p src/main/java/com/cake/customization/controller
mkdir -p src/main/java/com/cake/customization/model
mkdir -p src/main/java/com/cake/customization/service

# Create resources directory
mkdir -p src/main/resources/static

# Create test directory structure
mkdir -p src/test/java/com/cake/customization/service
```

### Step 3: Copy Files to Correct Locations

#### Root Level Files
```bash
# Copy these to the root of cake-customization/
- pom.xml
- README.md
```

#### Java Source Files
```bash
# Copy to src/main/java/com/cake/customization/
cp CakeCustomizationApplication.java src/main/java/com/cake/customization/

# Copy to src/main/java/com/cake/customization/config/
cp WebConfig.java src/main/java/com/cake/customization/config/

# Copy to src/main/java/com/cake/customization/controller/
cp CakeController.java src/main/java/com/cake/customization/controller/

# Copy to src/main/java/com/cake/customization/model/
cp CakeOrder.java src/main/java/com/cake/customization/model/

# Copy to src/main/java/com/cake/customization/service/
cp CakeService.java src/main/java/com/cake/customization/service/
```

#### Resources Files
```bash
# Copy to src/main/resources/
cp application.properties src/main/resources/

# Copy to src/main/resources/static/
cp index.html src/main/resources/static/
cp styles.css src/main/resources/static/
cp app.js src/main/resources/static/
```

#### Test Files
```bash
# Copy to src/test/java/com/cake/customization/service/
cp CakeServiceTest.java src/test/java/com/cake/customization/service/
```

### Step 4: Verify File Structure

Run this command to verify your structure:

```bash
tree src/
```

Expected output:
```
src/
├── main
│   ├── java
│   │   └── com
│   │       └── cake
│   │           └── customization
│   │               ├── CakeCustomizationApplication.java
│   │               ├── config
│   │               │   └── WebConfig.java
│   │               ├── controller
│   │               │   └── CakeController.java
│   │               ├── model
│   │               │   └── CakeOrder.java
│   │               └── service
│   │                   └── CakeService.java
│   └── resources
│       ├── application.properties
│       └── static
│           ├── app.js
│           ├── index.html
│           └── styles.css
└── test
    └── java
        └── com
            └── cake
                └── customization
                    └── service
                        └── CakeServiceTest.java
```

## Quick Setup Script

You can use this bash script to set up everything automatically:

```bash
#!/bin/bash

# Create directory structure
mkdir -p cake-customization/src/main/java/com/cake/customization/{config,controller,model,service}
mkdir -p cake-customization/src/main/resources/static
mkdir -p cake-customization/src/test/java/com/cake/customization/service

# Navigate to project root
cd cake-customization

# Create placeholder files
echo "Directory structure created successfully!"
echo "Now copy your files to the appropriate locations as shown above."
```

Save this as `setup.sh`, make it executable with `chmod +x setup.sh`, and run it with `./setup.sh`.

## Alternative: Using IDE

### IntelliJ IDEA

1. **File → New → Project**
2. Select "Spring Initializr"
3. Configure:
   - Name: `cake-customization`
   - Group: `com.cake`
   - Artifact: `cake-customization`
   - Package name: `com.cake.customization`
   - Java: 17
4. Add dependencies:
   - Spring Web
   - Spring Boot DevTools
   - Thymeleaf
5. Click "Create"
6. Copy files to the generated structure

### Eclipse

1. **File → New → Spring Starter Project**
2. Configure project details
3. Add dependencies: Web, DevTools, Thymeleaf
4. Finish and copy files to generated structure

### VS Code

1. Install "Spring Boot Extension Pack"
2. **Ctrl+Shift+P → Spring Initializr: Create a Maven Project**
3. Follow prompts to create project
4. Copy files to generated structure

## Building the Project

### First Time Build

```bash
cd cake-customization
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

Or with the JAR:

```bash
java -jar target/cake-customization-1.0.0.jar
```

## Verification Checklist

- [ ] All Java files are in `src/main/java/com/cake/customization/...`
- [ ] All resource files are in `src/main/resources/`
- [ ] Static files (HTML, CSS, JS) are in `src/main/resources/static/`
- [ ] Test files are in `src/test/java/com/cake/customization/...`
- [ ] `pom.xml` is in the root directory
- [ ] Project builds without errors: `mvn clean install`
- [ ] Application starts without errors: `mvn spring-boot:run`
- [ ] Application accessible at http://localhost:8080

## Common Issues and Solutions

### Issue 1: Package Does Not Exist

**Problem**: Compilation errors about missing packages

**Solution**: Ensure all Java files have the correct package declaration at the top:
```java
package com.cake.customization;
// or
package com.cake.customization.controller;
// etc.
```

### Issue 2: Static Resources Not Found

**Problem**: CSS, JS, or HTML not loading

**Solution**: 
1. Verify files are in `src/main/resources/static/`
2. Check `application.properties` configuration
3. Restart the application

### Issue 3: Port Already in Use

**Problem**: `Port 8080 already in use`

**Solution**: Change port in `application.properties`:
```properties
server.port=8081
```

### Issue 4: Maven Build Fails

**Problem**: Build errors or dependency issues

**Solution**:
```bash
mvn clean
mvn dependency:resolve
mvn install
```

## Next Steps

After successful setup:

1. ✅ Run `mvn clean install` to build
2. ✅ Run `mvn spring-boot:run` to start
3. ✅ Open browser to http://localhost:8080
4. ✅ Test all features of the cake customization
5. ✅ Run tests with `mvn test`

## Development Workflow

1. **Make Changes**: Edit files in their respective directories
2. **Build**: `mvn clean install`
3. **Test**: `mvn test`
4. **Run**: `mvn spring-boot:run`
5. **Access**: http://localhost:8080

## Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Spring MVC Guide](https://spring.io/guides/gs/serving-web-content/)

---

**You're all set! Start building your cake customization application! 🍰**
