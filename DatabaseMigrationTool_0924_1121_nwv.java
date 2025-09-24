// 代码生成时间: 2025-09-24 11:21:20
package com.example.migrations;

import io.micronaut.context.annotation.Requires;
import io.micronaut.core.io.ResourceResolver;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.exceptions.InternalServerException;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.scheduling.TaskExecutors;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Controller("/migrations")
@Requires(beans = EmbeddedServer.class)
public class DatabaseMigrationTool {
    
    private static final Logger logger = LoggerFactory.getLogger(DatabaseMigrationTool.class);
    private final Flyway flyway;
    private final ExecutorService executorService;

    @Inject
    public DatabaseMigrationTool(ResourceResolver resourceResolver) {
        this.flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:h2:mem:migrationdb", "sa", "sa")
                .locations("db/migration")
                .load();

        this.executorService = (ExecutorService) this.getClass().getClassLoader().getResourceAsStream("META-INF/micronaut-runtime.yml")
                .map(resource -> Micronaut.getConfiguration().get("datasources.default")
                        .get("url", String.class))
                .orElseThrow(() -> new InternalServerException("Failed to read datasource configuration"));
    }

    @Get("/status")
    public HttpResponse<List<MigrationInfo>> migrationStatus() {
        try {
            List<MigrationInfo> migrationInfos = flyway.info().all();
            return HttpResponse.ok(migrationInfos);
        } catch (SQLException e) {
            logger.error("Error retrieving migration status: ", e);
            throw new InternalServerException("Failed to retrieve migration status", e);
        }
    }

    @Get("/migrate")
    public HttpResponse<String> migrateDatabase() {
        try {
            flyway.migrate();
            return HttpResponse.ok("Database has been successfully migrated");
        } catch (Exception e) {
            logger.error("Error during database migration: ", e);
            throw new InternalServerException("Failed to migrate database", e);
        }
    }

    @Get("/repair")
    public HttpResponse<String> repairDatabase() {
        try {
            flyway.repair();
            return HttpResponse.ok("Database has been successfully repaired");
        } catch (Exception e) {
            logger.error("Error during database repair: ", e);
            throw new InternalServerException("Failed to repair database", e);
        }
    }

    // Additional methods for other migration operations can be added here.
}
