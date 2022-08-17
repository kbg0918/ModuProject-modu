package kbg.modu.moduproject.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class EchoHandler extends TextWebSocketHandler {

    //1:N
    private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
    //1:1
    private Map<String, WebSocketSession> users = new HashMap<String, WebSocketSession>();

    //클라이언트와 서버 연결부분
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String senderId = getMemberId(session); // 접속한 유저의 http세션을 조회하여 id를 얻는 함수
        if(senderId!=null) {	// 로그인 값이 있는 경우만
            users.put(senderId, session);   // 로그인중 개별유저 저장
        }
    }

    //클라이언트가 DATA 전송 시
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String senderId = getMemberId(session);
        String msg = message.getPayload();//자바스크립트에서 넘어온 Msg
        if(msg != null){
            String[] strs = msg.split(",");
            if(strs != null && strs.length == 4) {
                String type = strs[0];
                String target = strs[1]; // m_id 저장
                String content = strs[2];
                String url = strs[3];
                WebSocketSession targetSession = users.get(target);  // 메시지를 받을 세션 조회

                // 실시간 접속시
                if(targetSession!=null) {
                    // ex: [&분의일] 신청이 들어왔습니다.
                    TextMessage tmpMsg = new TextMessage("<a target='_blank' href='"+ url +"'>[<b>" + type + "</b>] " + content + "</a>" );
                    targetSession.sendMessage(tmpMsg);
                }
            }


        }

        

    }

    //연결 끊기기
   @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
       String senderId = getMemberId(session);
       if(senderId!=null) {	// 로그인 값이 있는 경우만
           users.remove(senderId);
           sessions.remove(session);
       }
    }

    private String getMemberId(WebSocketSession session) {
        Map<String, Object> httpSession = session.getAttributes();
        String m_id = (String) httpSession.get("m_id"); // 세션에 저장된 m_id 기준 조회
        return m_id==null? null: m_id;
    }
}
