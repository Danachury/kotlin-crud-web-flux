FROM postgres:12.3-alpine
COPY init.sql /docker-entrypoint-initdb.d/
