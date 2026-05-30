# e-commerce
Projeto para realizar um e-commerce, seguindo bons padrões de projeto, com observabilidade e escalável.


# Arquitetura do projeto

e-commerce/
│
├── services/
│   ├── catalog/        # Serviço de catálogo (Quarkus)
│   ├── cart/           # Serviço de carrinho
│   ├── orders/         # Serviço de pedidos
│   ├── payments/       # Serviço de pagamentos
│   └── notifications/  # Serviço de notificações
│
├── infra/
│   ├── kafka/          # Configuração do Kafka (docker-compose ou helm charts)
│   ├── postgre/        # Configuração do Banco
|   ├── grafana-tempo/  # Configuração do Tempo
│   ├── grafana-mimir/  # Configuração do Mimir
│   ├── grafana-loki/   # Configuração do Loki
│   └── grafana/        # Dashboards e configs
│
├── observability/
│   ├── otel-config/    # Configuração OpenTelemetry (exporters, collectors)
│   └── dashboards/     # JSON/YAML dos dashboards do Grafana
│
├── docs/
│   ├── architecture-diagram.png
│   └── README.md       # Explicação do projeto
│
└── docker-compose.yml  # Subir tudo localmente
