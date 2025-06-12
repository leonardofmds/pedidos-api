#Criando uma máquina virtual com JDK 21
FROM openjdk:21
#Criando uma pasta no container para onde o projeto será publicado
WORKDIR /app
#Copiando todos os arquivos do projeto para dentro desta pasta
COPY . /app
#Comando para realizar o deploy do projeto (publicação)
RUN ./mvnw -B clean package -DskipTests
#Informar a porta em que o projeto será executado
EXPOSE 8081
#Comando para rodar o projeto dentro do container
CMD ["java", "-jar", "target/pedidos-api-0.0.1-SNAPSHOT.jar"]

