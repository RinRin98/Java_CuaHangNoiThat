function add(event) {
  event.preventDefault(); // Ngăn chặn hành động mặc định của form

  try {
    var name = $('.add-form').find('input[name="ProductName"]').val();
    var title = $('.add-form').find('textarea[name="Title"]').val();
    var price = $('.add-form').find('input[name="Price"]').val();
    var quantity = $('.add-form').find('input[name="Quantity"]').val();
    var category_id = $('.add-form').find('select[id="add-product-select-category"]').val();

    if (category_id == '') {
      throw new Error("Please choose category");
    }

    var data = {
      name: name,
      title: title,
      price: price,
      soLuong: quantity,
      category_id: category_id
    };

    // Gửi yêu cầu đăng ký đến server bằng fetch API
    fetch('http://localhost:9999/products', {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    })
      .then(response => {
        if (response.ok) {

          return response.json();
        } else {
          // Xử lý khi đăng ký thất bại, ví dụ hiển thị thông báo lỗi
          throw new Error("Add failed");
        }
      })
      .then(data => {
        const productId = data.id;

        var formData = new FormData();

        // Append each image file to the FormData object
        var inputImageFiles = document.getElementById('image');
        console.log(inputImageFiles);
        console.log(inputImageFiles.value);
        console.log(inputImageFiles.files);

        for (var i = 0; i < inputImageFiles.files.length; i++) {
          formData.append('imageProduct', inputImageFiles.files[i]);
        }

        // Send the multipart request to the server
        fetch('http://localhost:9998/products/inputImages', {
          method: 'POST',
          body: formData
        })
          .then(response=>{return response.json();})
          .then(imageFiles => {
            // Lưu mảng kết quả vào biến imageFiles
            console.log(imageFiles); // In ra mảng kết quả

                    for (let i = 0; i < imageFiles.length; i++) {
                      var eachImageFile = imageFiles[i];
                      var formData1 = new FormData();

                        fetch('http://localhost:9999/images', {
                          method: 'POST',
                            headers: {
                              'Content-Type': 'application/json', // Set the correct content type here
                            },
                            body: JSON.stringify({ image: eachImageFile, product_id: productId }),
                          })
                            .then(response => {
                              if (response.ok) {
                                // Handle the successful response
                                console.log(response.Json());
                              } else {
                                // Handle the error response
                              }
                            })
                            .catch(error => {
                              // Handle any network or other errors
                            });

          }})
          .catch(error => {
            // Xử lý lỗi nếu có
            console.error('Lỗi:', error);
          });

        alert("Đã thêm");
        window.location.href ="/admin/products/list";
      })
      .catch(error => {
        // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
        console.log(error);
      });
  } catch (error) {
    console.log(error);
  }
}
