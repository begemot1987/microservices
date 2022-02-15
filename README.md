# microservices

Eureka naming server -> http://localhost:8761

Currency exchange service -> http://localhost:8000/currency-exchange/from/USD/to/UAH </br>

Currency conversion service with hardcoded routs -> http://localhost:8100/currency-converter/from/EUR/to/UAH/quantity/1000 </br>
Currency conversion service with feign -> http://localhost:8100/currency-converter-feign/from/EUR/to/UAH/quantity/1000 </br>

Currency conversion service using api gateway http://localhost:8765/convert/from/USD/to/UAH/quantity/1000 </br>

API Gateway -> http://localhost:8765
