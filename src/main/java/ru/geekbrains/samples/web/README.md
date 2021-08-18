# kolumarket

##PostgreSQL
docker run -p 5435:5432 -d -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=gb -v pgdata:/var/lib/postgresql/data postgres