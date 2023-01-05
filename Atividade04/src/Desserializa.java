import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Desserializa {
    public static void main(String[] args) throws Exception {
        File file = new File("Series.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Series show = xmlMapper.readValue(file, Series.class);
        System.out.println(show);
    }
}
