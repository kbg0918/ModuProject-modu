

socket = new SockJS('/ws/chat');
var stompClient = Stomp.over(socket);

var flag = false;
stompClient.connect({},notice);

function notice(){
    //일반채팅
    stompClient.send("/modu/topic/ccr/"+PC_SEQ+"/"+USER_SEQ+"/"+EX_SEQ,{},
        JSON.stringify({sender: EX_NAME})
    )
    //알림
    stompClient.send("/modu/notice/"+PC_SEQ+"/"+USER_SEQ+"/"+EX_SEQ,{},
        JSON.stringify({sender: USER_NAME})
    )

    //안되면 alert로 메시지 띄우고 페이지 이동해서 버튼 클릭시 이동하는 방법도 있음.
    //교수가 학생한테
    stompClient.subscribe('/user/queue/hello/'+PC_SEQ+"/"+USER_SEQ, function (event) {
        console.log(event);
        alert(PC_SEQ+"게시물 교수의 수락");
        location.href = '../chat/room';

    });
    //학생이 교수한테
    stompClient.subscribe('/user/queue/hello/'+PC_SEQ, function (event) {
        console.log(event);
        if(confirm(PC_SEQ+"게시물에서 채팅방 요청")){
            location.href = "../commission/detail?pcSeq="+PC_SEQ+"&"+"writer="+USER_NAME;
        }else {
            alert("취소");
        }
    });
}



