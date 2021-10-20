function validateRegister() {
    var name = document.registerForm.txtName.value;
    var phone = document.registerForm.txtPhone.value;
    var address = document.registerForm.txtAddress.value;
    var email = document.registerForm.txtEmail.value;
    var password = document.registerForm.txtPassword.value;
    var confirm = document.registerForm.txtConfirm.value;

    if (name === null || name === "") {
        alert("Name can't be left blank!");
        return false;
    }
    if (name.length > 100 || name.length < 6) {
        alert("Name must be more than 6 characters and less than 100 characters!");
        return false;
    }
    function isVietnamesePhoneNumber(phone) {
        return /([\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\b/.test(phone);
    }
    if (!isVietnamesePhoneNumber(phone)) {
        alert("Incorrect phone number!");
        return false;
    }
    if (address === null || address === "") {
        alert("Address can't be left blank!");
        return false;
    }
    if (address.leng > 200) {
        alert("Name must be  less than 200 characters!");
        return false;
    }
    if (email === null || email === "") {
        alert("Email can't be left blank!");
        return false;
    }
    if (email.length > 100 || email.length < 16) {
        alert("Email must be more than 6 characters and less than 100 characters!");
        return false;
    }
    if (password === null || password === "" || password.length < 6) {
        alert("Password more than 6 characters!!!");
        return false;
    }
    if (confirm === null || confirm === "") {
        alert("Confirm password can't be left blank!");
        return false;
    }
    if (password !== confirm) {
        alert("Comfirm password incorrect!");
        return false;
    }
}
//
//function validateFormComment() {
//    var comment = document.commentForm.txtComment.value;
//    if (comment === null || comment === "") {
//        alert("Comments can't be left blank!!!");
//        return false;
//    }
//    if (comment > 50) {
//        alert("Comment less than 50 words!");
//        return false;
//    }
//}
//
//function validatePost() {
//    var tital = document.postForm.txtTital.value.trim();
//    var shortDescription = document.postForm.txtShortDescription.value;
//    var contentArticle = document.postForm.txtContentArticle.value;
//    if (tital === null || tital === "") {
//        alert("Tital can't be left blank!!!");
//        return false;
//    }
//    if (test === null || test === "") {
//        alert("Tital can't be left blank!!!");
//        return false;
//    }
//    if (tital.length > 100) {
//        alert("Tital less than 100 words!");
//        return false;
//    }
//    if (shortDescription === null || shortDescription === "") {
//        alert("Short Description can't be left blank!!!");
//        return false;
//    }
//    if (shortDescription.length > 500) {
//        alert("Short Description less than 100 words!");
//        return false;
//    }
//    if (contentArticle === null || contentArticle === "") {
//        alert("Tital can't be left blank!!!");
//        return false;
//    }
//}

function validateLogin() {
    var email = document.loginForm.txtEmail.value.trim();
    if (email === null || email === "") {
        return false;
    }
}