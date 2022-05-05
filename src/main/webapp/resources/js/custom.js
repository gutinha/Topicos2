$(document).delegate('header .menu-btn','click',function(event){event.preventDefault();
jQuery('header nav').toggleClass('show');});
$(document).delegate('#close-cookies','click',function(event){event.preventDefault();
jQuery('.modal-cookie').addClass('d-none');});
$(function(){$('[data-bs-toggle="tooltip"]').tooltip({container:'.page'})
$(".grt-cookie").grtCookie({duration:90,});})