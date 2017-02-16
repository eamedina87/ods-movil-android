package com.medinamobile.odsmovil.libs;

import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Erick on 1/1/2017.
 */

public class XMLHelper {

    public static final String XML_QUESTION = "question";
    public static final String XML_QUESTIONS = "question";
    public static final String XML_QUESTION_ORDER = "order";
    public static final String XML_QUESTION_TEXT = "text";
    public static final String XML_RESPONSES = "responses";
    public static final String XML_RESPONSE = "response";
    public static final String XML_RESPONSE_CORRECT = "correct";
    public static final String XML_RESPONSE_CORRECT_VALUE = "true";


    public static ArrayList<Question> parseQuestions(InputStream xml, ODS selectedOds){
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    try {

        BufferedReader reader = new BufferedReader(new InputStreamReader(xml));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        reader.close();

        dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(out.toString()));
        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();

        NodeList questionsNode = doc.getElementsByTagName(XML_QUESTION);

        if (questionsNode.getLength()==17){
            ArrayList<Question> questions = new ArrayList<>();

            for (int n=0;n<questionsNode.getLength();n++){

                Element questionElement = (Element) questionsNode.item(n);
                Question question = new Question();
                question.setOds(selectedOds);

                String order = questionElement.getAttribute(XML_QUESTION_ORDER);
                question.setOrder(Integer.valueOf(order));

                NodeList textNode = questionElement.getElementsByTagName(XML_QUESTION_TEXT);
                if (textNode.getLength()==1){
                    Element textElement = (Element) textNode.item(0);
                    String text = textElement.getTextContent();
                    question.setText(text);
                    //Log.i("READING QUESTION:",order+":"+text);
                }


                NodeList responsesNode = questionElement.getElementsByTagName(XML_RESPONSE);
                if (responsesNode.getLength()==4){
                    ArrayList<Response> responses = new ArrayList<>();

                    for (int i=0;i<4;i++){
                        Element responseElement = (Element) responsesNode.item(i);
                        Response response = new Response();
                        //response.setQuestion(question);

                        String text = responseElement.getTextContent();
                        response.setText(text);

                        String correct = responseElement.getAttribute(XML_RESPONSE_CORRECT);
                        if (correct!=null && correct.equals(XML_RESPONSE_CORRECT_VALUE)){
                            response.setCorrect(Response.RESPONSE_CORRECT);
                        }
                        //Log.i("READING RESPONSE:",correct.equals(XML_RESPONSE_CORRECT_VALUE)?text+":correct":text+":incorrect");
                        responses.add(response);
                    }

                    question.setResponses(responses);

                }

                questions.add(question);
            }
            Collections.shuffle(questions);
            return questions;

        }
    } catch (ParserConfigurationException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (SAXException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

        return null;
    }

    private static int getIntElement(Element e,
                                     String value) {
        // TODO Auto-generated method stub
        return Integer.valueOf(e.getElementsByTagName(value).item(0).getTextContent());

    }
}
