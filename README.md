# Flexmoney Assessment

This assessment has been done using android application written in Java, it uses Cloud Firestore database from firebase to store the data of yoga classes participants across batches.

 ### APK Link ###
Link :  [Android apk](https://drive.google.com/file/d/1_VH-nSTVJ9vP-pFKB2hz8Bo34-8bBajX/view?usp=sharing/ "Android APK") 


 ### Screenshots ###
[![HouI7CQ.jpg](https://iili.io/HouI7CQ.jpg)](https://freeimage.host/)     [![Houo92e.jpg](https://iili.io/Houo92e.jpg)](https://freeimage.host/)

The database used here is Firestore. Similar to other NoSQL databases cloud firestore is also based on Collections and Document Structure.
So basically there are two Collections with mentioned attributes

          * Participants
              * name
              * age
              * contact
              * batch_id
              * payment_status
              
                  
          * Batches
              * timing
              * capacity
              * filled
              
              
              
              
### Collections ###
        
##### 1. Participants #####
Participants is a collection, it has documents as objects which contains basic data required for registration of user for yoga class. batch_id is id which is used to refernece to another collection called batches. 
              
##### 2. Batches #####
Batches is also a collection here, it has 4 documents or objects with id 0,1,2,3 referring to 4 batches which are in operation. Each batch as 3 attributes timing,capacity(denoting total capacity of batch) and filled(current occupancy of batch).




### APP Overview ###
The applications consists of two fragments(pages), 

in First page (screenshot 1) there is user registration form, which takes user inputs for registration, it accepts name, age, contact, and batch in which user tries to get registerd, batch is a dropdown menu here, by clicking it option of available batches pops up.

in Second page(screenshot 2), i have shown details of available batches and their status, it shows realtime availability of seats in corresponding batches.

### Database implementation in Cloud Firestore ###

##### 1. Batches #####

[![HouV0sS.md.png](https://iili.io/HouV0sS.md.png)](https://freeimage.host/i/HouV0sS)

##### 2. Participants #####

[![Hou4GtI.md.png](https://iili.io/Hou4GtI.md.png)](https://freeimage.host/i/Hou4GtI)

