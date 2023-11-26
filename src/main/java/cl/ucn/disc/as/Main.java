package cl.ucn.disc.as;

import cl.ucn.disc.as.grpc.PersonaGrpcServiceImpl;
import cl.ucn.disc.as.ui.ApiRestServer;
import cl.ucn.disc.as.ui.WebController;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 *
 */
@Slf4j
public final class Main {
    /**
     * Entrypoint
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException  {

        log.debug("Starting Main ..");

        log.debug("Starting the REST API server ..");
        Javalin app = ApiRestServer.start(7070, new WebController());

        //log.debug("Stopping ..");
        //app.stop();

        log.debug("Starting the gRPC server ..");
        Server server = ServerBuilder
                .forPort(50123)
                .addService(new PersonaGrpcServiceImpl())
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
        server.awaitTermination();
        log.debug("Done.");
    }
}
