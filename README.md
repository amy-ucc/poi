# POI Workflow

## > Distribute just one jar file. 
All dependencies are included in the jar file  

The data folder is not included in the jar file and must be in the same directory as the jar file so make sure to have that as well.  

Eg for it to work  

./poi.jar  
./data/  
./data/floorMaps/ {all the floor map images}  
./data/images/ {all the images like pins etc }  


``` bash
mvn clean compile assembly:single
```

### How to run the jar once you have all of that above set up
``` bash
java -jar poi.jar
```

## > If you want to run all tests
```bash
mvn clean compile test-compile test
```

## > If you want to run all tests and create the jar file
```bash
mvn clean compile test-compile test assembly:single
```

### The model readme is here [Model Readme](src/main/java/com/u3/model/README.md)
