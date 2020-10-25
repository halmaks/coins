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




