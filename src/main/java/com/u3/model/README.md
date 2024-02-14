# Model

## Model Design
### --- Users (HashMap)
### --------- Pois (list) only favorites
### --- Buildings (HashMap)
### ------ FloorMaps (List)
### --------- Pois (list)


## Objects
### Model
``` java
Model model = Model.get() // static create or get singleton of model

Building bld = model.getBuilding("Middlesex College") // get a building
String [] strArr = model.getBuildingsArray() // get all building names in an array
ArrayList<Building> buildings =  model.getBuildingsList() // get all buildings

User usr = model.getUser("root") // get a user
String [] strArr = model.getUsersArray() // get all user names in an array
ArrayList<User> users =  model.getUsersList() // get all users

// save and print
model.serialize() // save model to file
model.printOut() // print out model to console

//check user password and set current user if it matches.
//Will return null if password is wrong 
User usr = model.login("root","password") 
User usr = model.getCurrentUser() // get current user, null if not set
```

### User
``` java
User.create("root","password") // create a new user - static method factory

user.addFav(poi) // add a poi to a users favorites and increases poi.favCount
```


### Building
``` java
ArrayList<FloorMap> maps = building.getFloors() // get all floor maps in a building
String [] strArr =  building.getFloorsArray() // get all floor names in an array
FloorMap map = building.getFloorMap(String floor) // get a floor map in a building
```


### FloorMap
``` java
ArrayList<Poi> poisAll = floormap.getPois() // get all pois in a floor map
ArrayList<Poi> poisBathroom = floormap.getPoiLayer("Bathroom") // get all pois in a layer in a floor map
ArrayList<Poi> poisFavs = getAllFavPois() // get all pois in a that have a favCount of 1 or higher

Poi poi = floorMap.getPoiAtPos(10,15) // get poi at a point in a floor map
ArrayList<Poi> poisInRect = floormap.getPoisWithinRect(int x1, int y1, int x2, int y2) // get all pois in a rectangle in a floor map

floormap.addPoi(poi) // add a poi to the floor map
floormap.savePoiAtPos(int x, int y, Poi poi) // update an existing poi

// how to an existing poi
Poi p = floorMap.getPoiAtPos(10,15);
p.setRoomNum("123");
p.setOwner("root");
p.addLayer("Bathroom");
// etc
floorMap.savePoiAtPos(p.getPos().getXPos(),p.getPos().getYPos(),poi);
```

### Poi
``` java
// create a new poi - static method factory
Poi p = Poi.create(String owner, Position pos, int favCount, String roomNum, String locDesc, String type, String fax, String label, String classification, String filePath, ArrayList<String> layers, ArrayList<String> tags); // tags and layers can useually be left as null the beginning

// edit a poi
p.addLayer("Bathroom"); // add a layer to a poi
p.addTag("tag1"); // add a tag to a poi
p.addFavCount(); // increase the favCount of a poi
p.setRoomNum("123"); // set the room number of a poi

//etc 

```


### Security

example in Floormap.java : line 158

``` java

    if (Model.get().getCurrUser().getUserid().equals(poi.getOwner()) == true)
    {  // check if current user is owner of poi
            // do something
    } else
    { // not owner
        // do something else
    }
```