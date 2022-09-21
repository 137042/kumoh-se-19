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

public class Main {

    // 데이터 뽑아올 API 주소
    final static String APIURL= "http://api.nongsaro.go.kr/service/dryGarden/dryGardenDtl";
    // 해당 API에 적합한 API Key
    final static String APIKEY= "20220913J9KO78RRYWNDNB6UOPWW";
    // 제일 첫 식물의 cntntsNo
    final static int FIRSTNO = 204774;
    // 제일 끝 식물의 cntntsNo
    final static int ENDNO = 204870;

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Get Started!");

        // &cntntsNo= 는 추가 옵션, 불필요하면 삭제 후 실행
        String url = APIURL + "?apiKey=" + APIKEY + "&cntntsNo=";

        // detail 정보 추출 시 cntntsNo를 변경하면서 필요한만큼 요청해줘야 하므로 적절하게 바꿔쓰기
        ArrayList<String> dataList = new ArrayList<>();

        for(int i = FIRSTNO; i <= ENDNO; i++){
            // i번째 cntntsNo의 페이지를 get -> parse
            String data = parseXML(getXML(url + i));
            dataList.add(data);
        }
        // String 데이터들이 저장된 리스트를 CSV로 변환해서 쓰기
        writeCSV(dataList);

        System.out.println("Parse Ended");
    }

    private static Document getXML(String url) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(url);
    }

    // 웹으로 XML 구조를 확인하고 코드에 적절히 세팅한 후 돌릴 것
    public static String parseXML(Document document) {
        document.getDocumentElement().normalize();
        NodeList nodeList;

        StringBuilder sb = new StringBuilder();

        if(document.getFirstChild().getChildNodes().getLength() > 0){
            // body 또는 item 등 컬럼명으로 추출할 Child Node의 바로 윗 노드로 지정
            String headNodeName = "item";
            nodeList = document.getElementsByTagName(headNodeName);

            // nodeList의 Child Node를 다시 nodeList에 셋팅
            for (int i = 0; i < nodeList.getLength(); i++) {

                NodeList childList = nodeList.item(i).getChildNodes();
                for (int j = 0; j < childList.getLength(); j++) {
                    String childnodevalue = childList.item(j).getTextContent();

                    sb.append(childnodevalue);
                    // 데이터가 잘 넘어오는 지 테스트할때 csv에 필요한 컬럼명을 미리 뽑아두고 복사해두기
//                    sb.append(childnodename);

                    if(j != childList.getLength() - 1) {
                        // 데이터에 ,가 포함된 경우가 많아서 불가피해서 등호로 구분
                        // 등호로 뽑은 후 결과가 이상하면 적당한 구분자를 알아서 지정
                        sb.append("=");
                    }
                }
            }
        }
        return sb.toString();
    }

    private static void writeCSV(ArrayList<String> dataList){
        // csv를 "읽는" 과정이 없어서 그 파일에 있는 데이터 위를 덮어쓰므로 옮겨둔 컬럼명을 0번으로 붙여줌
        String nodeNames = "batchPlaceInfo=chartrInfo=clCodeDc=clNm=cntntsNo=cntntsSj=distbNm=dlthtsInfo=flwrInfo," +
                "frtlzrInfo=grwhTpInfo=grwtInfo=grwtseVeNm=hgtmMhmrInfo=lfclChngeInfo=lightImgUrl1=lightImgUrl2=" +
                "lightImgUrl3=lighttInfo=mainImgUrl1=mainImgUrl2=manageDemandNm=manageLevelNm=orgplce=prpgtInfo=" +
                "pswntrTpInfo=rdxStleNm=scnm=stleSeNm=tipInfo=waterCycleInfo";
        dataList.add(0, nodeNames);

        try {
            // 추출된 csv 파일 저장할 절대 경로
            String filePath = "C:/Users/mare1/workspace/GardenDemo/dry-garden.csv";
            File file = new File(filePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line;

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