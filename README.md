# Lost & Found REST API

A **Lost & Found management system** built using **Java Spring Boot** and **MongoDB**.  
The application allows users to report found items, search items, claim items, and manage lost & found records through REST APIs.

---

## Tech Stack

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB Atla
- REST API
- Postman (for testing)

---
# MongoDB Document Design
```
{
  "_id": "ObjectId",
  "itemName": "Wallet",
  "color": "Black",
  "description": "Leather wallet",
  "placeFound": "Library",
  "dateFound": "2026-03-16",
  "timeFound": "10:30",
  "reportedBy": {
    "studentId": "ST101",
    "name": "Rahul Sharma"
  },
  "status": "FOUND"
}
```

# REST API Endpoints
## 1. Add Found Item
    POST lostfound/items

## 2. Get All Items
    GET lostfound/items

## 3. Get Item By ID
    GET lostfound/items/{id}
    
## 4. Search Item
    GET lostfound/items/search?name=wallet
    
## 5. Claim Item
    PUT lostfound/items/{id}/claim
