<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
    <logger name="com.baeldung.logback" level="INFO" />
    <logger name="com.baeldung.logback.tests" level="WARN" />
    <root level="debug">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>