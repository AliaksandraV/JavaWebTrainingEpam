package by.training.xml_xsd_web_parsing.posts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarshalWithXSD {

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Posts.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("data/posts.xml");
            Posts posts = (Posts) u.unmarshal(reader);
            System.out.println(posts);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
