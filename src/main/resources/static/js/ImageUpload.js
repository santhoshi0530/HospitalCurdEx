 function uploadImage() {
        var file = document.getElementById("fileOb");
        var form = new FormData();
        form.append("image", file.files[0]);
        var inputs = {
          url: "https://api.imgbb.com/1/upload?key=115c9f6902a224ca17ee4458a5eba8fc",
          method: "POST",
          timeout: 0,
          processData: false,
          mimeType: "multipart/form-data",
          contentType: false,
          data: form,
        };

        $.ajax(inputs).done(function (response) {
          var job = JSON.parse(response);
          $("#photoLoc").val(job.data.url);
        });
      }