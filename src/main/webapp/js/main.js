window.onload = function () {
    var eventA = document.getElementById("userList");
    eventA.addEventListener('click', function () {
        document.getElementById("content").innerHTML = '<object type="text/html" data="./content.html" width="100%" height="100%"></object>';
    });
}