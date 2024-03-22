package main.java.sgu.ru;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.ArrayList;
import java.util.List;

public class B3 {
    public static void main(String[] args) {
        B3 b3 = new B3();
        String targetString = "b3";
        String directoryPath = "main/java/sgu/ru/files";

        Map<String, Object> tree = b3.getStructTree(directoryPath, targetString);
        b3.printTree(tree, 0);

        List<String> markedObjects = b3.getMarkedObjects(tree, directoryPath);

        String archivePath = "test_arch.zip";

        // for (String markedObjects2 : markedObjects) {
        //     System.out.println(markedObjects2);
        // }
        b3.createZipArchive(markedObjects, archivePath);

    }

    public Map<String, Object> getStructTree(String directoryPath, String targetString) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Директории не существует");
            return null;
        }

        Map<String, Object> tree = buildTree(directory, targetString);

        return tree;
    }

    private Map<String, Object> buildTree(File directory, String targetString) {
        Map<String, Object> tree = new HashMap<>();

        for (File file : directory.listFiles()) {
            Map<String, Object> node = new HashMap<>();
            String filename = file.getName();
            boolean containsTarget = filename.contains(targetString);

            if (containsTarget) {
                node.put("markDown", "X");
            } else {
                node.put("markDown", "");
            }

            if (file.isDirectory()) {
                node.put("objectType", "Directory");
                node.put("content", buildTree(file, targetString));
            } else {
                node.put("objectType", "File");
            }
            tree.put(file.getName(), node);
        }

        return tree;
    }

    @SuppressWarnings("unchecked")
    private void printTree(Map<String, Object> tree, int level) {
        for (Map.Entry<String, Object> entry : tree.entrySet()) {
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < level; i++) {
                indent.append("    ");
            }

            Map<String, Object> node = (Map<String, Object>) entry.getValue();
            String objectType = (String) node.get("objectType");
            String markDown = (String) node.get("markDown");
            System.out.println(indent + "|-- " + entry.getKey() + " (" + objectType + ") " + markDown);

            if (node.containsKey("content")) {
                printTree((Map<String, Object>) node.get("content"), level + 1);
            }
        }
    }

    public List<String> getMarkedObjects(Map<String, Object> tree, String directoryPath) {
        List<String> markedObjects = new ArrayList<>();
        collectMarkedObjects(tree, markedObjects, directoryPath);
        return markedObjects;
    }

    @SuppressWarnings("unchecked")
    private void collectMarkedObjects(Map<String, Object> tree, List<String> markedObjects, String currentPath) {
        for (Map.Entry<String, Object> entry : tree.entrySet()) {
            String objectName = entry.getKey();
            Map<String, Object> node = (Map<String, Object>) entry.getValue();
            String markDown = (String) node.get("markDown");

            if (!markDown.isEmpty()) {
                markedObjects.add(currentPath + File.separator + objectName);
            }

            if (node.containsKey("content")) {
                collectMarkedObjects((Map<String, Object>) node.get("content"), markedObjects,
                        currentPath + File.separator + objectName);
            }
        }
    }

    public void createZipArchive(List<String> markedObjects, String archivePath) {
        try {
            FileOutputStream fos = new FileOutputStream(archivePath);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (String objectPath : markedObjects) {
                File file = new File(objectPath);
                if (file.isDirectory()) {
                    ZipEntry zipEntry = new ZipEntry(objectPath + File.separator);
                    zos.putNextEntry(zipEntry);
                    zos.closeEntry();
                } else {
                    addToZip(file, objectPath, zos);
                }
            }

            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToZip(File file, String objectPath, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(objectPath);
        zos.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, length);
        }

        fis.close();
        zos.closeEntry();
    }
}
