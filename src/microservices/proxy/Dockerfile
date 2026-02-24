FROM bhgedigital/envsubst AS build

WORKDIR /app

COPY ./kong/kong.yml ./etc/kong.template.yml

ENV MONOLITH_URL=http://monolith:8080
ENV MOVIES_SERVICE_URL=http://movies-service:8081
ENV EVENTS_SERVICE_URL=http://events-service:8082
ENV GRADUAL_MIGRATION=true
ENV MOVIES_MIGRATION_PERCENT=10
ENV MOVIES_SERVICE_HOST=host.docker.internal:8081
ENV MONOLITH_HOST=host.docker.internal:8080

RUN mkdir /app/etc/kong && \
    envsubst < /app/etc/kong.template.yml > /app/etc/kong/kong.yml

FROM kong/kong-gateway:latest

ENV KONG_DATABASE=off
ENV KONG_DECLARATIVE_CONFIG=/app/etc/kong/kong.yml
ENV KONG_ADMIN_LISTEN=0.0.0.0:8001
ENV KONG_ADMIN_GUI_URL=http://localhost:8002

WORKDIR /app

COPY --from=build /app/etc/kong/kong.yml ./etc/kong/kong.yml



