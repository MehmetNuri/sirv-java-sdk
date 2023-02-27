package com.mehmetnuri.files;

import com.fasterxml.jackson.databind.JsonNode;
import com.mehmetnuri.files.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface FilesClient {
    ApprovalFlag getApprovalFlag(String filename);

    void setApprovalFlag(String filename, ApprovalFlag approvalFlag);

    MetaDescription getMetaDescription(String filename);

    void setMetaDescription(String filename, MetaDescription metaDescription);

    ProductMeta setProductMeta(String filename);

    void setProductMeta(String filename, ProductMeta meta);

    MetaTags getMetaTags(String filename);

    void setMetaTags(String filename, MetaTags metaTags);

    MetaTitle getMetaTitle(String filename);

    void setMetaTitle(String filename, MetaTitle metaTitle);

    FolderOptions getFolderOptions(String folder);

    void setFolderOptions(String folder, FolderOptions folderOptions);

    FolderContent readFolderContents(String folder, String continuation);

    Content getContentInfo(String path);

    void copy(String fromPath, String toPath);

    void delete(String path);

    void fetch(List<Fetch> fetches);

    JwtProtectedUrl getJwtProtectedUrl(GetJWTProtectedUrlRequest request);

    JsonNode searchFiles(FilesSearchRequest request);

    JsonNode scroll(String scrollId);

    String convertSpinToVideo(ConvertSpinToVideo convertSpinToVideo);

    void upload(String filename, InputStream inputStream) throws IOException;

    void mkdir(String dirname);

    void rename(String from, String to);

    String convertVideoToSpin(ConvertVideoToSpin convertVideoToSpin);

    void deleteMetaTags(String filename, MetaTags metaTags);
}
