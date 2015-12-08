<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 11/30/2015
  Time: 2:17 PM
  Bootstrap html and css snippet from https://gist.github.com/bMinaise/7329874 - edited to remove the "need help?" link,
  "remember me" checkbox, and to link to my log in page. Altered title and button label, and added a password confirm
  field, to convert the log in page to a sign up page. Changed "Email" to "Username", and edited attributes
  to allow JAAS integration. Replaced the profile image, added a border, and made it a larger square instead of round.
  Altered css to base button-input spacing on the button, not the password field, to avoid weird spacing on the sign up
  page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/imports/head.jsp" />
    <title>Sign Up</title>
  <link rel="stylesheet" type="text/css" href="/imports/login.css" />
    <style>
        img
        {
            -moz-transform: scaleX(-1);
            -o-transform: scaleX(-1);
            -webkit-transform: scaleX(-1);
            transform: scaleX(-1);
            -ms-filter: "FlipH";
        }
    </style>
    <!-- above CSS snippet from https://css-tricks.com/snippets/css/flip-an-image/, with outdated filter tag removed -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="/imports/javascript/newUserValidation.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign Up</h1>
            <div class="account-wall">
                <img class="profile-img" src="/imports/images/catLineartMakoZune.PNG"
                     alt="Generously created and licensed for reuse by Mako-Zune on DeviantArt">
                <form class="form-signin">
                    <input type="text" class="form-control" placeholder="Username" required autofocus>
                    <input type="password" class="form-control" placeholder="Password" required>
                    <input type="password" class="form-control" placeholder="Confirm Password" required>
                    <button id="registerButton" class="btn btn-lg btn-block" type="submit">
                        Register</button>
                </form>
            </div>
            <a href="/login.jsp" class="text-center new-account">Already have an account? Sign in!</a>
        </div>
    </div>
</div>
</body>
</html>
