
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Disilab - Register</title>

    <link rel="preconnect" href="https://fonts.gstatic.com/">
    <link href="https://fonts.googleapis.com/css2?family=Oxygen:wght@300;400;500;700&amp;display=swap" rel="stylesheet">

    <link rel="icon" sizes="16x16" href="images/favicon.png">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/line-awesome.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<jsp:include page="layout/preloader.jsp"/>

<jsp:include page="layout/menu.jsp"/>

<section class="sign-up-area pt-80px pb-80px position-relative">
    <div class="container">
        <form name="form-register" id="form-register" class="card card-item login-form">
            <div class="card-body row p-0">
                <div class="col-lg-6">
                    <div class="form-content py-4 pr-60px pl-60px border-right border-right-gray h-100 d-flex align-items-center justify-content-center">
                        <img src="images/undraw-remotely.svg" alt="Image" class="img-fluid">
                    </div>
                </div>
                <div class="col-lg-5 mx-auto">
                    <div class="form-action-wrapper py-5">
                        <div class="form-group">
                            <h3 class="fs-22 pb-3 fw-bold">Tham gia cộng đồng Disilab</h3>
                            <div class="divider"><span></span></div>
                            <p class="pt-3">Hãy cung cấp cho chúng tôi thông tin để khởi tạo tài khoản cho bạn.</p>
                        </div>
                        <p id="content" style="color: red; align-content: center;" class="pt-3">
                        <p style="color: red; align-content: center;" class="pt-3">${sucess}
                        </p>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Tên tài khoản</label>
                            <input id="username" type="text" name="username" class="form-control form--control">
                            <span class="form-message"></span>

                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Họ Tên</label>
                            <input id="name" type="text" name="name" class="form-control form--control">
                            <span class="form-message"></span>

                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Email</label>
                            <input id="email" type="email" name="email" class="form-control form--control">
                            <span class="form-message"></span>
                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Mật khẩu</label>
                            <div class="input-group mb-1">
                                <input class="form-control form--control password-field" type="password" name="password" id="password">
                                <div class="input-group-append">
                                    <button class="btn theme-btn-outline theme-btn-outline-gray toggle-password" type="button">
                                        <svg class="eye-on" xmlns="http://www.w3.org/2000/svg" height="22px" viewBox="0 0 24 24" width="22px" fill="#7f8897"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M12 6c3.79 0 7.17 2.13 8.82 5.5C19.17 14.87 15.79 17 12 17s-7.17-2.13-8.82-5.5C4.83 8.13 8.21 6 12 6m0-2C7 4 2.73 7.11 1 11.5 2.73 15.89 7 19 12 19s9.27-3.11 11-7.5C21.27 7.11 17 4 12 4zm0 5c1.38 0 2.5 1.12 2.5 2.5S13.38 14 12 14s-2.5-1.12-2.5-2.5S10.62 9 12 9m0-2c-2.48 0-4.5 2.02-4.5 4.5S9.52 16 12 16s4.5-2.02 4.5-4.5S14.48 7 12 7z"/></svg>
                                        <svg class="eye-off" xmlns="http://www.w3.org/2000/svg" height="22px" viewBox="0 0 24 24" width="22px" fill="#7f8897"><path d="M0 0h24v24H0V0zm0 0h24v24H0V0zm0 0h24v24H0V0zm0 0h24v24H0V0z" fill="none"/><path d="M12 6c3.79 0 7.17 2.13 8.82 5.5-.59 1.22-1.42 2.27-2.41 3.12l1.41 1.41c1.39-1.23 2.49-2.77 3.18-4.53C21.27 7.11 17 4 12 4c-1.27 0-2.49.2-3.64.57l1.65 1.65C10.66 6.09 11.32 6 12 6zm-1.07 1.14L13 9.21c.57.25 1.03.71 1.28 1.28l2.07 2.07c.08-.34.14-.7.14-1.07C16.5 9.01 14.48 7 12 7c-.37 0-.72.05-1.07.14zM2.01 3.87l2.68 2.68C3.06 7.83 1.77 9.53 1 11.5 2.73 15.89 7 19 12 19c1.52 0 2.98-.29 4.32-.82l3.42 3.42 1.41-1.41L3.42 2.45 2.01 3.87zm7.5 7.5l2.61 2.61c-.04.01-.08.02-.12.02-1.38 0-2.5-1.12-2.5-2.5 0-.05.01-.08.01-.13zm-3.4-3.4l1.75 1.75c-.23.55-.36 1.15-.36 1.78 0 2.48 2.02 4.5 4.5 4.5.63 0 1.23-.13 1.77-.36l.98.98c-.88.24-1.8.38-2.75.38-3.79 0-7.17-2.13-8.82-5.5.7-1.43 1.72-2.61 2.93-3.53z"/></svg>
                                    </button>
                                </div>
                            </div>
                            <span class="form-message"></span>
                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Xác nhận mật khẩu</label>
                            <div class="input-group mb-1">
                                <input class="form-control form--control password-field" type="password" name="repassword" id="repassword">
                                <div class="input-group-append">
                                    <button class="btn theme-btn-outline theme-btn-outline-gray toggle-password" type="button">
                                        <svg class="eye-on" xmlns="http://www.w3.org/2000/svg" height="22px" viewBox="0 0 24 24" width="22px" fill="#7f8897"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M12 6c3.79 0 7.17 2.13 8.82 5.5C19.17 14.87 15.79 17 12 17s-7.17-2.13-8.82-5.5C4.83 8.13 8.21 6 12 6m0-2C7 4 2.73 7.11 1 11.5 2.73 15.89 7 19 12 19s9.27-3.11 11-7.5C21.27 7.11 17 4 12 4zm0 5c1.38 0 2.5 1.12 2.5 2.5S13.38 14 12 14s-2.5-1.12-2.5-2.5S10.62 9 12 9m0-2c-2.48 0-4.5 2.02-4.5 4.5S9.52 16 12 16s4.5-2.02 4.5-4.5S14.48 7 12 7z"/></svg>
                                        <svg class="eye-off" xmlns="http://www.w3.org/2000/svg" height="22px" viewBox="0 0 24 24" width="22px" fill="#7f8897"><path d="M0 0h24v24H0V0zm0 0h24v24H0V0zm0 0h24v24H0V0zm0 0h24v24H0V0z" fill="none"/><path d="M12 6c3.79 0 7.17 2.13 8.82 5.5-.59 1.22-1.42 2.27-2.41 3.12l1.41 1.41c1.39-1.23 2.49-2.77 3.18-4.53C21.27 7.11 17 4 12 4c-1.27 0-2.49.2-3.64.57l1.65 1.65C10.66 6.09 11.32 6 12 6zm-1.07 1.14L13 9.21c.57.25 1.03.71 1.28 1.28l2.07 2.07c.08-.34.14-.7.14-1.07C16.5 9.01 14.48 7 12 7c-.37 0-.72.05-1.07.14zM2.01 3.87l2.68 2.68C3.06 7.83 1.77 9.53 1 11.5 2.73 15.89 7 19 12 19c1.52 0 2.98-.29 4.32-.82l3.42 3.42 1.41-1.41L3.42 2.45 2.01 3.87zm7.5 7.5l2.61 2.61c-.04.01-.08.02-.12.02-1.38 0-2.5-1.12-2.5-2.5 0-.05.01-.08.01-.13zm-3.4-3.4l1.75 1.75c-.23.55-.36 1.15-.36 1.78 0 2.48 2.02 4.5 4.5 4.5.63 0 1.23-.13 1.77-.36l.98.98c-.88.24-1.8.38-2.75.38-3.79 0-7.17-2.13-8.82-5.5.7-1.43 1.72-2.61 2.93-3.53z"/></svg>
                                    </button>
                                </div>
                            </div>
                            <span class="form-message"></span>
                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Xác thực</label>
                        <div id='html_element'></div>
                        </div>
                        <div class="form-group">
                            <button id="check-register" class="btn theme-btn w-100" type="button" onclick="register()">Đăng ký <i class="la la-arrow-right icon ml-1"></i></button>
                        </div>
                        <p class="fs-13 lh-18 pb-3">Tôi đồng ý với <a href="terms-and-conditions.html" class="text-color hover-underline">điều khoản dịch vụ</a> và <a href="privacy-policy.html" class="text-color hover-underline">chính sách quyền riêng tư</a>.</p>
                    </div>
                </div>
            </div>
        </form>
        <p class="text-black text-center fs-15">Bạn đã có tài khoản? <a href="login" class="text-color hover-underline">Đăng nhập</a></p>
    </div>
    <div class="position-absolute top-0 left-0 w-100 h-100 z-index-n1">
        <svg class="w-100 h-100" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M1200 120L0 16.48 0 0 1200 0 1200 120z" fill="#2d86eb" opacity="0.06"></path>
        </svg>
    </div>
</section>


<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/main.js"></script>
<script src="js/sweetalert.js"></script>
<script src="js/controller.js"></script>
<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script>
<script src="./js/validate.js" ></script>

<script>
    Validator({
        form: '#form-register',
        formGroupSelector: '.form-group',
        errorSelector: '.form-message',
        rules: [
            Validator.isRequired('#username'),
            Validator.isRequired('#name'),
            Validator.isRequired('#email'),
            Validator.isEmail('#email'),
            Validator.isRequired('#password'),
            Validator.minLength('#password', 8),
            Validator.isRequired('#repassword'),
            Validator.isConfirmed('#repassword', function () {
                return document.querySelector('#form-register #password').value
            }, 'Mật khẩu phải trùng với mật khẩu đã nhập'),
        ]
    })

</script>
</body>
</html>
