

socket = new SockJS('/ws/chat');
var stompClient = Stomp.over(socket);

stompClient.connect({},receive);

var flag = 0;

$('#notice-btn').click(function (){
    stompClient.send("/modu/notice/"+PC_SEQ+"/"+USER_SEQ+"/"+EX_SEQ,{},
        JSON.stringify({sender: USER_NAME})
    )
    stompClient.subscribe('/user/queue/hello/'+PC_SEQ+"/"+USER_SEQ, function (event) {
        console.log(event);
            if(flag > 1){
                alert(PC_SEQ+"게시물 교수의 수락");
                location.href = '../chat/room';
                flag = 0;
            }
    });
})

function receive(){
    //알림
    stompClient.send("/modu/notice/"+PC_SEQ+"/"+USER_SEQ+"/"+EX_SEQ,{},
        JSON.stringify({sender: USER_NAME})
    )
    //교수가 학생한테
    stompClient.subscribe('/user/queue/hello/' + PC_SEQ, function (event) {
        console.log(event);
        flag++;
        if(flag > 1){
            if (confirm(PC_SEQ + "게시물에서 채팅방 요청")) {
                location.href = "../commission/detail?pcSeq=" + PC_SEQ + "&" + "writer=" + USER_NAME;
                flag = 0;
            } else {
                flag=0;
                alert("취소");
            }
        }
    });


}




