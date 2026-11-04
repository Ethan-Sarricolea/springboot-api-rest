# API Rest Spring-boot

## Descripción

Esta es un backend API Rest desarrollado para la gestión de tareas con "TaskApp" por medio del framework Spring Boot 4. Basado en la arquitectura de capas, DTOs (Data Transfer Object), mappers e inyección de dependencias explicado en los materiales de referencia:

- Video guía: [How to Build Your First Spring Boot App - Devtiro](https://www.youtube.com/watch?v=M2U4_t_PSRM)
Guía escrita "Task App V2 Documentation - GitHub": https://github.com/devtiro/devtiro-task-app/tree/main 

## Ejecución

1. Clonar el repositorio

2. Verificar que el puerto 8080 no esta bloqueado:
```bash
netstat -ano | findstr :8080
```

    a. De estar ocupado, detener el proceso para permitir la ejecución del backend
```bash
taskkill /PID <PID> /F
```

2. Ejecutar backend
```bash
./mvnw spring-boot:run
```

3. Abrir docker y ejecutar imagen
```bash
docker compose up --build
```

## Estructura del proyecto

```
springboot-api-rest/
├── docker-compose.yml                            # Levanta la UI en http://localhost:3000
├── frontend/                                     # Código de la interfaz (React) provista
├── pom.xml                                       # Dependencias y configuración de Maven
└── src/
    ├── main/
    │   ├── java/com/devtiro/tasks/
    │   │   ├── TasksApplication.java             # Punto de entrada de Spring Boot
    │   │   ├── controllers/
    │   │   │   ├── TaskController.java           # Endpoints REST en /api/v1/tasks
    │   │   │   └── GlobalExceptionHandler.java   # Manejo global de errores (HTTP 400)
    │   │   ├── domain/
    │   │   │   ├── TaskStatus.java               # Enum: OPEN, COMPLETE
    │   │   │   ├── TaskPriority.java             # Enum: HIGH, MEDIUM, LOW
    │   │   │   ├── CreateTaskRequest.java        # Datos internos para crear una tarea
    │   │   │   ├── UpdateTaskRequest.java        # Datos internos para actualizarla
    │   │   │   ├── dto/
    │   │   │   │   ├── CreateTaskRequestDto.java # Entrada de la API (con validaciones)
    │   │   │   │   ├── UpdateTaskRequestDto.java # Entrada de la API (con validaciones)
    │   │   │   │   ├── TaskDto.java              # Respuesta de la API
    │   │   │   │   └── ErrorResponseDto.java     # Formato estándar de error
    │   │   │   └── entities/
    │   │   │       └── Task.java                 # Entidad JPA (tabla "tasks")
    │   │   ├── exceptions/
    │   │   │   └── TaskNotFoundException.java    # Se lanza si la tarea no existe
    │   │   ├── mappers/
    │   │   │   ├── TaskMapper.java               # Contrato de conversión DTO <-> entidad
    │   │   │   └── impl/TaskMapperImpl.java      # Implementación del mapper
    │   │   ├── repositories/
    │   │   │   └── TaskRepository.java           # Acceso a datos (JpaRepository)
    │   │   └── services/
    │   │       ├── TaskService.java              # Contrato de la lógica de negocio
    │   │       └── impl/TaskServiceImpl.java     # Lógica de negocio (CRUD)
    │   └── resources/
    │       └── application.properties            # Configuración de la aplicación
    └── test/java/com/devtiro/tasks/
        └── TasksApplicationTests.java            # Prueba de carga del contexto
```
