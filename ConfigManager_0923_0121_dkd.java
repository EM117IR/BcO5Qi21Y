// 代码生成时间: 2025-09-23 01:21:53
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.NonNull;
import java.util.Map;

/**
 * ConfigurationManager class to manage application configurations.
 * It uses Micronaut's ConfigurationProperties to bind configuration data.
 */
@Requires(env = "production") // This configuration is only required in production environment.
@ConfigurationProperties(prefix = "app.config")
public class ConfigManager {

    private Map<String, String> properties;

    // Getter for properties
    public Map<String, String> getProperties() {
        return properties;
    }

    // Setter for properties, required by ConfigurationProperties
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    /**
     * Retrieves a configuration value by key, providing a default value if the key is not found.
     * 
     * @param key The key of the configuration property.
     * @param defaultValue The default value to return if the key is not present.
     * @return The configuration value or the default value if not found.
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getOrDefault(key, defaultValue);
    }

    /**
     * Retrieves a required configuration value by key, throwing an exception if the key is not found.
     * 
     * @param key The key of the configuration property.
     * @return The configuration value.
     * @throws IllegalArgumentException if the key is not present in the configuration.
     */
    public String getRequiredProperty(@NonNull String key) {
        if (!properties.containsKey(key)) {
            throw new IllegalArgumentException("Required property '