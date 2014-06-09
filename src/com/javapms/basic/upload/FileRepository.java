package com.javapms.basic.upload;

import com.javapms.basic.utils.UploadUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class FileRepository
        implements ServletContextAware {
    private Logger log = LoggerFactory.getLogger(FileRepository.class);
    private ServletContext ctx;

    public String uploadFile(MultipartFile file, String uploadPath) {
        String origName = file.getOriginalFilename();
        String ext = FilenameUtils.getExtension(origName).toLowerCase(
                Locale.ENGLISH);
        String fileUrl = storeByExt(uploadPath, ext, file);
        return fileUrl;
    }

    private String storeByExt(String path, String ext, MultipartFile file) {
        String filename = UploadUtils.generateFilename(path, ext);
        File dest = new File(this.ctx.getRealPath(filename));
        dest = UploadUtils.getUniqueFile(dest);
        try {
            store(file, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public String storeByFilename(String filename, MultipartFile file)
            throws IOException {
        File dest = new File(this.ctx.getRealPath(filename));
        store(file, dest);
        return filename;
    }

    public String storeByExt(String path, String ext, File file)
            throws IOException {
        String filename = UploadUtils.generateFilename(path, ext);
        File dest = new File(this.ctx.getRealPath(filename));
        dest = UploadUtils.getUniqueFile(dest);
        store(file, dest);
        return filename;
    }

    public String storeByFilename(String filename, File file)
            throws IOException {
        File dest = new File(this.ctx.getRealPath(filename));
        store(file, dest);
        return filename;
    }

    private void store(MultipartFile file, File dest)
            throws IOException {
        try {
            UploadUtils.checkDirAndCreate(dest.getParentFile());
            file.transferTo(dest);
        } catch (IOException e) {
            this.log.error("Transfer file error when upload file", e);
            throw e;
        }
    }

    private void store(File file, File dest)
            throws IOException {
        try {
            UploadUtils.checkDirAndCreate(dest.getParentFile());
            FileUtils.copyFile(file, dest);
        } catch (IOException e) {
            this.log.error("Transfer file error when upload file", e);
            throw e;
        }
/* :0:   */
    }

    /* :1:   */
/* :2:   */
    public File retrieve(String name)
/* :3:   */ {
/* :4:91 */
        return new File(this.ctx.getRealPath(name));
/* :5:   */
    }

    /* :6:   */
/* :7:   */
    public void setServletContext(ServletContext servletContext)
/* :8:   */ {
/* :9:97 */
        this.ctx = servletContext;
/* ;0:   */
    }
/* ;1:   */
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.upload.FileRepository

 * JD-Core Version:    0.7.0.1

 */