// 代码生成时间: 2025-09-19 20:57:14
import io.micronaut.context.annotation.Requires;
    import io.micronaut.http.HttpRequest;
    import io.micronaut.http.HttpResponse;
    import io.micronaut.http.annotation.Controller;
    import io.micronaut.http.client.HttpClient;
    import io.micronaut.http.client.annotation.Client;
    import reactor.core.publisher.Mono;
    import javax.inject.Singleton;

    /**
     * A simple web content crawler using Micronaut framework.
     * It fetches the content from a given URL and returns it.
     */
    @Requires(env = 