(function() {
    var objs = document.getElementsByTagName("img");
    var array = new Array();

    for(var j = 0; j < objs.length; ++j) {
        array[j] = objs[j].src;
    }
    for(var i = 0; i < objs.length; ++i) {
        objs[i].onclick = function() {
            window.imgClick.imageClick(this.getAttribute("src"), array);
        }
    }
})()