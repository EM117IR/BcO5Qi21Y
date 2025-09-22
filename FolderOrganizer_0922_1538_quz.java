// 代码生成时间: 2025-09-22 15:38:51
import io.micronaut.context.annotation.Requires;
    import io.micronaut.core.annotation.ReflectiveAccess;
    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.Comparator;
    import java.util.List;
    import java.util.stream.Collectors;
    import javax.inject.Singleton;

    /**
     * A class to organize the structure of a folder.
     * It sorts files in a folder based on their names in ascending order and moves subdirectories to a separate directory.
     */
    @Requires(env = "test")
    @Singleton
    @ReflectiveAccess
    public class FolderOrganizer {

        private static final String SUBFOLDER_NAME = "subfolders";

        /**
         * Organizes the files in the specified directory.
         * Files are sorted by name and subdirectories are moved to a separate folder.
         * 
         * @param directoryPath The path of the directory to organize.
         * @throws IOException If an I/O error occurs.
         */
        public void organize(String directoryPath) throws IOException {
            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                throw new IllegalArgumentException("The specified path is not a valid directory.");
            }

            // Create a subfolder to hold all subdirectories
            File subfolder = new File(directory, SUBFOLDER_NAME);
            if (!subfolder.exists()) {
                subfolder.mkdirs();
            }

            // List all files and directories in the specified directory
            File[] files = directory.listFiles();
            if (files == null) {
                throw new IOException("Unable to list files in the directory.");
            }

            // Sort files by name in ascending order
            List<File> sortedFiles = List.of(files).stream()
                    .sorted(Comparator.comparing(File::getName))
                    .collect(Collectors.toList());

            // Move subdirectories to the subfolder
            for (File file : sortedFiles) {
                if (file.isDirectory()) {
                    Files.move(file.toPath(), Paths.get(subfolder.getAbsolutePath(), file.getName()));
                } else {
                    Files.move(file.toPath(), Paths.get(directory.getAbsolutePath(), file.getName()));
                }
            }
        }
    }