# 🛒 Ecommerce Microservices

Проект с микросервисной архитектурой: Spring Boot + Eureka + Gateway + Docker Compose.

## 📦 Сервисы

| Сервис               | Порт | Назначение               |
|----------------------|------|--------------------------|
| eureka-server        | 8761 | Service Discovery        |
| api-gateway          | 8080 | Единая точка входа       |
| order-service        | 8081 | Заказы                   |
| payment-service      | 8082 | Оплата                   |
| product-service      | 8083 | Каталог товаров          |
| inventory-service    | 8084 | Склад                    |
| user-service         | 8085 | Пользователи             |
| notification-service | 8086 | Уведомления              |

## 🚀 Запуск

```bash
./mvnw clean install -DskipTests
docker-compose up --build
