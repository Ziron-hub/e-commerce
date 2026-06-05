# Project Architecture

Micro-services Architecture

e-commerce/
│
├── services/
│   ├── catalog-service/        # Catalog service (Quarkus)
│   ├── cart-service/           # Shopping cart service
│   ├── orders-service/         # Orders service
│   ├── payments-service/       # Payments service
│   ├── notifications-service/  # Notifications service
│   ├── users-service/          # Users service
│   └── auth-service/           # Authentication/Authorization service
│
├── infra/
│   ├── kafka/          # Kafka configuration (docker-compose or helm charts)
│   ├── postgre/        # Database configuration
│   ├── grafana-tempo/  # Tempo configuration
│   ├── grafana-mimir/  # Mimir configuration
│   ├── grafana-loki/   # Loki configuration
│   └── grafana/        # Dashboards and configs
│
├── docs/
│   ├── architecture-diagram.png
│   └── README.md       # Project explanation
│
└── docker-compose.yml  # Run everything locally



Creating a service with basic dependencies using the Quarkus CLI:

quarkus create app com.ecommerce:service-name:1.0.0-SNAPSHOT \
  --extension=hibernate-orm-panache,rest,rest-jackson,jdbc-postgresql,messaging-kafka,opentelemetry,arc


# Cart Service

Use Cases:

- Add item to cart
- Remove item from cart
- List cart items
- Clear cart (remove all items)
- Publish Kafka event
- Observability (traces, metrics, logs)

# User Service
Use Cases:

- Add user
- Remove user
- List user
- Publish Kafka event for each use case
- Obersvability (traces, metrics, logs)

# Versions

Java 
    openjdk 21.0.11 2026-04-21 LTS
    OpenJDK Runtime Environment Temurin-21.0.11+10 (build 21.0.11+10-LTS)
    OpenJDK 64-Bit Server VM Temurin-21.0.11+10 (build 21.0.11+10-LTS, mixed mode, sharing)

Quarkus
    quarkus 3.36.0