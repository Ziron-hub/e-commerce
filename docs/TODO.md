# TODO and to think about the next steps
- CQRS Pattern: In e-commerce systems, we know that there are typically far more read operations than inserts or updates. By applying the CQRS (Command Query Responsibility Segregation) pattern, we can separate the responsibilities: one instance (or more) dedicated to handling inserts and updates, and multiple read replicas optimized for queries. This allows us to scale horizontally by adding more pods for reads or fewer pods for writes, depending on demand. 
- Create interfaces and better patterns to our micro services ?
- Put an Explain about stack observability in docs(Grafana, Tempo, Loki and Mimir)
- Put an section in docs "How to execute and ports available for each service"
- Create data flow examples and put here in docs
- Kafka events change to JSON type
- If high volume in kafka topics, think in some method to compact messages
- Schema validation, to valid http and messages kafka
- Services must be in singular