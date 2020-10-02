# kotlin-crud-web-flux
CRUD with Kotlin, Spring, Reactor and Gradle

#### Requirements
* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=linux) ``Recomended`` | [Eclipse](https://www.eclipse.org/downloads/)
* [Docker](https://docs.docker.com/engine/install/)
* [Docker Compose](https://docs.docker.com/compose/install/)
* [Gradle](https://gradle.org/install/) ``Optional``

**Note:** The Code provides his own version of [Gradle 6.5](https://gradle.org/install/) ``./gradlew``,
 But, If you want to use the version installed in your machine, you have to run tasks using ``gradle``

#### Build artifact
**Using Java 11 as default JDK:**
 If you don't know which JDK is running in your machine, check it using ``sudo update-alternatives --config java``
```
./gradlew build
```

**Using Java 11 explicitly:**
```
./gradlew build -Dorg.gradle.java.home="/usr/lib/jvm/java-11-openjdk-amd64"
```

#### Start App
```
./gradlew run
```

#### Run unit tests
```
./gradlew test
```

#### Start Docker Compose
**Note:** Before running next command, you need run: ``./gradlew build``
```
docker-compose -f .ops/docker-compose.yml up --build -d
```

#### Stop Docker Compose
```
docker-compose -f .ops/docker-compose.yml down --rmi local
```

#### Rest API's
Server starts at: [http://localhost:8080](http://localhost:8080)

Use ``.ops/client.http`` to test endpoints
