# Spring Boot MongoDB

Spring Boot and MongoDB in REST Application

**Creating New Record**:

`http://localhost:8080/booking/create?psngrName=Uzumaki&destination=Konohagakure&departure=Sunagakure`

Results :
```
{
  "booking": {
    "id": "590bbdd71f2158ec3ba0709a",
    "psngrName": "Uzumaki",
    "departure": "Sunagakure",
    "destination": "Konohagakure",
    "travelDate": 1493941719405
  },
  "message": "Booking created successfully",
  "status": "1"
}
```

**Reading a Record:**

`http://localhost:8080/booking/read?bookingId=590bbdd71f2158ec3ba0709a`
```

{
  "booking": {
    "id": "590bbf251f2158ec3ba0709b",
    "psngrName": "Ijem Saritem",
    "departure": "Hongkong",
    "destination": "Jakarta",
    "travelDate": 1493942053325
  },
  "message": "Booking updated successfully",
  "status": "1"
}
```

**Updating a Record:**

`http://localhost:8080/booking/update?bookingId=590bbdd71f2158ec3ba0709a&psngrName=Sasuke`

```
{
  "booking": {
    "id": "590bbf251f2158ec3ba0709b",
    "psngrName": "Ijem Saritem",
    "departure": "Hongkong",
    "destination": "Jakarta",
    "travelDate": 1493942053325
  },
  "message": "Booking updated successfully",
  "status": "1"
}
```

**Read All Records**

`http://localhost:8080/booking/read-all`

**Deleting a Record:**

```
http://localhost:8080/booking/delete?bookingId=590bbdd71f2158ec3ba0709a
{
• message: "Booking deleted successfully",
• status: "1"
}
```