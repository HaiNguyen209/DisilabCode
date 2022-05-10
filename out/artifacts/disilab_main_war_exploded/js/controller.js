//function for login
function login() {
    var msg = null;
    document.getElementById("content").innerHTML = ""; // reset content show error
    document.getElementById('check-login').disabled = true; // disable button login while the system is authenticating
    $.ajax({
        url: 'dang-nhap',
        type: 'POST',
        data: $('#form-login').serialize(), // get data in form login
        dataType: 'JSON',
        success: function (data) {
            // after check auth sucess get message from controller and check
            document.getElementById('check-login').disabled = false;
            msg = data[0].msg
            switch (msg) {
                case 'error':
                    document.getElementById("content").innerHTML = "Email hoặc mật khẩu không đúng!";
                    break;
                case 'status':
                    document.getElementById("content").innerHTML = "Tài khoản đã bị khóa!";
                    break;
                default:
                    document.getElementById("content").innerHTML = "login thành công!";
            }
        },
        // get error
        error: function (xhr) {
            Swal.fire({
                confirmButtonColor: '#396cf0',
                icon: "error",
                text: xhr.status + " : " + xhr.responseText,
                type: "error"
            })
        }
    });
}

function onSignIn(googleUser) {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut()
    var profile = googleUser.getBasicProfile();
    $.ajax({
        url: 'dang-nhap?google',
        type: 'POST',
        data: {
            email: profile.getEmail(),
            token: googleUser.getAuthResponse().id_token
        },
        dataType: 'JSON',
        success: function (data) {
            msg = data[0].msg
            switch (msg) {
                case 'error':
                    document.getElementById("content").innerHTML = "Email không tồn tại. Hãy đăng ký!";
                    break;
                case 'status':
                    document.getElementById("content").innerHTML = "Tài khoản đã bị khóa!";
                    break;
                default:
                    document.getElementById("content").innerHTML = "login thành công!";
            }
        },
        error: function (xhr) {
            Swal.fire({
                confirmButtonColor: '#396cf0',
                icon: "error",
                text: xhr.status + " : " + xhr.responseText,
                type: "error"
            })
        }
    });
}

document.getElementById('check-register').disabled = true;

var onloadCallback = function() {
    grecaptcha.render('html_element', {
        'sitekey' : '6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI',
        'callback' : correctCaptcha
    });
};
var correctCaptcha = function(response) {
    document.getElementById('check-register').disabled = false;
};


//function for register
function register() {
    var msg = null;
    document.getElementById("content").innerHTML = "";
    document.getElementById('check-register').disabled = true;
    $.ajax({
        url: 'dang-ky',
        type: 'POST',
        data: $('#form-register').serialize(),
        dataType: 'JSON',
        beforeSend: function () {
            Swal.fire({
                title: "Khởi tạo tài khoản",
                showConfirmButton: false,
                allowOutsideClick: false,
                allowEscapeKey: false
            });
            Swal.showLoading();
        },
        success: function (data) {
            document.getElementById('check-register').disabled = false;
            msg = data[0].msg
            switch (msg) {
                case 'error':
                    document.getElementById("content").innerHTML = "Email đã tồn tại!";
                    break;
                default:
                    Swal.fire({
                        confirmButtonColor: '#396cf0',
                        icon: "success",
                        text: "Link xác thực đã được gửi đến email của bạn!",
                        type: "success"
                    })
            }
        },
        // get error
        error: function (xhr) {
            Swal.fire({
                confirmButtonColor: '#396cf0',
                icon: "error",
                text: xhr.status + " : " + xhr.responseText,
                type: "error"
            })
        }
    });
}

function ask(){
    var msg = null;
    var data = {};
    var formData = $('#form-ask').serializeArray();
    $.each(formData, function (i, v){
        data["" + v.name + ""] = v.value;
    });
    data["detail"] = editor.getData();
    $.ajax({
        url: 'hoi-dap',
        type: 'POST',
        data: data,
        dataType: 'JSON',
        beforeSend: function () {
            Swal.fire({
                title: "Đang khởi tạo câu hỏi",
                showConfirmButton: false,
                allowOutsideClick: false,
                allowEscapeKey: false
            });
            Swal.showLoading();
        },
        success: function (data) {
            msg = data[0].msg
            switch (msg) {
                case 'success':
                    Swal.fire({
                        confirmButtonColor: '#396cf0',
                        icon: "success",
                        text: "Đăng câu hỏi thành công",
                        type: "success"
                    })
                    break;
                default:
                    Swal.fire({
                        confirmButtonColor: '#396cf0',
                        icon: "error",
                        text: "Lỗi",
                        type: "error"
                    })
            }
        },
        error: function (xhr) {
            Swal.fire({
                confirmButtonColor: '#396cf0',
                icon: "error",
                text: xhr.status + " : " + xhr.responseText,
                type: "error"
            })
        }
    });
}