
# Envers utilities

This is a Java library with some utilities ...

## Getting Started

To get you started you can simply clone the `systelab-envers-utilities` repository and install the dependencies.

### Prerequisites

You need [git][git] to clone the `systelab-envers-utilities` repository.

You will need [Java™ SE Development Kit 8][jdk-download] and [Maven][maven].

### Clone

Clone the `systelab-envers-utilities` repository using git:

```bash
git clone https://github.com/systelab/systelab-envers-utilities.git
cd systelab-envers-utilities
```

### Install Dependencies

In order to install the dependencies, you must run:

```bash
mvn clean install
```

## Release

In order to release a new version:

Step 1. Update the version in your pom.xml file. For example:

```
<version>1.1.0</version>
```

Step 2. Commit and push in the master branch, and generate a new Release by pressing the button "Draft new release".

In the example use v1.1.0 as the Tag version, and 1.1.0 as the release title.

Step 3. Head to https://jitpack.io and look up "systelab/systelab-envers-utilities". Choose the new version and press the button "Get it". Check the log to verify that everything is fine.


## Using the library

In order to use the library, you should add the dependency to your project.

### Gradle

In order to use the library, you should:

Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.systelab:systelab-envers-utilities:v1.1.0'
}
```

### Maven

Step 1. Add the JitPack repository to your build file

```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency

```
	<dependency>
	    <groupId>com.github.systelab</groupId>
	    <artifactId>systelab-envers-utilities</artifactId>
	    <version>v1.1.0</version>
	</dependency>
```


[git]: https://git-scm.com/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[junit]: https://junit.org/junit5/


