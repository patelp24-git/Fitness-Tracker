# Architecure

The fitness tracker app will be built using a common three layered 
architecture that will keep the source code nicely seperate in a way that makes sense. 
The three layers of the applications architecture will be the Presentation layer, 
the Logic layer and the Persistence layer. 

# Presentation Layer

This layer will be responsible for displaying information to the user of the application
as well as accepting the users input and sending the input information to the correct 
part of the logic layer to be processed.

This layer includes:
1. MainActivity.java
2. StepCounter.java

# Logic Layer

This layer will be responsible for any of the data processing and manipulation required
by the application. It will recieve information  from the presentation layer and/or the 
persistence layer, process the data in some way, and then send the proccessed information 
to the logic and/or persistance layer.

This layer includes:
1. StepCountReciever.java
2. StepCountService.java

# Persistence Layer

This layer will be responsible for permanently storing and data needed by the application
as well providing the logic layer a way of accessing the data. The persistence layer will
recieve data to be stored from the logic layer and send data back to the logic layer once 
it is requested.

This layer includes: 
1. Backend.java
2. Data.java
3. FakeDatabase.java
 
# [View Architecture Diagram](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/Documentation/Screenshots/ArchitectureDiagram.png)