//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.26 at 12:39:30 PM MSK 
//


package by.training.xml_xsd_web_parsing.posts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import by.training.xml_xsd_web_parsing.posts.Type;


/**
 * <p>Java class for Ordinary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ordinary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.epam.training.by/posts}Type">
 *       &lt;sequence>
 *         &lt;element name="theme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ordinary", propOrder = {
    "theme"
})
public class Ordinary extends Type
{

    @XmlElement(required = true)
    protected String theme;

    /**
     * Gets the value of the theme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets the value of the theme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheme(String value) {
        this.theme = value;
    }

    @Override
    public String toString() {
        return "Ordinary{" +
                "theme='" + theme + '\'' +
                ", addressFrom=" + addressFrom +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
