var url = window.location.href;
$( document ).ready(function() {
    $('#btnExtractData').on('click',function(event){
      event.preventDefault();
       extractImage();
        });
});
function extractImage(){
 var form = $('form')[0];
        var data = new FormData(form);
            data.append('file', $('#fileImage')[0].files[0]);
    $.ajax({
            url: url+"/prosess",
            type: "POST",
            data: data,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            success: function (res) {
                console.log(res);
            },
            error: function (err) {
                console.log(err);
            }
        });

}
