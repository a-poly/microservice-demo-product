# Demo Microservice Example:  Product Service

This is a simple web / REST app that returns information on Products when asked.

/products - Returns a list of all products known to the service
/products/{code} - Returns info about a specific product, i.e. /products/AAA will return "{"id":1,"code":"AAA","price":10.00,"weight":10.00}"

The current product data at the start of the demo:
AAA inventory price $10, weighs 10 lbs.
BBB inventory price 20, weighs 20 lbs.
CCC inventory price 30, weighs 30 lbs.
DDD inventory price 40, weighs 40 lbs.
EEE inventory price 50, weighs 50 lbs.


This code also demonstrates:
- Basic usage of Spring Boot
- Spring Cloud is included, but not really used.
- Spring Cloud AWS is included, but not really used.
- Embedded HSQLDB Database, prepopulated with test data.
- Spring Data JPA.
- Runs nicely on or off AWS.
- Actuator endpoints are present.
