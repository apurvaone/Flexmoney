# Flexmoney

I have implemented the problem in an android application, I have used cloud firestore database from firebase to store the data of yoga classes participants across batches.

 ### APK Link ###
Link :  [Android apk](https://drive.google.com/file/d/1_VH-nSTVJ9vP-pFKB2hz8Bo34-8bBajX/view?usp=sharing/ "Android APK") 

 ### Screenshots ###
[![HouI7CQ.jpg](https://iili.io/HouI7CQ.jpg)](https://freeimage.host/)     [![Houo92e.jpg](https://iili.io/Houo92e.jpg)](https://freeimage.host/)

In my application i have used NoSQL database called called Firestore. Similar to other NoSQL databases cloud firestore is also based on Collections and Document Structure.
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
              
              
#### Participants ####
Participants is a collection, it has documents as objects which contains basic data required for registration of user for yoga class. batch_id is id which is used to refernece to another collection called batches. 
              

