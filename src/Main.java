import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Get Started!");

        StringBuilder sb = new StringBuilder();
        // 데이터를 뽑아올 api 주소
        sb.append("http://api.nongsaro.go.kr/service/dryGarden/dryGardenList");
        sb.append("?apiKey=");
        // 해당 api에 적합한 apiKey
        sb.append("20220913J9KO78RRYWNDNB6UOPWW");
        //추가 옵션 - 없으면 주석처리
        sb.append("&numOfRows=100");

        System.out.println(parseXML(getData(sb)));
    }

    private static Document getData(StringBuilder sb) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(sb.toString());
    }

    // 웹으로 XML 구조를  확인하고 코드에 적절히 세팅한 후 돌릴 것
    public static Map<String, Object> parseXML(Document document) {
        Map<String, Object> msgMap = new HashMap<>();

        document.getDocumentElement().normalize(); // optional, but recommended
        NodeList nodeList = null;
        ArrayList<Map<String, String>> xmlList = new ArrayList<>();
        String getNodeName = "";

        // root 다음의 첫번째 노드 명
        if(document.getFirstChild().getChildNodes().getLength() > 0){
            getNodeName = document.getFirstChild().getFirstChild().getNodeName();

            // root 다음의 첫번째 노드 찾아서 셋팅
            nodeList = document.getElementsByTagName(getNodeName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                // nodeList의 Child Node를 다시 nodeList에 셋팅
                NodeList childList = nodeList.item(i).getChildNodes();

                // Child Node의 key, value를 map에 순차적으로 셋팅
                Map<String, String> childNodeMap = new HashMap<String, String>();
                for (int j = 0; j < childList.getLength(); j++) {
                    String childnodename = childList.item(j).getNodeName();
                    String childnodevalue = childList.item(j).getTextContent();

                    childNodeMap.put(childnodename, childnodevalue);
                }
                xmlList.add(childNodeMap);
            }
            msgMap.put("resultMap", xmlList);
        }else{
            msgMap.put("resultMap", null);
        }
        return msgMap;
    }

}