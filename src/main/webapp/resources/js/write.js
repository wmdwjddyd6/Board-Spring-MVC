var writeBtn;
var boardId = location.search.substring(9);

if(boardId < 1) {
	writeBtn = document.getElementById("write_btn").addEventListener("click", write);
} else {
	writeBtn = document.getElementById("write_btn").addEventListener("click", update);
}

function write() {
    console.log("작성 메서드 실행");
    var title = document.getElementById("title").value;
    var content = document.getElementById("content").value;
    var data = { "title": title, "content": content };

    $.ajax({
		contentType: 'application/json',
        type: "POST",
        url: "/board",
        data: JSON.stringify(data),
        success: function (response) {
            console.log("성공 : " + response);
            location.href="list";
        },
        error: function (response) {
            console.log("실패 : " + response);
            console.log(response);
        }
    })
}

function update() {
    console.log("수정 메서드 실행");
    var title = document.getElementById("title").value;
    var content = document.getElementById("content").value;
    var data = { "title": title, "content": content };

    $.ajax({
		contentType: 'application/json',
        type: "PATCH",
        url: "/board/" + boardId,
        data: JSON.stringify(data),
        
        success: function (response) {
            console.log("성공 : " + response);
            location.href="list";
        },
        error: function (response) {
            console.log("실패 : " + response);
            console.log(response);
        }
    })
}