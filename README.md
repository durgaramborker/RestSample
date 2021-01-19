# RestSample

A sample  MySql based REST deployment using jersey REST and maven.


 Querries
1. GET-http://localhost:8080/RestSample/webapi/resources/getlist
2. GET-http://localhost:8080/app/webapi/resources/getobject/{id} :get specific resource based on name.
3. POST-http://localhost:8080/RestSample/webapi/resources/add :add resource
4. PUT-http://localhost:8080/RestSample/webapi/resources/update :update resource
5: DELETE-http://localhost:8080/RestSample/webapi/resources/kill/{id} :delete the resource 



all changes haapen in DB. 


for POST, PUT, DELETE, mention JSON object in the body as given below:
  
  {
        "cprice": 500,
        "name": "prada",
        "price": 1500,
        "qty": 80
  }
  
  example for GET(2) and DELETE(5):
  
    GET-http://localhost:8080/app/webapi/resources/getobject/prada
    DELETE -http://localhost:8080/RestSample/webapi/resources/kill/prada
