https://www.javaguides.net/2019/01/springboot-postgresql-jpa-hibernate-crud-restful-api-tutorial.html?m=1

for run:

$ mvn spring-boot:run

or:
$ mvn compile
$ mvn package
$ java -jar target/coins-0.0.1-SNAPSHOT.jar

or:
$ mvn clean package
$ java -jar target/coins-0.0.1-SNAPSHOT.jar

or:
$ docker build -t coins .
$ docker run --rm -p 8080:8080 coins

or:
$ docker build -t coins .
$ docker run -d --rm --net="host" -it coins


example POST from httpie:

13:55:07 maksim ~ $ http POST http://halmaks-lp:8080/api/v1/customer name=sania phone=33384 email=sania@gmail.com
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sun, 25 Oct 2020 10:59:05 GMT
Transfer-Encoding: chunked

{
    "email": "sania@gmail.com",
    "id": 12,
    "name": "sania",
    "phone": "33384"
}

13:59:05 maksim ~ $ 


example GET with id from httpie:

14:23:58 maksim ~ $ http http://halmaks-lp:8080/api/v1/customer/2
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sun, 25 Oct 2020 11:34:41 GMT
Transfer-Encoding: chunked

{
    "email": "vasvasiliy@gmail.com",
    "id": 2,
    "name": "Vasiliy",
    "phone": "375336116109"
}

14:34:41 maksim ~ $ 


example GET all from httpie:

14:17:02 maksim ~ $ http GET http://halmaks-lp:8080/api/v1/customer
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sun, 25 Oct 2020 11:17:53 GMT
Transfer-Encoding: chunked

[
    {
        "email": "olegg@gmail.com",
        "id": 1,
        "name": "Oleg",
        "phone": "375295111139"
    },
    {
        "email": "vasvasiliy@gmail.com",
        "id": 2,
        "name": "Vasiliy",
        "phone": "375336116109"
    },
    {
        "email": "veraverina@gmail.com",
        "id": 3,
        "name": "Vera",
        "phone": "375335557666"
    },
    {
        "email": "fedfed@yandex.ru",
        "id": 4,
        "name": "Fedia",
        "phone": "375298955768"
    },
    {
        "email": "sss@ya.ru",
        "id": 5,
        "name": "Kiril",
        "phone": "375"
    },
    {
        "email": "sss@ya.ru",
        "id": 6,
        "name": "Kiril",
        "phone": "375"
    },
    {
        "email": "sss@ya.ru",
        "id": 7,
        "name": "Kiril",
        "phone": "375"
    },
    {
        "email": "sss@ya.ru",
        "id": 8,
        "name": "Kiril",
        "phone": "375"
    },
    {
        "email": "cris23232@yahoo.com",
        "id": 9,
        "name": "Cris",
        "phone": "380020020645"
    },
    {
        "email": "cris23232@yahoo.com",
        "id": 10,
        "name": "Cristian",
        "phone": "380020020645"
    },
    {
        "email": "sss@ya.ru",
        "id": 11,
        "name": "Kiril",
        "phone": "375"
    },
    {
        "email": "sania@gmail.com",
        "id": 12,
        "name": "sania",
        "phone": "33384"
    }
]

14:17:53 maksim ~ $ 


exapple PUT with id from httpie:

14:50:06 maksim ~/workspace/coins (master) $ http PUT http://halmaks-lp:8080/api/v1/customer/11 phone=4444444
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sun, 25 Oct 2020 11:50:47 GMT
Transfer-Encoding: chunked

{
    "email": null,
    "id": 11,
    "name": null,
    "phone": "4444444"
}

14:50:47 maksim ~/workspace/coins (master) $ 

15:00:40 maksim ~/workspace/coins (master) $ http PUT http://halmaks-lp:8080/api/v1/customer/11 phone=4444444 email=Bob@yahoo.com name=Bob
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sun, 25 Oct 2020 12:01:49 GMT
Transfer-Encoding: chunked

{
    "email": "Bob@yahoo.com",
    "id": 11,
    "name": "Bob",
    "phone": "4444444"
}

15:01:49 maksim ~/workspace/coins (master) $


example DELETE with id from httpie:

14:34:41 maksim ~ $ http DELETE http://halmaks-lp:8080/api/v1/customer/12
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sun, 25 Oct 2020 11:42:45 GMT
Transfer-Encoding: chunked

{
    "deleted": true
}

14:42:45 maksim ~ $ 

01:04:34 maksim ~ $ http POST http://halmaks-lp:8080/api/v1/product name=display description="29 inch, 2560 x 1080" price=210
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Wed, 28 Oct 2020 22:05:24 GMT
Transfer-Encoding: chunked

{
    "description": "29 inch, 2560 x 1080",
    "id": 4,
    "name": "display",
    "price": 210
}

01:05:24 maksim ~ $ 

04:46:19 maksim ~/workspace/coins (master) $ http POST http://halmaks-lp:8080/api/v1/product-photo url="https://www.nathing.com/nathing/image-11111.jpg" productId=5
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sat, 31 Oct 2020 01:46:57 GMT
Transfer-Encoding: chunked

{
    "id": 8,
    "productId": 5,
    "url": "https://www.nathing.com/nathing/image-11111.jpg"
}

04:46:57 maksim ~/workspace/coins (master) $



