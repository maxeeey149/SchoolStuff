# Use the official PostgreSQL image
FROM postgres:latest

# Set environment variables for database credentials
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=gammelfleisch1
ENV POSTGRES_DB=postgres

# Expose PostgreSQL default port
EXPOSE 5432

# Create the TODOListItem table
COPY init.sql /docker-entrypoint-initdb.d/