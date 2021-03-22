/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showPageElement(what)
{
    var obj = typeof what == 'object'
        ? what : document.getElementById(what);

    obj.style.display = 'block';
    document.getElementById('yesButton').style.display = 'none';
    document.getElementById('noButton').style.display = 'none';
    
    return false;
}

function toggleVisibility(div) {
    var x = document.getElementById(div);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}