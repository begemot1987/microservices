# microservices

Eureka naming server -> localhost:8761

Currency exchange service -> localhost:8000/currency-exchange/from/USD/to/UAH

Currency conversion service with hardcoded routs -> http://localhost:8100/currency-converter/from/EUR/to/UAH/quantity/1000
Currency conversion service with feign -> http://localhost:8100/currency-converter-feign/from/EUR/to/UAH/quantity/1000

Currency conversion service using api gateway http://localhost:8765/convert/from/USD/to/UAH/quantity/1000

API GAteway -> localhost:8765
