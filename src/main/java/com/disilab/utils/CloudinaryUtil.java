package com.disilab.utils;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloudinaryUtil {
    static Map authConfig = ObjectUtils.asMap(
            "cloud_name", "askme",
            "api_key", "911419747537246",
            "api_secret", "hrjgQihhwyk5OinqXAaxichnOyM",
            "secure", true);

    public static String uploadImageOriginal(String base64) {
        try {
            String finalImageData = "data:image/png;base64," + base64;
            Map uploadConfig = ObjectUtils.asMap(
                    "folder", "images");
            Cloudinary cloudinary = new Cloudinary(authConfig);
            Map uploadResult = cloudinary.uploader().upload(finalImageData, uploadConfig);
            return (String) uploadResult.get("secure_url");
        } catch (Exception ex) {
            Logger.getLogger(CloudinaryUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
