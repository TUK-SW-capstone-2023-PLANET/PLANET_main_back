package com.capstone.planet.Model.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Data
public class CustomMultiFileDTO implements MultipartFile {
    private final byte[] bytes;
    String name;
    String originalFilename;
    String contentType;
    boolean isEmpty;
    long size;

    public CustomMultiFileDTO(byte[] bytes, String name, String originalFilename, String contentType,
                               long size) {
        this.bytes = bytes;
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.size = size;
        this.isEmpty = false;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        throw new UnsupportedOperationException("This method is not supported.");
    }
}
