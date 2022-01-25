# Clean Code

## Tim Peeters

* Afgestudeerd in 2003, KDG Toegepaste Informatica (Applicatieontwikkeling)
* Al 18+ jaar werkzaam bij Xplore Group (Cronos)
* Devoxx Program & Steering Committee member
* Clean Code, Clean Architecture evangelist
* Twitter @peeterstim

***

## Clean Code

![Clean Code Book](img/book.jpeg)

* First, you are a programmer
* Second, you want to be a better programmer

***

### Measurement of code quality

![Measurement of code quality](img/wtf.jpeg)

***

### Cost of Change

![Cost per change](img/cost-per-change.jpeg)

***

### Boy Scout Rule

* Leave the campground cleaner than you found it

***

## Meaningful Names

### Use Intention-Revealing Names

Bad:
```java
int d; // elapsed time in days 
```

Good:
```java
int elapsedTimeInDays;
```

***

### Use Intention-Revealing Names

```java
public List<int[]> getThem() {
    List<int[]> list1 = new ArrayList<int[]>();
    for (int[] x : theList) {
        if (x[0] == 4) {
            list1.add(x);
        }
    }
    return list1;
}
```

***

### Use Intention-Revealing Names

```java
public List<Cell> getFlaggedCells() {
    List<Cell> flaggedCells = new ArrayList<>(); 

    for (Cell cell : gameBoard) {
        if (cell.isFlagged()) {
            flaggedCells.add(cell);
        }
    }

    return flaggedCells; 
}
```

![Mine Sweeper](img/mine-sweeper.jpeg)

***

### Avoid Disinformation

```java
Set<Account> accountList;
```

***

### Make Meaningful Distinctions

Bad:
```java
public static void copyChars(char[] a1, char[] a2) {
    for (int i = 0; i < a1.length; i++) {
        a2[i] = a1[i];
    }
}
```

Good:
```java
public static void copyChars(char[] source, char[] destination) {
    for (int i = 0; i < source.length; i++) {
        destination[i] = source[i];
    }
}
```

***

### Use Pronouncable Names

Bad:
```java
class DtaRcrd102 {
    private Date genymdhms;
    private Date modymdhms;
    private final String pszqint = "102";
}
```

Good:
```java
class Customer {
    private Date generationTimestamp;
    private Date modificationTimestamp;
    private final String recordId = "102";
}
```

***

### Class Names

* Classes and objects should have noun or noun phrase names:
  * Account
  * Customer
  * AddressParser
* Avoid words like Manager, Processor, Data, Info (they don't add any meaning)
* A class name should not be a verb

***

### Method Names

* Methods should have verb or verb phrase names:
  * deletePage
  * save

### ...

***

## Functions

### Small

* Rule #1: Functions should be small
* Rule #2: They should be smaller than that

* Less than 10 lines

#### Do One Thing

* Functions should do one thing. 
They should do it well.
They should do it only.

See: `MethodLength.java`

***

### Use Descriptive Names

***

### Function Arguments

* The ideal number of arguments for a function is zero (niladic)
* Next comes one (monadic)
* Followed by two (dyadic)
* Three arguments (triadic)
* More than three (polyadic) requires very special justification

See: `FunctionArguments.java`

***

### Flag Arguments

* Passing a boolean into a function is a truly terrible practice

Bad:
```java
render(boolean isSuite)
```

***

### Don't Repeat Yourself

***

## Continuous Integration

### GitHub Actions

.github/workflows/ci.yml
```yaml
name: CI

on:
  push:
  pull_request:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          java-version: '11'
          distribution: 'temurin'
          cache: maven
      - name: Build with Maven
        run: mvn -B verify
```

* Enable branch protection

***

## Compiler warnings

pom.xml
```xml
<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <showDeprecation>true</showDeprecation>
        <showWarnings>true</showWarnings>
        <failOnWarning>true</failOnWarning>
        <compilerArgument>-Xlint:all</compilerArgument>
    </configuration>
</plugin>
```

Examples:
* Deprecations
* RawTypes

***

## Checkstyle

pom.xml
```xml
<plugin>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <configuration>
        <configLocation>config/checkstyle.xml</configLocation>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

config/checkstyle.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE module PUBLIC
        "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
        "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
    <module name="TreeWalker">
        <module name="MethodLength">
            <property name="max" value="10"/>
        </module>
    </module>
</module>
```

Examples:
* MethodLength
* ExecutableStatementCount
* ParameterNumber

Available Checks:
https://checkstyle.sourceforge.io/checks.html

## PMD

pom.xml
```xml
<plugin>
    <artifactId>maven-pmd-plugin</artifactId>
    <configuration>
        <failOnViolation>true</failOnViolation>
        <linkXRef>false</linkXRef>
        <printFailingErrors>true</printFailingErrors>
        <rulesets>config/pmd.xml</rulesets>
    </configuration>
    <executions>
        <execution>
            <id>pmd</id>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

config/pmd.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<ruleset
        name="PMD Ruleset"
        xmlns="http://pmd.sourceforge.net/ruleset/2.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://pmd.sourceforge.net/ruleset/2.0.0 http://pmd.sourceforge.net/ruleset_2_0_0.xsd">

    <description/>

    <rule ref="category/java/errorprone.xml/CloseResource"/>
</ruleset>
```

Examples:
* category/java/errorprone.xml/CloseResource
* category/java/errorprone.xml/EmptyCatchBlock
* category/java/errorprone.xml/ReturnEmptyCollectionRatherThanNull
* category/java/multithreading.xml/UnsynchronizedStaticFormatter

## CPD

pom.xml
```xml
<plugin>
    <artifactId>maven-pmd-plugin</artifactId>
    <executions>
        <execution>
            <id>pmd</id>
            <goals>
                <goal>cpd-check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

## Code Coverage

### JaCoCo

pom.xml
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <executions>
        <execution>
            <id>default-prepare-agent</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>default-report</id>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

### Codecov

Upload via GitHub Actions:
```yaml
- name: Upload coverage to Codecov
  uses: codecov/codecov-action@v2
```

## Dependencies

* Find a balance between
  * Code re-use (don't re-invent the wheel)
  * High coupling due to too many dependencies
* Keep dependencies up-to-date
  * Log4j 2 example
  * ossindex-maven-plugin
* Tools to keep dependencies up-to-date
  * Dependabot (GitHub)
  * Renovatebot
