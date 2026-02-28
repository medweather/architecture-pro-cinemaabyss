FROM bhgedigital/envsubst AS build

ARG MONOLITH_URL
ARG GRADUAL_MIGRATION
ARG EVENTS_SERVICE_URL
ARG MOVIES_SERVICE_HOST
ARG MONOLITH_HOST
ARG MOVIES_MIGRATION_PERCENT

WORKDIR /app

COPY ./kong/kong.yml ./etc/kong.template.yml

ENV K_MONOLITH_URL=$MONOLITH_URL
ENV K_GRADUAL_MIGRATION=$GRADUAL_MIGRATION
ENV K_EVENTS_SERVICE_URL=$EVENTS_SERVICE_URL
ENV K_MOVIES_SERVICE_HOST=$MOVIES_SERVICE_HOST
ENV K_MONOLITH_HOST=$MONOLITH_HOST
ENV K_MOVIES_MIGRATION_PERCENT=$MOVIES_MIGRATION_PERCENT

RUN awk -v movie="$MOVIES_MIGRATION_PERCENT" '{ gsub(/MONOLITH_PERCENT/, 100 - movie); print }' /app/etc/kong.template.yml > tmp.yml && \
    mv tmp.yml /app/etc/kong.template.yml

RUN mkdir /app/etc/kong && envsubst < /app/etc/kong.template.yml > /app/etc/kong/kong.yml

FROM kong/kong-gateway:latest

ENV KONG_DATABASE=off
ENV KONG_DECLARATIVE_CONFIG=/app/etc/kong/kong.yml
ENV KONG_ADMIN_LISTEN=0.0.0.0:8001
ENV KONG_ADMIN_GUI_URL=http://localhost:8002

WORKDIR /app

COPY --from=build /app/etc/kong/kong.yml ./etc/kong/kong.yml



