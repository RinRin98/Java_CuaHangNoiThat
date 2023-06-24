
async function Start2() {
// Lấy URL hiện tại
    const currentUrl = window.location.href;
// Kiểm tra nếu URL chứa 'http://localhost:9998/a?token='
    if (currentUrl.includes('http://localhost:9998/a?token=')) {
      // Trích xuất token từ URL
      const urlParams = new URLSearchParams(window.location.search);
      const token = urlParams.get('token');
      // Lưu token vào sessionStorage
      sessionStorage.setItem('token', token);
      // Thay đổi URL hiển thị thành "localhost:9998"
      history.replaceState({}, '', 'http://localhost:9998');
        alert('Đăng nhập thành công');
        if (kiemtradangnhap()) {
            await loadUserInfoSideBox('/sublayout/userinfo');
            loadUserInfo(kiemtradangnhap());
           // const role_name = await getRoleName(kiemtradangnhap()); // Lấy giá trị rolename bằng await
          } else {
            loadUserInfoSideBox('/sublayout/user');
          }
    }

    else {
        if (currentUrl.includes('http://localhost:9998/admin')){
                if (kiemtradangnhap()) {
                    const role_name = await getRoleName(kiemtradangnhap());
                     // Lấy giá trị rolename bằng await
                    if (role_name != 'ADMIN') {
                         redirect404();
                     }
                 }else{
                       redirect404();
                    }


            }
    Start();
    }
}
document.addEventListener('DOMContentLoaded', function() {
    Start2();
});
async function Start() {
const adminMenuItems = document.querySelector('.admin-menu');
   const a = adminMenuItems.innerHTML;
   adminMenuItems.innerHTML='';
  if (kiemtradangnhap()) {

    await loadUserInfoSideBox('/sublayout/userinfo');
    loadUserInfo(kiemtradangnhap());
    const role_name = await getRoleName(kiemtradangnhap());
     // Lấy giá trị rolename bằng await


     if (role_name == 'ADMIN') {
         adminMenuItems.innerHTML=a;

     }



  } else {
    loadUserInfoSideBox('/sublayout/user');
  }



}
function redirect404() {
  window.location.href = '/error';
}

//
//async function checkLoginAndLoadUserInfo() {
//    const username = sessionStorage.getItem('username');
//    if (username) {
//        await loadUserInfo(username);
//        const roleName = await getRoleName(username);
//        // Sử dụng roleName và thông tin người dùng để thực hiện xử lý khác
//    } else {
//        loadUserInfoSideBox('/sublayout/user');
//    }
//}

function loadUserInfoSideBox(link) {
  // Sử dụng fetch API để lấy nội dung của tệp tin userinfo.html
  fetch(link)
    .then(response => response.text())
    .then(data => {
      // Gán nội dung vào phần tử có class mt-side-menu
      const mtSideMenu = document.querySelector('.mt-side-menu');
      mtSideMenu.outerHTML = data;
    })
    .catch(error => {
      console.log(error);
    });
}
function loadUserInfo(username) {
  // Sử dụng fetch API để lấy nội dung của tệp tin userinfo.html
  fetch(`http://localhost:9999/api/v1/user/${username}`)
    .then(response => response.json())
    .then(data => {
      // Gán nội dung vào phần tử có class mt-side-menu
          const name = data.name;
          const email = data.email;
          console.log(name + email);
          const usernameElement = $('#mt-side-user-name');
          const emailElement = $('#mt-side-user-email');
          usernameElement.text(name);
          emailElement.text(email);
    })
    .catch(error => {
      console.log(error);
    });
}


  function decodeJwtToken(token) {
      const base64Url = token.split('.')[1];
      const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      const jsonPayload = decodeURIComponent(atob(base64).split('').map((c) => {
          return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      }).join(''));

      return JSON.parse(jsonPayload);
  }
function kiemtradangnhap() {
    // Kiểm tra xem token có tồn tại trong localStorage không
    //if (localStorage.getItem('token')) {
    //  const jwtToken = localStorage.getItem('token') ;
    if (sessionStorage.getItem('token')) {
      const jwtToken = sessionStorage.getItem('token');
        /* console.log(jwtToken);*/
        const decodedPayload = decodeJwtToken(jwtToken);
        const UserName = decodedPayload.sub;
        console.log(UserName);
        return UserName;
    }


}

async function getRoleName(username) {
  try {
    const response = await fetch(`http://localhost:9999/api/v1/user/role/${username}`);
    if (response.ok) {
      const roleName = await response.text();
      return roleName;
    } else {
      throw new Error("User not found");
    }
  } catch (error) {
    console.log(error);
  }
}

function loadForgotPassword() {
 loadUserInfoSideBox('/sublayout/forgotpass');
}
function back(event){
    event.preventDefault();
    loadUserInfoSideBox('/sublayout/user');
     setTimeout(function() {
    addClassToBody("side-col-active"); // Gọi hàm sau 400 milliseconds
    }, 400);
    addClassToBody("side-col-active");
}



