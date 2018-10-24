package inputOutput.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * CONTINUE: Se debe continuar la visita del siguiente nodo en el árbol de directorios.
 * SKIP_SIBLINGS: Señala que se debe continuar el recorrido sin visitar a los hermanos del archivo o directorio. No se llamará al postVisit
 * SKIP_SUBTREE: Señala que se debe continuar el recorrido de los nodos sin visitar las entradas de este directorio,
 * por lot tanto, solo tiene sentido en preVisitDirectory y no afecta files.
 * TERMINATE: Indica la finalización del proceso de visita.
 */
public class _9c_NIO_PrintNames extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    // to call after entries in the directory, and all its descendants, have been visited.
    // postVisitDirectory()

    //a file can't be accessed (you decide throw it, print it, ...)
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
