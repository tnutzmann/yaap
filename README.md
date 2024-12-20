# yaap
Yet Another Automation Platform 

## Komponenten

### 1. Frontend

Interaktion mit Workflows und Überwachung.
Authentifizierung über Keycloak (z. B. Single Sign-On, OAuth2).
*Technologie*: React oder Vue.js.

### 2. Keycloak (Identity und Access Management)

Verwaltung von Benutzern, Rollen und Authentifizierungsmethoden.
Integration mit Spring Boot Backend und Frontend über OAuth2/OpenID Connect.
Unterstützung für Social Logins (z. B. Google, GitHub) oder LDAP.
*Technologie*: Keycloak mit Docker/Kubernetes-Deployment.

### 3. Backend (Spring Boot)

Zentraler Koordinator für Workflows und API.
Verwaltung der Verbindung zu Keycloak, der Datenbank und RabbitMQ.
Kommunikation mit Go- und Python-Services über HTTP/gRPC.
*Technologie*: Spring Boot mit REST-APIs.

### 4. Serverless Functions
Go-Service (z. B. für Performance-kritische Aufgaben):
Funktion Datenverarbeitung, z. B. Transformation großer Datenmengen.
*Technologie*: Go, ausgeführt als Knative- oder OpenFaaS-Funktion.

Python-Service (z. B. für Datenanalyse/Datentransformation):
Funktion Analyse-Tasks, z. B. Datenvisualisierung oder KI-gestützte Entscheidungen.
*Technologie*: Python, ausgeführt als Knative- oder OpenFaaS-Funktion.

### 5. Message Queue

Asynchrone Kommunikation zwischen Backend, Python, und Go-Services.
Workflow-Schritte parallelisieren und entkoppeln.
*Technologie*: RabbitMQ.

### 6. Datenbank

Speichern von Workflows, deren Status, Logs und Benutzerdaten.
*Technologie*: PostgreSQL.

### 7. Kubernetes Cluster

Orchestrierung aller Services (Backend, Keycloak, serverlose Funktionen).
Sicherstellung von Skalierbarkeit und Stabilität.
*Technologie*: Kubernetes mit Helm-Charts.

### 8. Monitoring und Analyse

Sammlung von Logs und Metriken.
Überwachung der Workflow-Ausführungen und Systemressourcen.
*Technologie*: Prometheus, Grafana, Loki.