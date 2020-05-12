import java.util.Arrays;
import java.util.List;

public class CaptureClass {

    public static void main(String[] args) {
        List<String> captureList = Arrays.asList("7EC36685KM6056005", "8TL545932W8519138", "27L19238DY192862Y", "7GJ17287H4415312N", "07971190803129048", "6G2169292N5633032");
        captureList.forEach(captureId -> System.out.println(captureId + ": " + captureId.length()));
        List<String> msgSubIdList = Arrays.asList("CZC02014111113024568D00000000000000000",
                "CZC02014111112804263D00000000000000000",
                "CZC02014111113031244D00000000000000000",
                "CZR02015112394306913C95001444PC017712J",
                "CZR02015112394385616C7CT53032K63891241",
                "CZR02015112394463488C5XM269296D626425L");
        msgSubIdList.forEach(msgSubId -> System.out.println(msgSubId + ": " + msgSubId.length()));

        List<String> payerIdList = Arrays.asList("E42VVQLWG6G3N", "69Z22RS3WCL8G", "TX9AAESBG27J8", "3T4JZXA5NYSGN");
        payerIdList.forEach(payerId -> System.out.println(payerId + ": " + payerId.length()));

        List<String> orderIdList = Arrays.asList("O-92E10356NS752464G", "O-0DY69443YS7762116", "O-01290969DE683390U");
        orderIdList.forEach(orderId -> System.out.println(orderId + ": " + orderId.length()));
    }
}
