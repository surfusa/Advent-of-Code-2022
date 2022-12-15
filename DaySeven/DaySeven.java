package DaySeven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DaySeven {

    protected static class folder {
        private String folderName = null;
        private folder parent = null;
        private List<folder> subdirectories = new ArrayList<folder>();
        private List<fileInformation> listOfFiles = new ArrayList<fileInformation>();
        int sizeOfDirectory = 0;

        public folder(folder parent, String folderName) {
            if (parent != null) {
                this.parent = parent;
            }
            this.folderName = folderName;
        }

        public String getFolderName() {
            return folderName;
        }

        public void setFolderName(String folderName) {
            this.folderName = folderName;
        }

        public folder getParent() {
            return parent;
        }

        public int getSize() {
            return sizeOfDirectory;
        }

        public List<folder> getSubdirectories() {
            return subdirectories;
        }

        public folder getSubdirectory(String folderName) {
            for (folder myFolder : subdirectories) {
                if (myFolder.getFolderName().equals(folderName))
                    return myFolder;
            }
            System.out.println("Failed to find folder!");
            return null;
        }

        public void addFolder(folder newFolder) {
            subdirectories.add(newFolder);
        }

        public void addFile(fileInformation newFile, boolean isOriginal) {
            if (isOriginal) {
                listOfFiles.add(newFile);
            }
            sizeOfDirectory += newFile.getFileSize();
            if (parent != null) {
                parent.addFile(newFile, false);
            }
        }
    }

    protected static class fileInformation {
        private int fileSize;
        private String fileName;
        private String fileExtension;

        public fileInformation(int fileSize, String fileName, String fileExtension) {
            this.fileSize = fileSize;
            this.fileName = fileName;
            this.fileExtension = fileExtension;
        }

        public int getFileSize() {
            return fileSize;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFileExtenstion() {
            return fileExtension;
        }
    }

    public static void main(String[] args) {
        String filePath = "DaySeven/Input.txt";
        folder current = new folder(null, "/");
        boolean isPartOne = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while (line != null) {
                switch (line.split("[ ]")[1]) {
                    case "cd":
                        switch (line.split("[ ]")[2]) {
                            case "/":
                                current = returnToHead(current);
                                line = reader.readLine();
                                break;
                            case "..":
                                current = goUpDirectory(current);
                                line = reader.readLine();
                                break;
                            default:
                                current = goIntoDirectory(current, line.split("[ ]")[2]);
                                line = reader.readLine();
                                break;
                        }
                        break;
                    case "ls":
                        line = reader.readLine();
                        while (line.charAt(0) != '$' && !line.isEmpty()) {
                            current = updateFolder(current, line);
                            line = reader.readLine();
                        }
                        break;
                    default:
                        System.out.println("Unexpected line found: " + line);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        current = returnToHead(current);

        if (isPartOne) {
            System.out.println("Total Size of all those directories added up: " + solutionMethodPart1(current));
        } else {
            System.out.println(
                    "smallest space that can be deleted is: " + solutionMethodPart2(current, current.getSize()));
        }
    }

    private static folder returnToHead(folder currentFolder) {
        folder current = currentFolder;
        if (current.getParent() != null) {
            current = returnToHead(current.parent);
        }
        return current;
    }

    private static folder goUpDirectory(folder currentFolder) {
        return currentFolder.getParent();
    }

    private static folder goIntoDirectory(folder currentFolder, String folderName) {
        return currentFolder.getSubdirectory(folderName);
    }

    private static folder updateFolder(folder currentFolder, String reponse) {
        if (reponse.split("[ ]")[0].equals("dir")) {
            currentFolder.addFolder(new folder(currentFolder, reponse.split(" ")[1]));
        } else {
            fileInformation newFile;
            if (reponse.split("[ ]").length == 2) {
                newFile = new fileInformation(Integer.valueOf(reponse.split("[ .]")[0]),
                        reponse.split("[ .]")[1],
                        null);
            } else {
                newFile = new fileInformation(Integer.valueOf(reponse.split("[ .]")[0]),
                        reponse.split("[ .]")[1],
                        reponse.split("[ .]")[2]);
            }
            currentFolder.addFile(newFile, true);
        }
        return currentFolder;
    }

    private static int solutionMethodPart1(folder currentFolder) {
        int sumOfSize = 0;

        if (currentFolder.getSize() <= 100000) {
            sumOfSize += currentFolder.getSize();
        }

        if (currentFolder.getSubdirectories() != null) {
            for (folder newfolder : currentFolder.getSubdirectories()) {
                sumOfSize += solutionMethodPart1(newfolder);
            }
        }

        return sumOfSize;
    }

    private static int solutionMethodPart2(folder currentFolder, int smallestValue) {
        int currentSmallestValue = smallestValue;
        int temp;

        for (folder newFolder : currentFolder.getSubdirectories()) {
            if (newFolder.getSize() > 572957) {
                temp = solutionMethodPart2(newFolder, newFolder.getSize());
                if (temp <= currentSmallestValue) {
                    currentSmallestValue = temp;
                }
            }
        }

        return currentSmallestValue;
    }
}
