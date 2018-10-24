package inputOutput.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * sourcePath = "FileTree/Dir2/Dir3/file1.txt";
 * sourceRoot = "FileTree/Dir2";
 * targetRoot = "FileTree/Dir4/Dir2Copy";
 * relativizedPath = sourceRoot.relativize(sourcePath); which = "Dir3/file1.txt"
 * resolvedPathForCopy = targetRoot.resolve(relativizedPath); which = "FileTree/Dir4/Dir2Copy/Dir3/file1.txt"
 */
public class _9b_NIO_CopyFiles  extends SimpleFileVisitor<Path> {

    private Path sourceRoot;
    private Path targetRoot;

    public _9b_NIO_CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);

        try {
            Files.copy(dir, copyDir);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);

        try {
            Files.copy(file, copyDir);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return FileVisitResult.CONTINUE;
    }
}
