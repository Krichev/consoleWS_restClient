import com.touchsoft.endpoint.ChatClientEndpoint;
import com.touchsoft.model.User;
import com.touchsoft.service.JsonUtilService;
import lombok.extern.log4j.Log4j2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import static com.touchsoft.service.ConsoleInputLoginRegistration.doLoginRegistration;

@Log4j2
public class ConsoleChatClient {

    static Scanner scanner = new Scanner(System.in, "utf-8");
    static String roomName;


    public static void main(final String[] args) throws InterruptedException, URISyntaxException {

        doLoginRegistration();
        roomName = User.roomName;
        log.info("connecting to the server " + roomName);

        final ChatClientEndpoint clientEndPoint = new ChatClientEndpoint(
                new URI("ws://localhost:8080/chat/" + roomName));
        log.debug("ChatClientEndpoint created");

        clientEndPoint.addMessageHandler(responseString -> {
            String response = JsonUtilService.jsonMessageToString(responseString);
            log.info(response + " arrived");
        });

        while (true) {

            String message = scanner.nextLine();
            if (message.contains("/exit")) {
                clientEndPoint.onClose();
                break;
            }
            clientEndPoint.sendMessage(JsonUtilService.stringToJsonMessage(roomName, message));
            log.info(roomName + " " + message);
        }


    }


}