package kbg.modu.moduproject.handler;


import kbg.modu.moduproject.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;


public class NoticeHandler extends TextWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
    //로그인 한 인원 전체
    private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

    // 로그인중인 개별유저
    private Map<String, WebSocketSession> users = new HashMap<String, WebSocketSession>();


    // 클라이언트가 서버로 연결시
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Socket 연결");
        sessions.add(session);
        logger.info("현재 접속한 사람"+currentUserName(session));//현재 접속한 사람
        String senderId = currentUserName(session);
        users.put(senderId,session);
        System.out.println(currentUserName(session)+"---currentUserName은?");
        System.out.println(sessions+"세션의 접속한 사람?");
        System.out.println(users+"로그인중인 개별유저는?");
    }


    //클라이언트가 data 전송시
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("session 누굴까요? "+currentUserName(session));
        String msg = message.getPayload();
        logger.info("msg="+msg);

        if(msg != null){
            logger.info("if문 check");
            String[] strs = msg.split(",");
            if(strs != null){
                String type = strs[0];
                String userWriter = strs[1];
                String writer = strs[2];
                String seq = strs[3];
                String title = strs[4];
                String category = strs[5];
                logger.info("split 저장 check"+type);
                WebSocketSession userWriterSession = users.get(userWriter);
                WebSocketSession writerSession = users.get(writer);
                System.out.println(users);
                logger.info("게시판 작성자="+users.get(writer));
                logger.info("게시판 작성자="+writerSession);

                if("comment".equals(type) && writerSession != null){
                    if(sessions.contains(writerSession)){
                        TextMessage tmgMsg = new TextMessage(userWriter+"님이"+"<a id='notice-a' href='/board/PostDetail?boardSeq="+seq+"' style=\"color:white\">"+title+"("+category+")"+"에 댓글을 등록했습니다!</a>");
                        writerSession.sendMessage(tmgMsg);
                    }
                }
                else if("commission".equals(type) && writerSession != null){
                    if(sessions.contains(writerSession)){
                        TextMessage tmgMsg = new TextMessage(userWriter+"님이"+"<a id='notice-a' href='/commission/detail?pcSeq="+seq+"' style=\"color:white\">"+title+"("+category+")"+"에서 채팅요청을 보냈습니다!</a>");
                        writerSession.sendMessage(tmgMsg);
                    }else{
                        TextMessage tmgMsg = new TextMessage(writer+"님은"+"<p> 현재 접속중이 아닙니다.</p>");
                        userWriterSession.sendMessage(tmgMsg);
                    }

                }
                else if("review".equals(type) && writerSession != null){
                    if(sessions.contains(writerSession)){
                        TextMessage tmgMsg = new TextMessage(userWriter+"님이"+"<a id='notice-a' href='/commission/detail?pcSeq="+seq+"' style=\"color:white\">"+title+"("+category+")"+"에 리뷰를 등록했습니다!</a>");
                        writerSession.sendMessage(tmgMsg);
                    }
                }
            }

        }
    }

    // 연결 해제될 때
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Socket 끊기");
        sessions.remove(session);
        users.remove(session);
    }

    // 접속한 유저의 http세션을 조회하여 이름을 얻는 함수
    private String currentUserName(WebSocketSession session) {
        Map<String, Object> httpSession = session.getAttributes();
        Member loginUser = (Member)httpSession.get("member");
        if(loginUser == null) {
            String mid = session.getId();
            return mid;
        }else{
            String mid = loginUser.getMemberName();
            return mid;
        }


    }


}
