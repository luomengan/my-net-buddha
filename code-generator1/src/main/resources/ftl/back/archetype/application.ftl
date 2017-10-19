endpoints.shutdown.enabled=true

server.port=9090
server.context-path=/${projectName}/
server.tomcat.uri-encoding=utf-8

spring.datasource.url=jdbc:mysql://localhost:3306/${projectName}?characterEncoding=UTF-8
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.database=mysql
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.properties.hibernate.current_session_context_class=org.springframework.orm.hibernate4.SpringSessionContext

spring.http.multipart.max-file-size=100MB
spring.http.multipart.max-request-size=100MB