<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.gstatic.com/">
    <link href="https://fonts.googleapis.com/css2?family=Oxygen:wght@300;400;500;700&amp;display=swap" rel="stylesheet">
    <meta name="google-signin-client_id"
          content="446529260408-aus9kg95ljnhs0rnm9e638v2qs8mhl07.apps.googleusercontent.com">
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

<section class="login-area pt-80px pb-80px position-relative">
    <div class="shape-bg position-absolute top-0 left-0 w-100 h-100 opacity-2 z-index-n1"></div>
    <div class="container">
        <form name="form-login" id="form-login" class="card card-item login-form">
            <div class="card-body row p-0">
                <div class="col-lg-6">
                    <div class="form-content py-4 pr-60px pl-60px border-right border-right-gray h-100 d-flex align-items-center justify-content-center">
                        <img src="images/undraw-remotely.svg" alt="Image" class="img-fluid">
                    </div>
                </div>
                <div class="col-lg-5 mx-auto">
                    <div class="form-action-wrapper py-5">
                        <div class="form-group">
                            <h3 class="fs-22 pb-3 fw-bold">Đăng nhập</h3>
                            <div class="divider"><span></span></div>
                            <p id="content" style="color: red; align-content: center;" class="pt-3">
                            </p>
                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Email</label>
                            <input type="email" name="email" class="form-control form--control"
                                   placeholder="Email address">
                        </div>
                        <div class="form-group">
                            <label class="fs-14 text-black fw-medium lh-18">Mật khẩu</label>
                            <div class="input-group">
                                <input class="form-control form--control password-field" type="password" name="password"
                                       placeholder="Password">
                                <div class="input-group-append">
                                    <button class="btn theme-btn-outline theme-btn-outline-gray toggle-password"
                                            type="button">
                                        <svg class="eye-on" xmlns="http://www.w3.org/2000/svg" height="22px"
                                             viewBox="0 0 24 24" width="22px" fill="#a1a1a1">
                                            <path d="M0 0h24v24H0V0z" fill="none"/>
                                            <path d="M12 6c3.79 0 7.17 2.13 8.82 5.5C19.17 14.87 15.79 17 12 17s-7.17-2.13-8.82-5.5C4.83 8.13 8.21 6 12 6m0-2C7 4 2.73 7.11 1 11.5 2.73 15.89 7 19 12 19s9.27-3.11 11-7.5C21.27 7.11 17 4 12 4zm0 5c1.38 0 2.5 1.12 2.5 2.5S13.38 14 12 14s-2.5-1.12-2.5-2.5S10.62 9 12 9m0-2c-2.48 0-4.5 2.02-4.5 4.5S9.52 16 12 16s4.5-2.02 4.5-4.5S14.48 7 12 7z"/>
                                        </svg>
                                        <svg class="eye-off" xmlns="http://www.w3.org/2000/svg" height="22px"
                                             viewBox="0 0 24 24" width="22px" fill="#a1a1a1">
                                            <path d="M0 0h24v24H0V0zm0 0h24v24H0V0zm0 0h24v24H0V0zm0 0h24v24H0V0z"
                                                  fill="none"/>
                                            <path d="M12 6c3.79 0 7.17 2.13 8.82 5.5-.59 1.22-1.42 2.27-2.41 3.12l1.41 1.41c1.39-1.23 2.49-2.77 3.18-4.53C21.27 7.11 17 4 12 4c-1.27 0-2.49.2-3.64.57l1.65 1.65C10.66 6.09 11.32 6 12 6zm-1.07 1.14L13 9.21c.57.25 1.03.71 1.28 1.28l2.07 2.07c.08-.34.14-.7.14-1.07C16.5 9.01 14.48 7 12 7c-.37 0-.72.05-1.07.14zM2.01 3.87l2.68 2.68C3.06 7.83 1.77 9.53 1 11.5 2.73 15.89 7 19 12 19c1.52 0 2.98-.29 4.32-.82l3.42 3.42 1.41-1.41L3.42 2.45 2.01 3.87zm7.5 7.5l2.61 2.61c-.04.01-.08.02-.12.02-1.38 0-2.5-1.12-2.5-2.5 0-.05.01-.08.01-.13zm-3.4-3.4l1.75 1.75c-.23.55-.36 1.15-.36 1.78 0 2.48 2.02 4.5 4.5 4.5.63 0 1.23-.13 1.77-.36l.98.98c-.88.24-1.8.38-2.75.38-3.79 0-7.17-2.13-8.82-5.5.7-1.43 1.72-2.61 2.93-3.53z"/>
                                        </svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="form-group d-flex align-items-center justify-content-between">
                            <a href="recover-password.html" class="btn-text fs-14 hover-underline fw-regular">Quên mật
                                khẩu ?</a>
                        </div>
                        <div class="form-group">
                            <button id="check-login" class="btn theme-btn w-100" type="button" onclick="login()">Đăng
                                nhập <i class="la la-arrow-right icon ml-1"></i></button>
                        </div>
                        <div class="social-icon-box">
                            <div class="pb-3 d-flex align-items-center">
                                <hr class="flex-grow-1 border-top-gray">
                                <span class="mx-2 text-gray-2 fw-medium text-uppercase fs-14"></span>
                                <hr class="flex-grow-1 border-top-gray">
                            </div>
                            <%--                            <button class="g-signin2 btn theme-btn google-btn d-flex align-items-center justify-content-center w-100 mb-2 " type="button" data-onsuccess="onSignIn">--%>
                            <%--                                <span class="btn-icon"><svg focusable="false" width="16px" height="16px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 488 512"><path fill="currentColor" d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"></path></svg></span>--%>
                            <%--                                <span class="flex-grow-1">Đăng nhập bằng Google</span>--%>
                            <%--                            </button>--%>
                            <div class="g-signin2" data-onsuccess="onSignIn"></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <p class="text-black text-center fs-15">Chưa có tài khoản? <a href="dang-ky" class="text-color hover-underline">Đăng
            ký</a></p>
    </div>
</section>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/main.js"></script>
<script src="js/sweetalert.js"></script>
<script src="js/controller.js" async defer></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
</body>
</html>