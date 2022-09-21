import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Get Started!");

        StringBuilder sb = new StringBuilder();
        // 데이터를 뽑아올 api 주소
        sb.append("http://api.nongsaro.go.kr/service/dryGarden/dryGardenDtl");
        sb.append("?apiKey=");
        // 해당 api에 적합한 apiKey
        sb.append("20220913J9KO78RRYWNDNB6UOPWW");
        //추가 옵션 - 없으면 주석처리
        sb.append("&cntntsNo=");
        String url = sb.toString();
        // detail 뽑을 때는 no를 계속 올리면서 첫 페이지부터 끝까지 요청해줘야 하므로 적절하게 바꿔쓰기
        ArrayList<String> dataList = new ArrayList<>();

        for(int i = 204774; i < 204871; i++){
            String data = parseXML(getXML(url + i));
            dataList.add(data);
//            System.out.println(data);
        }
        writeCSV(dataList);

        System.out.println("Parse Ended");
    }

    private static Document getXML(String url) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(url);
    }

    // 웹으로 XML 구조를  확인하고 코드에 적절히 세팅한 후 돌릴 것
    public static String parseXML(Document document) {
//    public static Map<String, Object> parseXML(Document document) {
        Map<String, Object> msgMap = new HashMap<>();

        document.getDocumentElement().normalize(); // optional, but recommended
        NodeList nodeList = null;
        ArrayList<Map<String, String>> xmlList = new ArrayList<>();
        String getNodeName = "";
        StringBuilder sb = new StringBuilder();

        // root 다음의 첫번째 노드 명
        if(document.getFirstChild().getChildNodes().getLength() > 0){
//            getNodeName = document.getFirstChild().getFirstChild().getNodeName();
//            getNodeName = "body";
            getNodeName = "item";
            // root 다음의 첫번째 노드 찾아서 셋팅
            nodeList = document.getElementsByTagName(getNodeName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                // nodeList의 Child Node를 다시 nodeList에 셋팅
                NodeList childList = nodeList.item(i).getChildNodes();

                // Child Node의 key, value를 map에 순차적으로 셋팅
                Map<String, String> childNodeMap = new HashMap<>();
                for (int j = 0; j < childList.getLength(); j++) {
                    String childnodename = childList.item(j).getNodeName();
                    String childnodevalue = childList.item(j).getTextContent();

                    childNodeMap.put(childnodename, childnodevalue);


                    sb.append(childnodevalue);
//                    sb.append(childnodename);

                    if(j != childList.getLength() - 1) {
//                        sb.append(",");
                        sb.append("=");
                    }
                }
                xmlList.add(childNodeMap);
            }
            msgMap.put("resultMap", xmlList);
        }else{
            msgMap.put("resultMap", null);
        }
        return sb.toString();
//        return msgMap;
    }

    private static void writeCSV(ArrayList<String> dataList){

        String nodeNames = "batchPlaceInfo=chartrInfo=clCodeDc=clNm=cntntsNo=cntntsSj=distbNm=dlthtsInfo=flwrInfo," +
                "frtlzrInfo=grwhTpInfo=grwtInfo=grwtseVeNm=hgtmMhmrInfo=lfclChngeInfo=lightImgUrl1=lightImgUrl2=" +
                "lightImgUrl3=lighttInfo=mainImgUrl1=mainImgUrl2=manageDemandNm=manageLevelNm=orgplce=prpgtInfo=" +
                "pswntrTpInfo=rdxStleNm=scnm=stleSeNm=tipInfo=waterCycleInfo";
        dataList.add(0, nodeNames);

        try {
            // 추출된 csv 파일 저장할 경로(경로에 메모장써서 파일 미리 만들어두기)
//            String filePath = "C:/Users/mare1/workspace/dry-garden.csv";
            String filePath = "C:/Users/mare1/workspace/GardenDemo/dry-garden.csv";
            File file = new File(filePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line = "";

            for (String s : dataList) {
                line = s;
                line = line.replace("\n", "");
                line = line.replace("<br />", "");
                line = line.replace("<i>", "");
                line = line.replace("</i>", "");

                bw.write(line);
                bw.write("\n");
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}