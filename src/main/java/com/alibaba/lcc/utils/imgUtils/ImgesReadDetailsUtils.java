package com.alibaba.lcc.utils.imgUtils;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImgesReadDetailsUtils {
    /**
     * key :Component 3  value :Cr component: Quantization table 1, Sampling factors 1 horiz/1 vert
     * key :Compression Type  value :Baseline
     * key :Data Precision  value :8 bits
     * key :Number of Components  value :3
     * key :Component 2  value :Cb component: Quantization table 1, Sampling factors 1 horiz/1 vert
     * key :Component 1  value :Y component: Quantization table 0, Sampling factors 2 horiz/2 vert
     * key :Image Height  value :4032 pixels
     * key :Image Width  value :2016 pixels
     * ===========================================================
     * key :Resolution Units  value :none
     * key :Version  value :1.1
     * key :X Resolution  value :1 dot
     * key :Y Resolution  value :1 dot
     * ===========================================================
     * key :Exposure Bias Value  value :0 EV
     * key :User Comment  value :end
     * key :Exposure Mode  value :Auto exposure
     * key :Exposure Time  value :0.03 sec
     * key :F-Number  value :F1.8
     * key :Focal Length 35  value :25mm
     * key :ISO Speed Ratings  value :57
     * key :Date/Time Digitized  value :2020:02:23 14:04:30
     * key :Focal Length  value :4.58 mm
     * key :Metering Mode  value :Center weighted average
     * key :Flash  value :Flash did not fire
     * key :Date/Time Original  value :2020:02:23 14:04:30
     * key :White Balance Mode  value :Auto white balance
     * ===========================================================
     * key :Date/Time  value :2020:02:23 14:04:30
     * key :Model  value :16th Plus
     * key :Make  value :Meizu
     * key :Software  value :Meizu Camera
     * key :Orientation  value :Top, left side (Horizontal / normal)
     * ===========================================================
     * key :GPS Latitude  value :30.0° 18.0' 18.960000000005266"
     * key :GPS Date Stamp  value :2020:02:23
     * key :GPS Latitude Ref  value :N
     * key :GPS Longitude  value :120.0° 16.0' 46.79000000000656"
     * key :GPS Time-Stamp  value :6:4:30 UTC
     * key :GPS Longitude Ref  value :E
     * ===========================================================
     * ===========================================================
     *
     * Process finished with exit code 0
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File jpegFile = new File("/Users/lccsetsun/Pictures/w/P00223-140430.jpg");
        Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
        for(Directory directory : metadata.getDirectories()){
//            for(Tag tag : directory.getTags()){
//                System.out.print("name : " + tag.getTagName() + "  -->");
//                System.out.println("desc : " + tag.getDescription());
//            }
            System.out.println("count =======> : "+directory.getDescription(2)+"=="+directory.getName());
            Map<String, String> map = getIdNameMap((List<Tag>) directory.getTags());
            map.forEach((s, s2) -> {
                System.out.println("key :"+s +"  value :"+s2);
            });
            System.out.println("===========================================================");
        }
    }

    public static Map<String, String> getIdNameMap(List<Tag> accounts) {
        return accounts.stream().collect(Collectors.toMap(Tag::getTagName, Tag::getDescription));
    }

}
