
> Manually (fastly)
1. Create network (if not exist)

- ```docker network create chatbot_network ```
2. Build the database.

- ```docker run --name db -e POSTGRES_DB=chatbot_db -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root --net chatbot_network -p 5432:5432 -d postgres:13```
3. Build and run java application.
 
- ```docker build -t management -f Dockerfile.dev .```
- ```docker run --name management --net chatbot_network -p 8088:8088 management```

> Run with docker compose
- ```docker compose up```
**Document API url: http://localhost:8088/swagger-ui/index.html**
