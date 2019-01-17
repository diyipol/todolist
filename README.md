# TODO List

Típica aplicación de notas con tareas TODO para poder usar de prueba en diferentes ejemplos.

Operaciones documentadas en swagger: http://localhost:8080/todolist/swagger-ui.htm



##Imagen docker

El proyecto contiene un `Dockerfile`. Para construir la imagen docker es necesario primero crear el jar de la aplicación con `mvn clean package`.

Con el jar ya creado ya podemos crear la imagen docker.

```shell
docker build -t todolist .
```

Finalmente arrancamos la imagen con:

```shell
docker run -p 8080:8080 todolist
```

