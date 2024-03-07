package com.capstone.planet.Bean.Small;

import com.capstone.planet.Bean.SaveImageBean;
import com.capstone.planet.Model.DTO.CustomMultiFileDTO;
import com.capstone.planet.Model.DTO.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class CreateMultipartFileBean {

    @Autowired
    SaveImageBean saveImageBean;

    public ImageDTO exec(Double longitude, Double latitude) throws IOException {

        String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";

        try {
            String url = URL_STATICMAP;
            url += "center=" + longitude + "," + latitude;
            url += "&level=16&w=500&h=500";

            URL u = new URL(url);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "d62cogf955");
            con.setRequestProperty("X-NCP-APIGW-API-KEY", "PD9WvJTFLDShaTWdAN0JiYJPfusVsO3tRv4SMDbv");

            int responseCode = con.getResponseCode();

            // 정상호출인 경우.
            if (responseCode == 200) {
                InputStream is = con.getInputStream();
                BufferedImage image = ImageIO.read(is);
                is.close();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", baos);
                baos.flush();
                byte[] imageBytes = baos.toByteArray();
                baos.close();

                return saveImageBean.exec(new CustomMultiFileDTO(imageBytes, "file", "filename.jpg", "jpeg", imageBytes.length));
            } else {    // 에러 발생
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                throw new IOException("Error response from server: " + response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
