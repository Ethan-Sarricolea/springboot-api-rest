# springboot-api-rest

Pasos realizados:

## 1. Generar el proyecto

a. Crear el zip del proyecto

```bash
curl https://start.spring.io/starter.zip -d type=maven-project -d language=java -d bootVersion=4.0.0 -d groupId=com.devtiro -d artifactId=tasks -d dependencies=web,validation,data-jpa,h2 -d javaVersion=21 -o tasks.zip
```

a. Descomprimir `tasks.zip`

```bash
expand-Archive -Path .\tasks.zip -DestinationPath .
```

## 2. Obtener el docker-compose

a. clonar 
```bash
git clone https://github.com/devtiro/devtiro-task-app.git /tmp/devtiro
```

b. Buscar el docker compose y copiarlo a la carpeta actual
```bash
ls /tmp/devtiro
cp /tmp/devtiro/docker-compose.yml .
```

## 3. Probar spring boot y UI

a. Clonar el repo de referencia (fuera del proyecto) y copiar `frontend` y el compose a la raíz:
```bash
cd <carpeta-fuera-del-proyecto>
git clone https://github.com/devtiro/devtiro-task-app.git devtiro-ref
Copy-Item -Recurse .\devtiro-ref\frontend <ruta-del-proyecto>\frontend
Copy-Item .\devtiro-ref\docker-compose.yml <ruta-del-proyecto>\
```

b. Parar el proceso del puerto 8080:
```bash
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

c. Verificar el funcionamiento de ambos:

```bash
./mvnw spring-boot:run #BAck
docker compose up      # UI enn http://localhost:3000
```

d. Entrar a la pagina
```bash
start msedge "http://localhost:3000/"
```

