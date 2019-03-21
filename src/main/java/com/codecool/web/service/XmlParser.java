package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XmlParser {


    private static File xmlFile;

    // Creating Document type obj.
    private static Document createDocument(String path) throws Exception {
        xmlFile = new File(path);
        Document document = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(xmlFile);
        return document;
    }


    // Write the document to the XMl
    private static void save(Document document, String path) throws Exception{
        TransformerFactory factory = TransformerFactory.newInstance();

        Document documentClean = removeEmptyNodes(document);
        DOMSource domSource = new DOMSource(documentClean);
        StreamResult streamResult = new StreamResult(new File(path));

        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(domSource, streamResult);
    }


    //Read Xml & return with it's items
    public static List<Tweet> read(String path) throws Exception{
        Document document = createDocument(path);
        NodeList nList = document.getElementsByTagName("tweet");
        List<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < nList.getLength(); i++) {
            String poster = document.getElementsByTagName("poster").item(i).getTextContent();
            String content = document.getElementsByTagName("content").item(i).getTextContent();
            Date timestamp = new Date(Long.valueOf(document.getElementsByTagName("timestamp").item(i).getTextContent()));
            int id = Integer.valueOf(document.getElementsByTagName("id").item(i).getTextContent());

            Tweet tweet = new Tweet(poster, content, timestamp, id);
            tweets.add(tweet);

        }
        return tweets;
    }

    //Write to Xml
    public static void write(Tweet tweet, String path) throws Exception{
        Document document = createDocument(path);

        Element root = document.getDocumentElement();
        Element tweetNode = document.createElement("tweet");

        root.appendChild(tweetNode);

        Element poster = document.createElement("poster");
        Element content = document.createElement("content");
        Element timestamp = document.createElement("timestamp");
        Element id = document.createElement("id");

        poster.appendChild(document.createTextNode(tweet.getPoster()));
        content.appendChild(document.createTextNode(tweet.getContent()));
        timestamp.appendChild(document.createTextNode(String.valueOf(tweet.getTimestamp().getTime())));
        id.appendChild(document.createTextNode(String.valueOf(tweet.getId())));

        tweetNode.appendChild(poster);
        tweetNode.appendChild(content);
        tweetNode.appendChild(timestamp);
        tweetNode.appendChild(id);

        save(document, path);
    }

    private static Document removeEmptyNodes(Document document) throws Exception{
        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList nl = null;
        nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", document, XPathConstants.NODESET);

        for (int i = 0; i < nl.getLength(); ++i) {
            Node node = nl.item(i);
            node.getParentNode().removeChild(node);
        }
        return document;
    }
}
