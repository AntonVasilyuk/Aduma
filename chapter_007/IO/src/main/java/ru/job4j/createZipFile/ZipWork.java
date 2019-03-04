package ru.job4j.createZipFile;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class for archiving dir to zip.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 04.03.2019
 */

public class ZipWork {

    /**.
     * It's logger
     */
    private static final Logger LOG = Logger.getLogger(ZipWork.class.getName());

    /**.
     * It's list types files for adding to archive
     */
    private final List<String> extension;

    /**.
     * It's list files for adding to archive
     */
    private final List<File> files = new ArrayList<>();

    /**.
     * It's path dir for adding to archive
     */
    private final String path;

    /**.
     * It's target for zip archive
     */
    private final String zipTarget;

    /**.
     * It's constructor for this class
     * @param path dir for archiving
     * @param zip it's name and path for archive file
     * @param ext it's type files for adding to archive
     */
    public ZipWork(String path, String zip, List<String> ext) {
        this.path = path;
        this.zipTarget = zip;
        this.extension = ext;
    }

    /**.
     * Start archiving
     */
    public void doZip() {
        directory();
        output();
    }

    /**.
     * Start searching all files
     */
    private void directory() {
        File file = new File(path);
        addFileToList(file);
    }

    /**.
     *  Adding file for archiving
     * @param rootFile
     */
    private void addFileToList(File rootFile) {
        if(rootFile.isDirectory()) {
            for (File file : rootFile.listFiles()) {
                addFileToList(file);
            }
        } else {
            files.add(rootFile);
        }
    }

    /**.
     * Start archiving from list files
     */
    private void output() {
        File file = new File(zipTarget);
        try(FileOutputStream fos = new FileOutputStream(file);
            ZipOutputStream zos = new ZipOutputStream(fos)) {
            files.stream()
                    .filter(fileCheck -> exclude(fileCheck))
                    .forEach(fileForWrite -> archiving(zos, fileForWrite));
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    /**.
     * Archiving to zip file
     * @param zos it's stream for writing
     * @param file file for writing
     */
    private void archiving(ZipOutputStream zos, File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            String pathFile = file.getPath().replace(path, "");
            ZipEntry entry = new ZipEntry(pathFile);
            zos.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zos.write(buffer);
            zos.closeEntry();
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    /**.
     * Check file
     * @param file
     * @return result checking
     */
    private boolean exclude(File file) {
        return extension.stream().anyMatch(s -> file.getName().endsWith(s));
    }
}
