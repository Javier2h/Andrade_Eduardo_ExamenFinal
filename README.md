# Microservicio Optimización de Portafolio

## Instalación
1. Abrir XAMPP y crea la base de datos `portfolio_db`.
2. Modifica `application.properties` con tus credenciales.
3. Ejecutar el proyecto: `mvn spring-boot:run` dentro de la carpeta backend, esto tambien isntala dependencias y todo 
5. Accede a Swagger UI en `http://localhost:8080/swagger-ui.html` o a postman con la url `http://localhost:8080/optimizar`


## Endpoint
  Este endpoint recibe los datos de los proyectos y la capacidad presupuestaria, y retorna la mejor combinación de proyectos optimizada según la ganancia total. Se debe enviar una solicitud POST con el siguiente formato:
- **POST /optimizar**
- **Entrada:**
```json
{
  "capacidad": 10000,
  "objetos": [
    {"nombre": "A", "peso": 2000, "ganancia": 1500},
    {"nombre": "B", "peso": 4000, "ganancia": 3500},
    {"nombre": "C", "peso": 5000, "ganancia": 4000},
    {"nombre": "D", "peso": 3000, "ganancia": 2500},
    {"nombre": "E", "peso": 3000, "ganancia": 2500}
  ]
}
```
- **Salida:**
```json
{
    "seleccionados": [
        "B",
        "D",
        "E"
    ],
    "ganancia_total": 8500,
    "peso_total": 10000
}
```

## Docker
```sh
docker build -t portfolio-app .
docker run -p 8080:8080 portfolio-app
```
## Pruebas de Funcionamiento
![Foto 1](https://blogger.googleusercontent.com/img/a/AVvXsEiSi46frHPTutedn_Z-5qZFtRB1BnFtf9-FIiWnrWFyEOPdVLh8cW9NaoO79J8LEHEuHw3Qn8j2CCdJu9XqDjmy2cqBgCrZRrC7T8fuPFB0nvLGObX9UV4o2_LFqmAjCHFLZ-UYKIie7Q15guxpGRfXw_Hypam1U-FQQLFQUu25Tnsv-VIAdgc4-Rd9WXU)
![Foto 2](https://blogger.googleusercontent.com/img/a/AVvXsEgqnzV1aJvxZXNVbOJJKOrbf1cS3-FgB6xw4hkA_5nL5fQ8QPPYwSkv4ZI1g9soVAdMTdfWs_jYwTdiU8kCt5J1ckmNLSJho7y9K1Ed1pTJadn3--i3uefBqiANgdN4G9k0LjicUX-93_FEhjj9cqJ6B0oXGOisJta2Cromi0TnTjJ51AlbvEGKleIBFqc)
![Foto 3](https://blogger.googleusercontent.com/img/a/AVvXsEgta7KTyJcmjSkJou94eKTHDqpDprTmaYWFb729esvwXf3ZyuSKUWUvZIL57dNgfHihapy-E8TFunuldYcqUyUemmOq4xmkng00O6nVNpi9V8HU01A6ndyJo3x8H1JjtD5Go4QBzsM-EpNI37YXkxL32-gr_quDTiRHRpHsJFlmjGJ5UCW0fQkPDCfMYwM)
![Foto 4](https://blogger.googleusercontent.com/img/a/AVvXsEjWwh2hDuvr6idKCaklLFloE3VLB5T5KG_LAjP9ZURkv_oafuQGo_xJULjufPvhD-TvCEg_-q86XgZ69fknA43VWaj5VYoGZbthdQf5NuzKdjQ_sJogl6Z2rwOFJp9Huy_PNySX1uIDs9oyhZXSXesfQJKvBYpj8FsQ3HEfsi5lRNKTiF643R_zYUnXqNk)
![Foto 5](https://blogger.googleusercontent.com/img/a/AVvXsEgv3wFGOQxdD9vR3YEQL4MpjYDXAZ0Exa8uTKMu6rXbfm2yny06lB7zWppI2Cq0udXvGV6kcdkySNU21qNhpejcBfsGbGHjVsL4D-cumHfgBPRIOvLdJc4LppAMKef5itFksy5Ecw5F6OMsVnIT_lovatF-GK-eBa0Jz8tg5vA5VSPw3pADn5B0KVVz65Q)
