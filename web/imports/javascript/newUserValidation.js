/**
 * Created by Student on 12/1/2015.
 */

$(document).ready(function() {
    $('#registerButton').on("click", function(){
        validate();
    });
})

function validate() {
    //check if username contains spaces - if so, reject and force resubmit
    //check if username length > I dunno, 8?
    //check if passwords match and if passwords are longer than 8 chars
    alert("validating!");
}