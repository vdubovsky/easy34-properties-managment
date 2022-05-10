## About

The simple demo to demonstrate application properties management in a Spring boot application

## Inside jar/war

### Classpath

Package and run application with following steps:

1. mvn clean package
2. cd .\target
3. java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war
4. open any browser or Postman and make GET localhost:8080/vars

- var1: resources/application-default.properties
- var2: resources/application-default.properties
- var3: resources/application-default.properties
- var4: resources/application-default.properties
- var5: resources/application-default.properties
- var6: resources/application.properties

var1-var5 from application-default.properties have overridden ones specified in application.properties

### Spring profiles

Spring profiles can be set inside application.properties(spring.active.profiles=dev), they can also be specified with
command line during start the application:

#### Java System Properties (VM Arguments)

java -jar "-Dspring.profiles.active=dev" easy34-properties-management-0.0.1-SNAPSHOT.war

#### Program arguments

java -jar easy34-properties-management-0.0.1-SNAPSHOT.war --spring.profiles.active=dev

To designate spring profile, run application with following command:

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.profiles.active=dev

- var1: resources/application-dev.properties
- var2: resources/application-dev.properties
- var3: resources/application-dev.properties
- var4: resources/application-dev.properties
- var5: resources/application.properties
- var6: resources/application.properties

Now, application-default.properties doesn't seem to be working, but the application-dev.properties does.

Eventually, application.properties file has the lowest priority, then ether application-defaults.properties or
application-dev.properties overrides existed ones regarding spring profiles.

### Property file name

Spring Boot application can read properties from files with different names.

Run the following command:

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom

- var1: resources/custom-default.properties
- var2: resources/custom-default.properties
- var3: resources/custom.properties
- var4: def4
- var5: def5
- var6: def6

The same behavior, custom.properties file specify values, and custom-default.properties override them then.

Run the application with 'dev' profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom --spring.profiles.active=dev

- var1: resources/custom-dev.properties
- var2: resources/custom.properties
- var3: resources/custom.properties
- var4: def4
- var5: def5
- var6: def6

### Conclusion

The order of overriding is:

- when config name isn't specified

application.properties -> application-profile.properties (if profile is not provided 'default' profile is used)

- when config name is specified

custom.properties -> custom-profile.properties (if profile is not provided 'default' profile is used)

### Classpath/config

Rename folder 'rename_to_config' to 'config', re-package and run

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war

- var1: resources/config/application-default.properties
- var2: resources/config/application-default.properties
- var3: resources/config/application-default.properties
- var4: resources/config/application-default.properties
- var5: resources/config/application-default.properties
- var6: resources/config/application.properties

All properties in root classpath folder have been overridden with the same order as it was previously.

Run the application with 'dev' profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.profiles.active=dev

- var1: resources/config/application-dev.properties
- var2: resources/config/application-dev.properties
- var3: resources/config/application-dev.properties
- var4: resources/config/application-dev.properties
- var5: resources/config/application.properties
- var6: resources/config/application.properties

The same behavior, application-dev's properties have overridden existed, application-default's ones don't work

Specify property file name and run with default profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom

- var1: resources/config/custom-default.properties
- var2: resources/config/custom-default.properties
- var3: resources/config/custom.properties
- var4: def4
- var5: def5
- var6: def6

Run with 'dev' profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.profiles.active=dev --spring.config.name=custom

- var1: resources/config/custom-dev.properties
- var2: resources/config/custom.properties
- var3: resources/config/custom.properties
- var4: def4
- var5: def5
- var6: def6

### Conclusion

Order of overriding application properties:

- classpath .properties ->
- classpath -profile.properties ->
- classpath/config .properties ->
- classpath/config -profile.properties

## External properties

### Root

Copy all files from 'copy_to_target1' to 'target' folder and then run application with the following command

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war

- var1: target/application-default.properties
- var2: target/application-default.properties
- var3: target/application-default.properties
- var4: target/application-default.properties
- var5: target/application-default.properties
- var6: target/application.properties

All properties have been overridden with new from target folder

Run the application with 'dev' profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.profiles.active=dev

- var1: target/application-dev.properties
- var2: target/application-dev.properties
- var3: target/application-dev.properties
- var4: target/application-dev.properties
- var5: target/application.properties
- var6: target/application.properties

Repeat two previous commands with custom property file name

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom

- var1: target/custom-default.properties
- var2: target/custom-default.properties
- var3: target/custom.properties
- var4: def4
- var5: def5
- var6: def6

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom --spring.profiles.active=dev

- var1: target/custom-dev.properties
- var2: target/custom.properties
- var3: target/custom.properties
- var4: def4
- var5: def5
- var6: def6

### Root/config

Copy all files from 'copy_to_target2' to 'target'

Run the application

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war

- var1: target/config/application-default.properties
- var2: target/config/application-default.properties
- var3: target/config/application-default.properties
- var4: target/config/application-default.properties
- var5: target/config/application-default.properties
- var6: target/config/application.properties

Run the application with 'dev' profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.profiles.active=dev

- var1: target/config/application-dev.properties
- var2: target/config/application-dev.properties
- var3: target/config/application-dev.properties
- var4: target/config/application-dev.properties
- var5: target/config/application.properties
- var6: target/config/application.properties

Run the application with custom config name

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom

- var1: target/config/custom-default.properties
- var2: target/config/custom-default.properties
- var3: target/config/custom.properties
- var4: def4
- var5: def5
- var6: def6

Run the application with custom config name and 'dev' profile

java -jar .\easy34-properties-management-0.0.1-SNAPSHOT.war --spring.config.name=custom --spring.profiles.active=dev

- var1: target/config/custom-dev.properties 
- var2: target/config/custom.properties 
- var3: target/config/custom.properties
- var4: def4 
- var5: def5 
- var6: def6

### Conclusion

Full order of properties loading: 

1. Classpath application.properties file
2. Classpath application-profile.properties file
3. Classpath/config application.properties file
4. Classpath/config application-profile.properties.file
5. Root application.properties file
6. Root application-profile.properties file
7. Root/config application.properties file
8. Root/config application-profile.properties.file

## YAML vs properties

yaml has lower priority then properties

## Another approaches to pass variables 

https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/boot-features-external-config.html

## Wildfly external configuration 

/opt/wildfly/standalone/configuration/standalone.xml

set spring profile with 

<property name="spring.profiles.active" value="dev"/>

set location with classpath and location of the configuration file

<property name="spring.config.location" value="classpath:/,file:///opt/wildfly/standalone/configuration"/>

copy application-dev.properties to /opt/wildfly/standalone/configuration