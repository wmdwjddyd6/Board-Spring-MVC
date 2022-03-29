var writeBtn = document.getElementById("write_btn").addEventListener("click", write);

function write() {
    console.log("메서드 실행");
    var title = document.getElementById("title").value;
    var content = document.getElementById("content").value;
    var data = { "title": title, "content": content };

    $.ajax({
        type: "POST",
        url: "/board",
        data: data,
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