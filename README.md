# Microservicio Optimización de Portafolio

## Instalación
1. Abrir XAMPP y crea la base de datos `portfolio_db`.
2. Modifica `application.properties` con tus credenciales.
3. Compila el proyecto: `mvn clean package`
4. Ejecuta: `java -jar target/app.jar`
5. Accede a Swagger UI en `http://localhost:8080/swagger-ui.html`

## Endpoint
- **POST /optimizar**
- **Entrada:**
```json
{
  "capacidad": 10000,
  "objetos": [
    {"nombre": "A", "peso": 2000, "ganancia": 1500},
    {"nombre": "B", "peso": 4000, "ganancia": 3500},
    {"nombre": "C", "peso": 5000, "ganancia": 4000},
    {"nombre": "D", "peso": 3000, "ganancia": 2500}
  ]
}
```
- **Salida:**
```json
{
  "seleccionados": ["B", "C"],
  "ganancia_total": 7500,
  "peso_total": 9000
}
```

## Docker
```sh
docker build -t portfolio-app .
docker run -p 8080:8080 portfolio-app
```
