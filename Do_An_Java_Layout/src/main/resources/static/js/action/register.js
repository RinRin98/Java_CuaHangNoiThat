

  function register(event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của form

    try {
      var username = $('.register-form').find('input[name="username"]').val();
      var password = $('.register-form').find('input[name="password"]').val();
      var confirm_password = $('.register-form').find('input[name="confirm_password"]').val();
      var email = $('.register-form').find('input[name="email"]').val();
      var name = $('.register-form').find('input[name="name"]').val();

      if(confirm_password!=password){
       alert("Xác nhận mật khẩu sai");
      }

      var data = {
                      email: email,
                      name: name,
                      password: password,
                      id_role: 2,
                      username: username
      };

      // Gửi yêu cầu đăng nhập đến server bằng fetch API
      fetch('http://localhost:9999/api/v1/user/register', {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      })
      .then(response => {

        if (response.ok) {
                  // Đăng ký thành công
                  console.log(response.json());
                  login(username,password);
                  return response.json();
                } else {
                  // Xử lý khi đăng ký thất bại, ví dụ hiển thị thông báo lỗi
                  return response.json();
                }
      }).then(result=>{
              if(result.error){
                          alert(result.error);
                      }
                      else{
                      alert(result.message);
                      }
              })
      .catch(error => {
                // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
                console.log(error);
      });
    } catch (error) {
      console.log(error);
    }
  }

